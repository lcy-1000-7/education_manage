package com.chinasoft.education_manage.domain;


import java.util.List;

public class StudentPage<T> {
    private int totalCount;
    private int totalPage;
    private List<T> list;
    private int pageNum;
    private int rows;

    @Override
    public String toString() {
        return "StudentPage{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", pageNum=" + pageNum +
                ", rows=" + rows +
                '}';
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

    public StudentPage() {
    }

    public StudentPage(int totalCount, int totalPage, List<T> list, int pageNum, int rows) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.pageNum = pageNum;
        this.rows = rows;
    }
}
