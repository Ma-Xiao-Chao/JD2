package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    private int odid;
    private int gid;
    private int num;
    private float currPrice;
    private String gname;
    private String pic1;
    private int oid;
}
