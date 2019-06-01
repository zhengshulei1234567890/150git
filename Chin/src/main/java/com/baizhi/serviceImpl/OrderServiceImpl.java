package com.baizhi.serviceImpl;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.Service.OrdersService;
import com.baizhi.util.MybatisUtil;
import com.baizhi.entity.Book;
import com.baizhi.entity.Item;
import com.baizhi.entity.Orders;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderServiceImpl implements OrdersService {

	@Override
	public List<Orders> queryAllOrders() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderDao od = sqlSession.getMapper(OrderDao.class);
       // OrderDao od=(OrderDao) MybatisUtil.getMapper(OrderDao.class);
		List<Orders> list = od.queryAllOrders();
//		System.out.println(list);
		 MybatisUtil.close();
		return list;
	}

	@Override
	public Orders queryOrder(String id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        OrderDao od = sqlSession.getMapper(OrderDao.class);
        //OrderDao od=(OrderDao) MybatisUtil.getMapper(OrderDao.class);
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();
        BookDao bd = sqlSession1.getMapper(BookDao.class);
        //BookDao bd = (BookDao) MybatisUtil.getMapper(BookDao.class);
		Orders order = od.queryOrder(id);
		List<Item> items = order.getItems();
		for (Item item : items) {
			String bookId = item.getBookId();
			 Book book = bd.selectbook(bookId);
			 item.setBook(book);
		}
		return order;
	}
	
	
	
	
	
	
	
	
	
	
	/*public Order querydetailOrder(String id){
	//拿到OrderDao的引用od
	//拿到BookDao的引用od
		//调用od中查询订单信息的方法
	Order order=od.querydetailOrder(id);
	//获取订单项集合
	List<item> list=order.getitem();
	//遍历订单项
	for(Item item:list ){
		//根据订单项中Bookid查询book
		Book book=bd.queryOneBook(item.getBookid());
		item.setBook(book);
		
	}
	//把当前完整的Order对象返回给action
	}*/
}
