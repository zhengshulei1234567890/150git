package com.baizhi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//上师表
public class guru {
    private Integer gid;
    private String dharma;//法号
    private String head_pic;//上师头像
    private String status;//状态
    private String create_data;//创建时间
}
