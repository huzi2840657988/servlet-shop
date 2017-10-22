package com.zl.dao;

import java.util.List;

import com.zl.bean.SmbmsUser;

public interface ISmbmsUserDao {
	/**
	 * 根据用户名和密码查询用户对象 返回null用户不存在
	 */
	public SmbmsUser queryUser(SmbmsUser user);
	/**
	 * 根据用户名查询用户对象 返回null用户不存在
	 */
	public SmbmsUser queryLoginName(String loginName);
	/**
	 * 根据用户id查询用户对象 返回null用户不存在
	 */
	public SmbmsUser queryUserId(Integer id);
	/**
	 * 查询所有用户
	 */
	public List<SmbmsUser> queryAll();
	/**
	 *	根据用户名模糊查询
	 */
	public List<SmbmsUser> queryLike(String name);
	/**
	 * 添加用户
	 */
	public boolean addUser(SmbmsUser user);
	/**
	 * 根据id删除
	 */
	public boolean deleteById(Integer id);
	/**
	 * 修改用户
	 */
	public boolean updateUser(SmbmsUser user);
	/**
	 *重置
	 */
	public boolean updatePasswordDef(Integer id);
	/**
	 *修改密码
	 */
	public boolean updatePassword(Integer id,String newPwd);
}
