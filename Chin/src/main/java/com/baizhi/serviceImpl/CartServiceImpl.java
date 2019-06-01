package com.baizhi.serviceImpl;
import com.baizhi.dao.BookDao;
import com.baizhi.Service.CartService;
import com.baizhi.util.MybatisUtil;
import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

import java.util.Map;



public class CartServiceImpl implements CartService {

	@Override
	public Cart addcart(String id, Cart cart) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bd = sqlSession.getMapper(BookDao.class);
		//BookDao bd = (BookDao) MybatisUtil.getMapper(BookDao.class);
		//根据id获取图书对象
		Book book = bd.selectBookQuery(id);
		//判断这个购物车是否为空
		if(cart == null){
			//如果用户第一次添加购物车，新建购物车
			cart=new Cart();
			//新建购物车项集合
			Map<String, CartItem> map=new HashMap<String,CartItem>();
			//新建当前购物车项
			CartItem ci=new CartItem();
			//设置购物车项的属性
			ci.setBook(book);
			ci.setCount(1);
			//		小计       =       当当价
			ci.setLittelPrice(book.getDprice());
			//把购物车项添加到map里
			map.put(id, ci);
			//设置购物车对象里的属性
			cart.setCartItems(map);
			//		商品总额    =   当当价
			cart.setTotalPrice(book.getDprice());
			//		节省的金钱=     原价(市场价)		-      当当价
			cart.setSavePrice(book.getPrice()-book.getDprice());//节省的金钱
		}else{
			
			
			//	获取购物车项的对象的id==null
			if(cart.getCartItems().get(id)==null){
				//新建当前购物车项对象
				CartItem ci=new CartItem();
				//新建当前购物车项的属性
				ci.setBook(book);
				ci.setCount(1);
				ci.setLittelPrice(book.getDprice());
				//把购物车项设置进Map
				cart.getCartItems().put(id, ci);
				//设置购物车的总价
				cart.setTotalPrice(cart.getTotalPrice()+ci.getLittelPrice());
				//设置购物车里的节省金钱							原价          -      当当价
				cart.setSavePrice(cart.getSavePrice()+book.getPrice()-book.getDprice());
				
			}else{
				CartItem ci = cart.getCartItems().get(id);
				//如果不是第一次购买此商品，那么商品数量加一
				ci.setCount(ci.getCount()+1);
				//小计						小计		+     原价(市场价)
				ci.setLittelPrice(ci.getLittelPrice()+book.getPrice());
				//	商品总额					商品总额		+   当当价
				cart.setTotalPrice(cart.getTotalPrice()+book.getDprice());
				//节省金钱				节省金钱             +        原价	  -     当当价
				cart.setSavePrice(cart.getSavePrice()+(book.getPrice()-book.getDprice()));		
			}
		}
		return cart;
		}

	@Override
	public Cart update(String id, int count,Cart cart) {
		//老购物车项
		CartItem cartItem = cart.getCartItems().get(id);
		//获取当前订单项李的书籍
		Book book = cartItem.getBook();
		
		
		
		//获取旧的总价
		Double oldtotalPrice = cart.getTotalPrice();
		//获取旧的小计
		Double oldlittelPrice = cartItem.getLittelPrice();
		//获取旧的节省金钱
		Double oldsavePrice = cart.getSavePrice();
		//获取旧的当前购物车项的节省金钱, 用图书里的市场价 - 当当价  * 购买数量 
		Double oldcartitemsave=(book.getPrice()-book.getDprice())*cartItem.getCount();
		
		
		
		//获取购物车项
		CartItem ci = cart.getCartItems().get(id);
		//设置购物车项数量
		ci.setCount(count);
		//设置购物车项的小计
		ci.setLittelPrice(count*ci.getBook().getDprice());
		//设置购物车的总价
		cart.setTotalPrice((oldtotalPrice-oldlittelPrice)+ci.getLittelPrice());
		//设置节省金钱, 先用旧的节省金钱 - 新的购物车项节省的金钱 + 新购物车项的节省金钱
		cart.setSavePrice((oldsavePrice-oldcartitemsave)+(book.getPrice()-book.getDprice())*count);
		
		return cart;
	}

	@Override
	public Cart delete(String id, Cart cart) {
		//计算购物车里的总价
		cart.setTotalPrice(cart.getTotalPrice()-cart.getCartItems().get(id).getLittelPrice());
		
		CartItem cartItem = cart.getCartItems().get(id);
		Book book = cartItem.getBook();
		Integer count = cartItem.getCount();
		//计算节省金钱
		cart.setSavePrice(cart.getSavePrice()-(book.getPrice()-book.getDprice())*count);
		//移除当前订单项
		cart.getCartItems().remove(id);
		//判断移除之后时候还有订单项，如果没有就将cart设置nul;
		if(cart.getCartItems().size()==0){
			cart=null;
		}
		return cart;
	}
	
}



