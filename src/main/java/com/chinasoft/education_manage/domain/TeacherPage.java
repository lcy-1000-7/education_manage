package com.chinasoft.education_manage.domain;

import java.util.List;

public class TeacherPage<T> {
    //    总记录数
    private int totalCount;
    //    总页数
    private int totalPage;
    //    当页的数据
    private List<T> list;
    //    当前的页号
    private int pageNum;
    //    每页的显示记录数
    private int rows;

    public TeacherPage() {
    }

    public TeacherPage(int totalCount, int totalPage, List<T> list, int pageNum, int rows) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.pageNum = pageNum;
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TeacherPage{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", pageNum=" + pageNum +
                ", rows=" + rows +
                '}';
    }
}
