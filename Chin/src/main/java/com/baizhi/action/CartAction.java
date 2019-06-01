package com.baizhi.action;

import com.baizhi.Service.CartService;
import com.baizhi.serviceImpl.CartServiceImpl;
import com.baizhi.entity.Cart;
import org.apache.struts2.ServletActionContext;



public class CartAction {
	private CartService cs=new CartServiceImpl();
	private String id;
	private int count;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String addcart(){
		Cart oldcart=(Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
		Cart cart = cs.addcart(id, oldcart);
		ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		return "addok";
		
	}
	public String update(){
		Cart oldcart=(Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
		Cart cart = cs.update(id, count, oldcart);
		ServletActionContext.getRequest().getSession().setAttribute("cart", cart);

		return "update";
		
		
	}
	
	public String delete(){
		Cart oldcart=(Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
		Cart cart = cs.delete(id, oldcart);
		ServletActionContext.getRequest().getSession().setAttribute("cart", cart);

		return "delete";
		
	}
}















