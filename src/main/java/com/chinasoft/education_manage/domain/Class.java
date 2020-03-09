package com.chinasoft.education_manage.domain;

public class Class {
    private String ccid;
    private String cname;
    private String tname;
    private String ccname;

    public Class() {
    }

    public Class(String ccid, String cname, String tname, String ccname) {
        this.ccid = ccid;
        this.cname = cname;
        this.tname = tname;
        this.ccname = ccname;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCcname() {
        return ccname;
    }

    public void setCcname(String ccname) {
        this.ccname = ccname;
    }

    @Override
    public String toString() {
        return "Class{" +
                "ccid='" + ccid + '\'' +
                ", cname='" + cname + '\'' +
                ", tname='" + tname + '\'' +
                ", ccname='" + ccname + '\'' +
                '}';
    }
}
