package com.chinasoft.education_manage.domain;

public class Student {
    private Integer sno;
    private String sname;
    private String ssex;
    private Integer sage;
    private String parents;
    private String sphone;
    private String school;
    private String cno;

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", parents='" + parents + '\'' +
                ", sphone='" + sphone + '\'' +
                ", school='" + school + '\'' +
                ", cno='" + cno + '\'' +
                '}';
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
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

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Student() {
    }

    public Student(Integer sno, String sname, String ssex, Integer sage, String parents, String sphone, String school, String cno) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.parents = parents;
        this.sphone = sphone;
        this.school = school;
        this.cno = cno;
    }
}
