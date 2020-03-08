package com.chinasoft.education_manage.domain;

/**
 * tno
 * tname
 * tsex
 * tbirth
 * tphone
 * temail
 * course
 * school
 * education
 * result
 */
public class Teacher {
    private String tno;
    private String tname;
    private String tsex;
    private String tbirth;
    private String tphone;
    private String temail;
    private String course;
    private String school;
    private String education;
    private String result;

    public Teacher() {
    }

    public Teacher(String tno, String tname, String tsex, String tbirth, String tphone, String temail, String course, String school, String education, String result) {
        this.tno = tno;
        this.tname = tname;
        this.tsex = tsex;
        this.tbirth = tbirth;
        this.tphone = tphone;
        this.temail = temail;
        this.course = course;
        this.school = school;
        this.education = education;
        this.result = result;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTbirth() {
        return tbirth;
    }

    public void setTbirth(String tbirth) {
        this.tbirth = tbirth;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tbirth='" + tbirth + '\'' +
                ", tphone='" + tphone + '\'' +
                ", temail='" + temail + '\'' +
                ", course='" + course + '\'' +
                ", school='" + school + '\'' +
                ", education='" + education + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
