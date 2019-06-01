package com.baizhi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//功课表
public class task {
    private Integer id;
    private String title;//名称
    private String mark;//标识
    private String create_data;//创建日期


}
