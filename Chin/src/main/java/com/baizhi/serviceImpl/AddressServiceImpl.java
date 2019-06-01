package com.baizhi.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.BookDao;
import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.*;
import com.baizhi.Service.AddressService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;



public class AddressServiceImpl implements AddressService {
	//添加进购物车
	@Override
	public List<Address> addressID(String id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressDao ad = sqlSession.getMapper(AddressDao.class);
        //AddressDao ad= (AddressDao) MybatisUtil.getMapper(AddressDao.class);
		List<Address> list = ad.addressID(id);
		return list;
		
	}
	//确认订单
	@Override
	public Address addressByID(String id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressDao ad = sqlSession.getMapper(AddressDao.class);
		//AddressDao ad= (AddressDao) MybatisUtil.getMapper(AddressDao.class);
		Address address = ad.addressByID(id);
		return address;
	}
	//订单完成
	@Override
	public void addressQuery(Address address) {
		//获取session中用户对象
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		//获取session中的购物车
		Cart cart =(Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AddressDao ad = sqlSession.getMapper(AddressDao.class);
		//AddressDao ad= (AddressDao)MybatisUtil.getMapper(AddressDao.class);
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        OrderDao od = sqlSession1.getMapper(OrderDao.class);
        //OrderDao od= (OrderDao)MybatisUtil.getMapper(OrderDao.class);
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        ItemDao id = sqlSession2.getMapper(ItemDao.class);
        //ItemDao id= (ItemDao)MybatisUtil.getMapper(ItemDao.class);
        SqlSession sqlSession3 = MybatisUtil.getSqlSession();
        BookDao bd = sqlSession3.getMapper(BookDao.class);
       // BookDao bd= (BookDao)MybatisUtil.getMapper(BookDao.class);
		//System.out.println("id"+address.getId());
		//判断是新地址还是旧地址
		if("".equals(address.getId())){			
			//如果是新地址 去为当前地址对象设置主键
			address.setId(UUID.randomUUID().toString());
			//将user的主键设置为地址的Userid
			address.setUser_id(user.getId());
			//调用ad中添加地址的方法
			ad.addressQuery(address);
		}else{
			//根据页面传递过来的id 查询出数据库中的address对象
			Address add = ad.addressByID(address.getId());
			//System.out.println("是吗"+add);
			//将两个地址对象进行对比
			if(!address.toString().equals(add.toString())){
				//如果对比不一样 调用ad中的修改方法去修改当前地址
				ad.update(address);
			}
		}
		//处理订单
		Orders order=new Orders();
		order.setId(UUID.randomUUID().toString());
		order.setAddressid(address.getId());
		order.setCreateDate(new Date());
		order.setOrderNo(new Date().getTime()+"");
		ServletActionContext.getRequest().setAttribute("orderNo",order.getOrderNo());
		Double price = cart.getTotalPrice();
		double pri=price;
		int total=(int)pri;
		order.setTotal(total);
		ServletActionContext.getRequest().setAttribute("total", order.getTotal());
		order.setUserId(user.getId());
		//把订单插入数据库
		od.addOrder(order);
		//处理订单项
		//获取购物车项的集合
		Map<String, CartItem> map = cart.getCartItems();
		for(Entry<String, CartItem> entry:map.entrySet()){
			CartItem cartItem = entry.getValue();
			Item item=new Item();
			item.setId(UUID.randomUUID().toString());
			item.setBookId(cartItem.getBook().getId());
			item.setCount(cartItem.getCount());
			item.setCreateDate(new Date());
			item.setOrderId(order.getId());
			//将订单项插入数据库
			id.queryAllItem(item);
			//修改图书库存和数量
			bd.updateBook(cartItem.getBook().getId(), cartItem.getCount());
			
			
		}
		MybatisUtil.commit();
		//清空购物车
		ServletActionContext.getRequest().getSession().removeAttribute("cart");
		
	}

}
