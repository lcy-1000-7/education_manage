package com.chinasoft.education_manage.domain;

/**
 * @Description TODO
 * @ClassName Yuangong
 * @Author Lenovo
 * @Date 2020/3/6 13:40
 * @Version V1.0
 */
public class Yuangong {
    private String sno;
    private String sname;
    private String ssex;
    private String password;
    private String zhiwei;

    @Override
    public String toString() {
        return "Yuangong{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", password='" + password + '\'' +
                ", zhiwei='" + zhiwei + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZhiwei() {
        return zhiwei;
    }

    public void setZhiwei(String zhiwei) {
        this.zhiwei = zhiwei;
    }

    public Yuangong() {
    }

    public Yuangong(String sno, String sname, String ssex, String password, String zhiwei) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.password = password;
        this.zhiwei = zhiwei;
    }
}
