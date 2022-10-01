package com.qf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Env extends Properties {
    static Env env = null;
    //私有构造
    private Env(){
        loadFile();
    }
    //加载配置文件
    private void loadFile(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        try {
            super.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static synchronized Env getInstance(){
        if (env==null){
            env=new Env();
        }
        return env;
    }
}
