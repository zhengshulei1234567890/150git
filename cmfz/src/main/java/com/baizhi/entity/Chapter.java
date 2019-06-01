package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Chapter implements Serializable {
        private String id;

        private String title;

        private String size;

        private String duration;
        @JSONField(format = "yyyy-MM-dd")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date createdate;

        private String albumId;

        private String path;




    }