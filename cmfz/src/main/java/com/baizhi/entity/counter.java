package com.baizhi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//计数器表
public class counter {
    private Integer id;
    private String title;//
    private String count;//数量
    private String last_time;//时间

}
