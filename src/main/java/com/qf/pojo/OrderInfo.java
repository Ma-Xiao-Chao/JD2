package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private int oid;
    private int usid;
    private String address;
    private String phone;
    private String zip;
    private int status;
    private String acceptName;
    private float zprice;
}
