package com.baizhi.Service;

import com.baizhi.entity.Address;

import java.util.List;



public interface AddressService {
	public List<Address> addressID(String id);
	
	//选择地址   回显
	public Address addressByID(String id);
	
	public void addressQuery(Address address);
}
