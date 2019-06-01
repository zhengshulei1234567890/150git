package com.baizhi.Service;

import com.baizhi.entity.Cart;

public interface CartService {
	//购物车添加
	public Cart addcart(String id, Cart cart);
	//变更
	public Cart update(String id, int count, Cart cart);
	
	//删除
	public Cart delete(String id, Cart cart);
	
}
