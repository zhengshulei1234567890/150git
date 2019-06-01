package com.baizhi.dao;

import com.baizhi.entity.Orders;

import java.util.List;



public interface OrderDao {

	//订单管理
	public List<Orders> queryAllOrders();
	public Orders queryOrder(String id);
	
	
	
	public void addOrder(Orders order);
}