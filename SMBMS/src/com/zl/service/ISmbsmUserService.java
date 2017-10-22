package com.zl.service;

import java.util.List;

import com.zl.bean.Message;
import com.zl.bean.SmbmsUser;

public interface ISmbsmUserService {
	/**
	 * 验证用户
	 */
	public SmbmsUser validateUser(SmbmsUser user);

	/**
	 * 查询所有用户
	 */
	public List<SmbmsUser> queryAll();
	/**
	 *	根据用户名模糊查询
	 */
	public List<SmbmsUser> queryLike(String name);

	/**
	 * 添加 如果用户名一致(和数据库中已存在的).
	 * 不可以添加 反之可以添加
	 */
	public Message addUser(SmbmsUser user);
	public SmbmsUser queryUserId(Integer id);
	/**
	 * 根据id删除
	 */
	public Message deleteById(Integer id);
	/**
	 * 修改用户
	 */
	public Message updateUser(SmbmsUser user);
	/**
	 *重置
	 */
	public Message updatePasswordDef(Integer id);
	/**
	 *修改密码
	 */
	public Message updatePassword(SmbmsUser user,String newPwd,String oldPwd);
}
