package com.qf.pojo;

import java.util.Date;

public class User {
    private Integer uid;
    private String  uname;
    private String upass;
    private Date ubirth;
    private String umail;

    public User() {
    }

    public User(Integer uid, String uname, String upass, Date ubirth, String umail) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.ubirth = ubirth;
        this.umail = umail;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Date getUbirth() {
        return ubirth;
    }

    public void setUbirth(Date ubirth) {
        this.ubirth = ubirth;
    }

    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail;
    }
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", ubirth=" + ubirth +
                ", umail='" + umail + '\'' +
                '}';
    }
}
