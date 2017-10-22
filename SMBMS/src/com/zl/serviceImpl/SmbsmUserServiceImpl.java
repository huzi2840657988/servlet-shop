package com.zl.serviceImpl;

import java.util.List;

import com.zl.bean.Message;
import com.zl.bean.SmbmsUser;
import com.zl.dao.ISmbmsUserDao;
import com.zl.daoImpl.SmbmsUserDaoImpl;
import com.zl.service.ISmbsmUserService;

public class SmbsmUserServiceImpl implements ISmbsmUserService {
	//多态
	private ISmbmsUserDao userDao = new SmbmsUserDaoImpl();
	//该用户如果不存在返回的是null
	@Override
	public SmbmsUser validateUser(SmbmsUser user) {
		return userDao.queryUser(user);
	}
	@Override
	public List<SmbmsUser> queryAll() {
		return userDao.queryAll();
	}
	/**
	 * 1:用户已存在则提示“用户已存在”并返回到添加页面
	 * 2:如果添加成功则提示"添加成功"并显示所有的用户信息
	 * 3:如果添加失败则提示"添加失败,请重新尝试或联系系统管理员"返回到添加页面
	 */
	@Override
	public Message addUser(SmbmsUser user) {
		Message msg = new Message();
		SmbmsUser queryUser =  userDao.queryLoginName(user.getLoginName());
		if(queryUser==null){
			boolean isOk = userDao.addUser(user);
			if(isOk){
				//如果添加成功则提示"添加成功"并显示所有的用户信息
				msg.setMsg("添加成功");
				msg.setUrl("userQueryAll");
			}else{
				//如果添加失败则提示"添加失败,请重新尝试或联系系统管理员"返回到添加页面
				msg.setMsg("添加失败,请重新尝试或联系系统管理员");
				msg.setUrl("user/userAdd.jsp");
			}
		}else{
			//用户已存在则提示“用户已存在”并返回到添加页面
			msg.setMsg("用户已存在!请重新输入");
			msg.setUrl("user/userAdd.jsp");
		}
		return msg;
	}
	@Override
	public SmbmsUser queryUserId(Integer id) {
		return userDao.queryUserId(id);
	}
	
	@Override
	public Message deleteById(Integer id) {
		Message msg = new Message();
		if(userDao.deleteById(id)){
			msg.setMsg("删除成功!");
			msg.setUrl("userQueryAll");
		}else{
			msg.setMsg("删除失败!");
			msg.setUrl("userQueryById?id="+id);
		}
		return msg;
	}
	@Override
	public Message updateUser(SmbmsUser user) {
		Message msg = new Message();
		if(userDao.updateUser(user)){
			msg.setMsg("修改成功!");
			msg.setUrl("userQueryAll");
		}else{
			msg.setMsg("修改失败!");
			msg.setUrl("userQueryById?id="+user.getUserId()+"&menu=update");
		}
		return msg;
	}
	@Override
	public Message updatePasswordDef(Integer id) {
		Message msg = new Message();
		if(userDao.updatePasswordDef(id)){
			msg.setMsg("重置成功!");
			msg.setUrl("userQueryAll");
		}else{
			msg.setMsg("重置失败!");
			msg.setUrl("userQueryById?id="+id);
		}
		return msg;
	}
	@Override
	public List<SmbmsUser> queryLike(String name) {
		return userDao.queryLike(name);
	}
	@Override
	public Message updatePassword(SmbmsUser user, String newPwd,String oldPwd) {
		Message msg = new Message();
		/**
		 * 旧密码要和当前用户的一致。
		 * 才可以去修改新密码
		 */
		if(oldPwd.equals(user.getLoginPwd())){
			boolean isOk = userDao.updatePassword(user.getUserId(), newPwd);
			if(isOk){
				msg.setMsg("修改成功!");
				msg.setUrl("login.jsp");
			}else{
				msg.setMsg("修改失败!");
				msg.setUrl("user/updatePwd.jsp");
			}
		}else{
			msg.setMsg("输入的旧密码不对");
			msg.setUrl("user/updatePwd.jsp");
		}
		return msg;
	}
	
}
