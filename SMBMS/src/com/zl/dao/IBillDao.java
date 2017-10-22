package com.zl.dao;

import java.util.List;

import com.zl.bean.Bill;
import com.zl.bean.SmbmsUser;

/**
 * 账单DAO接口
 */
public interface IBillDao {
	/**
	 * 查询所有账单
	 */
	public List<Bill> queryAll(Integer index);
	/**
	 * 查询所有账单数量
	 */
	public Integer queryAllCount();
}
