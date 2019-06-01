package com.baizhi.action;

import java.util.List;

import com.baizhi.Service.OrdersService;
import com.baizhi.serviceImpl.OrderServiceImpl;
import com.baizhi.entity.Orders;
import org.apache.struts2.ServletActionContext;


public class OrderAction {
	 //private OrdersService os=new OrderServiceImpl();
	private String id;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String queryAllOrder(){
	//调用订单业务层查询所有订单集合
		 OrdersService os=new OrderServiceImpl();
		 List<Orders> list = os.queryAllOrders();
		//把集合存到request
		 ServletActionContext.getRequest().setAttribute("list", list);
		//流程跳转
		return "orderquery";
		
	}	
	public String queryOrder(){
		OrdersService os=new OrderServiceImpl();
		Orders order = os.queryOrder(id);
		ServletActionContext.getRequest().setAttribute("order", order);
		return "ok";

	}
}
	
	//收集当前订单id
	//处理请求
	//public String querydetialOrder(){
	//调用查询订单详情方法，返回订单对象
	//Order order=os.querydetailOrder(id);	
	//把当前订单对象存入ruquest
	//流程跳转
//}
