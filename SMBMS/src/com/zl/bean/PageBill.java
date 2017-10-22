package com.zl.bean;

import java.util.List;

public class PageBill {
	// 页数量
	private Integer pageNum;
	// 每页要显示的新闻
	private List<Bill> list;
	// 当前页
	private Integer nowPage;
    //
	public static  Integer count=25;
	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public List<Bill> getList() {
		return list;
	}

	public void setList(List<Bill> list) {
		this.list = list;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
}
