package com.zl.bean;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 对应数据库中的smbms_user表
 * 实现了HttpSessionBindingListener接口
 * "
 */
public class SmbmsUser{
	private Integer userId;
	private String name;
	private String loginName;
	private String loginPwd;
	private Integer gender;//性别: 0:男 1:女
	private Date birthdate;
	private String phone;
	private String addree;
	private Integer userType;//用户类别 0:普通用户 1:管理员 2:经理
	private Integer age;//年龄
	public SmbmsUser(){
		
	}
	public SmbmsUser(String loginName,String loginPwd){
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}
	public SmbmsUser(Integer userId, String name, String loginName,
			String loginPwd, Integer gender, Date birthdate, String phone,
			String addree, Integer userType) {
		super();
		this.userId = userId;
		this.name = name;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.gender = gender;
		this.birthdate = birthdate;
		this.phone = phone;
		this.addree = addree;
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
		//计算年龄
		this.age = birthDateToAge(birthdate);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddree() {
		return addree;
	}

	public void setAddree(String addree) {
		this.addree = addree;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 传入生日返回年龄
	 * @param birthdate
	 * @return
	 */
	private int birthDateToAge(Date birthdate) {
		long current = System.currentTimeMillis();// 当前时间
		long userBirth = birthdate.getTime(); // 用户的出生日期
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Date(current - userBirth));
		cl.set(Calendar.YEAR, cl.get(Calendar.YEAR) - 1970);
		return cl.get(Calendar.YEAR);
	}
}
