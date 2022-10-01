package com.qf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String dateToStr(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date strToDate(String s) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(s);
    }
}
