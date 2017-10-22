package com.zl.service;

import java.util.List;

import com.zl.bean.Bill;

public interface IBillService {
	/**
	 * 查询所有账单
	 */
	public List<Bill> queryAll(Integer index);
	
	/**
	 * 查询有多少条
	 */
	public Integer queryAllCount();
}
