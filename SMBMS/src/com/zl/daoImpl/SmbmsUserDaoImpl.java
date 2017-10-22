package com.zl.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zl.bean.SmbmsUser;
import com.zl.dao.BaseDao;
import com.zl.dao.ISmbmsUserDao;
import com.zl.util.UserUtil;

public class SmbmsUserDaoImpl extends BaseDao implements ISmbmsUserDao {

	/**
	 * 根据用户名和密码查询用户对象 返回null用户不存在
	 */
	@Override
	public SmbmsUser queryUser(SmbmsUser paramUser) {
		Connection con = this.getConnection();
		String sql = "SELECT * FROM smbms_user WHERE loginname = ? and loginpwd = ?";
		SmbmsUser user = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, paramUser.getLoginName());
			ps.setObject(2, paramUser.getLoginPwd());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new SmbmsUser();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setLoginName(rs.getString(3));
				user.setLoginPwd(rs.getString(4));
				user.setGender(rs.getInt(5));
				user.setBirthdate(rs.getTimestamp(6));
				user.setPhone(rs.getString(7));
				user.setAddree(rs.getString(8));
				user.setUserType(rs.getInt(9));
			}
			this.close(con, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<SmbmsUser> queryAll() {
		List<SmbmsUser> list = new ArrayList<SmbmsUser>();
		Connection con = this.getConnection();
		String sql = "SELECT `userid`,`name`,`loginname`,`gender`,`birthdate`,`phone`,`usertype` FROM smbms_user";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SmbmsUser user = new SmbmsUser();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setLoginName(rs.getString(3));
				user.setGender(rs.getInt(4));
				user.setBirthdate(rs.getTimestamp(5));
				user.setPhone(rs.getString(6));
				user.setUserType(rs.getInt(7));
				list.add(user);// 添加到list
			}
			this.close(con, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addUser(SmbmsUser user) {
		Connection con = this.getConnection();
		String sql = "INSERT INTO `smbms_user`(`name`,`loginname`,`loginpwd`,`gender`,`birthdate`,`phone`,`addree`,`usertype`)VALUES (?,?,?,?,?,?,?,?);";
		boolean isOk = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, user.getName());
			ps.setObject(2, user.getLoginName());
			ps.setObject(3, user.getLoginPwd());
			ps.setObject(4, user.getGender());
			ps.setObject(5, user.getBirthdate());
			ps.setObject(6, user.getPhone());
			ps.setObject(7, user.getAddree());
			ps.setObject(8, user.getUserType());
			int rs = ps.executeUpdate();
			if (rs > 0) {
				isOk = true;
			}
			this.close(con, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return isOk;
		}

	}

	@Override
	public SmbmsUser queryLoginName(String loginName) {
		Connection con = this.getConnection();
		String sql = "SELECT * FROM smbms_user WHERE loginname = ?";
		SmbmsUser user = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, loginName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new SmbmsUser();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setLoginName(rs.getString(3));
				user.setLoginPwd(rs.getString(4));
				user.setGender(rs.getInt(5));
				user.setBirthdate(rs.getTimestamp(6));
				user.setPhone(rs.getString(7));
				user.setAddree(rs.getString(8));
				user.setUserType(rs.getInt(9));
			}
			this.close(con, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public SmbmsUser queryUserId(Integer id) {
		Connection con = this.getConnection();
		String sql = "SELECT * FROM smbms_user WHERE userid = ?";
		SmbmsUser user = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new SmbmsUser();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setLoginName(rs.getString(3));
				user.setLoginPwd(rs.getString(4));
				user.setGender(rs.getInt(5));
				user.setBirthdate(rs.getTimestamp(6));
				user.setPhone(rs.getString(7));
				user.setAddree(rs.getString(8));
				user.setUserType(rs.getInt(9));
			}
			this.close(con, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean deleteById(Integer id) {
		Connection con = this.getConnection();
		String sql = "DELETE FROM smbms_user WHERE userid = ?";
		boolean isOk = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, id);
			int rs = ps.executeUpdate();
			if(rs>0){
				isOk = true;
			}
			this.close(con, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isOk;
	}

	@Override
	public boolean updateUser(SmbmsUser user) {
		Connection con = this.getConnection();
		String sql = "UPDATE `smbms_user` SET `name` = ?,`gender` =?,`birthdate` = ?,`phone` =?,`addree` =?,`usertype`=? WHERE `userid`=?;";
		boolean isOk = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, user.getName());
			ps.setObject(2, user.getGender());
			ps.setObject(3, user.getBirthdate());
			ps.setObject(4, user.getPhone());
			ps.setObject(5, user.getAddree());
			ps.setObject(6, user.getUserType());
			ps.setObject(7, user.getUserId());
			int rs = ps.executeUpdate();
			if (rs > 0) {
				isOk = true;
			}
			this.close(con, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return isOk;
		}
	}

	@Override
	public boolean updatePasswordDef(Integer id) {
		Connection con = this.getConnection();
		String sql = "UPDATE `smbms_user` SET `loginpwd` = ? WHERE `userid`=?;";
		boolean isOk = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, UserUtil.DEFAULT_PASSWORD);
			ps.setObject(2, id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				isOk = true;
			}
			this.close(con, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return isOk;
		}
	}

	@Override
	public List<SmbmsUser> queryLike(String name) {
		List<SmbmsUser> list = new ArrayList<SmbmsUser>();
		Connection con = this.getConnection();
		String sql = "SELECT `userid`,`name`,`loginname`,`gender`,`birthdate`,`phone`,`usertype` FROM smbms_user WHERE `name` like ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, "%"+name+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SmbmsUser user = new SmbmsUser();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setLoginName(rs.getString(3));
				user.setGender(rs.getInt(4));
				user.setBirthdate(rs.getTimestamp(5));
				user.setPhone(rs.getString(6));
				user.setUserType(rs.getInt(7));
				list.add(user);// 添加到list
			}
			this.close(con, ps, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updatePassword(Integer id, String newPwd) {
		Connection con = this.getConnection();
		String sql = "UPDATE `smbms_user` SET `loginpwd` = ? WHERE `userid`=?;";
		boolean isOk = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, newPwd);
			ps.setObject(2, id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				isOk = true;
			}
			this.close(con, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return isOk;
		}
	}
}
