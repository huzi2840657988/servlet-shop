package com.zl.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zl.bean.Bill;
import com.zl.bean.SmbmsUser;
import com.zl.dao.BaseDao;
import com.zl.dao.IBillDao;
import com.zl.util.PageUtil;

public class BillDaoImpl extends BaseDao implements IBillDao{

	@Override
	public List<Bill> queryAll(Integer index) {
		List<Bill> list = new ArrayList<Bill>();
		Connection con = this.getConnection();
		String sql = "SELECT `id`,`tradeName`,`supplier`,`amount`,`payment`,`createDate` FROM `bill` limit ?,? ;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, index);
			ps.setInt(2, PageUtil.BILL_PAGE_NUM);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setId(rs.getInt(1));
				bill.setTradeName(rs.getString(2));
				bill.setSupplier(rs.getString(3));
				bill.setAmount(rs.getString(4));
				bill.setPayment(rs.getInt(5));
				bill.setCreateDate(rs.getTimestamp(6));
				list.add(bill);
			}
			this.close(con, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer queryAllCount() {
		Integer  count = 0;
		Connection con = this.getConnection();
		String sql = "SELECT count(1) FROM `bill`;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
			this.close(con, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
