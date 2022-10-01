package com.qf.util;

import java.io.UnsupportedEncodingException;

public class Tran {
    public static String tran(String str) throws UnsupportedEncodingException {
       return new String(str.getBytes("ISO8859-1"),"UTF-8");
    }
}
