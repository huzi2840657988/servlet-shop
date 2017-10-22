package com.zl.serviceImpl;

import java.util.List;

import com.zl.bean.Bill;
import com.zl.dao.IBillDao;
import com.zl.daoImpl.BillDaoImpl;
import com.zl.service.IBillService;
import com.zl.util.PageUtil;

public class BillServiceImpl implements IBillService{
	private IBillDao billDao = new BillDaoImpl();
	@Override
	public List<Bill> queryAll(Integer page) {
		//账单index计算根据page
		int index = (page-1)*PageUtil.BILL_PAGE_NUM;
		return billDao.queryAll(index);
	}
	/**
	 * 查询信息条数
	 */
	@Override
	public Integer queryAllCount() {
		return billDao.queryAllCount();
	}

}
