package com.qf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Goods {
    private Integer gid;
    private Integer cid1;
    private Integer cid2;
    private Integer cid3;
    private String gname;
    private Integer store;
    private Date pubdate;
    private Float price;
    private String pic1;
    private String pic2;
    private String pic3;
    private String pic4;
    private String info;
}
