package com.chinasoft.education_manage.domain;

public class Course {
    private String cno;
    private String cname;
    private String introduce;
    private String stime;
    private String etime;

    public Course() {
    }

    public Course(String cno, String cname, String introduce, String stime, String etime) {
        this.cno = cno;
        this.cname = cname;
        this.introduce = introduce;
        this.stime = stime;
        this.etime = etime;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", introduce='" + introduce + '\'' +
                ", stime='" + stime + '\'' +
                ", etime='" + etime + '\'' +
                '}';
    }
}
