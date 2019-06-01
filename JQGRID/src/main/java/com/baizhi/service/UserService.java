package com.baizhi.service;

import java.util.Map;

public interface UserService {
    //分页service 处理业务层
    public Map<String,Object> show(Integer page,Integer rows);
}
