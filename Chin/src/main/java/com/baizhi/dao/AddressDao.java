package com.baizhi.dao;

import com.baizhi.entity.Address;

import java.util.List;




public interface AddressDao {
	//地址
	public List<Address> addressID(String id);
	//选择地址   回显
	public Address addressByID(String id);
	
	
	//
	public void addressQuery(Address address);
	public void update(Address address);
}
