package com.baizhi.Service;

import com.baizhi.entity.Orders;

import java.util.List;


public interface OrdersService {
	//订单管理
	public List<Orders> queryAllOrders();
	public Orders queryOrder(String id);

}
