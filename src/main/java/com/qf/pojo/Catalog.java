package com.qf.pojo;

public class Catalog {
    private Integer cid;
    private String cname;
    private String url;
    private Integer level;
    private Integer parent;
    private Integer line;

    public Catalog() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", url='" + url + '\'' +
                ", level=" + level +
                ", parent=" + parent +
                ", line=" + line +
                '}';
    }
}
