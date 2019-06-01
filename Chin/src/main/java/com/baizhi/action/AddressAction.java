package com.baizhi.action;

import java.util.List;


import com.baizhi.Service.AddressService;
import com.baizhi.serviceImpl.AddressServiceImpl;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import org.apache.struts2.ServletActionContext;

public class AddressAction {
	private AddressService as=new AddressServiceImpl();
	private String addressId;
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	//
	public String addAddress(){
	User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		 if(user ==null){
			 return "login";
		}else{
			List<Address> list = as.addressID(user.getId());
			ServletActionContext.getRequest().setAttribute("list", list);
			return "ok";
		}
	}
	
	public String addAddressId(){
		Address address = as.addressByID(addressId);
		ServletActionContext.getRequest().setAttribute("address", address);
		return "ok";
		
	}
	public String addressQuery(){
		as.addressQuery(address);		
		return "address";		
	}
	
	
}
