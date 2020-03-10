package com.chinasoft.education_manage.service.impl;

import com.chinasoft.education_manage.dao.CourseDao;
import com.chinasoft.education_manage.dao.impl.CourseDaoImpl;
import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.domain.CoursePage;
import com.chinasoft.education_manage.service.CourseService;

import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public CoursePage<Course> findCourse(int currentPage, int rows, Map<String,String[]> search) {
        int totalCount = courseDao.findTotal(search);
        int totalPage = (totalCount%rows == 0 ? (totalCount/rows):(totalCount/rows+1));
        int start = (currentPage -1)*rows;
        List<Course> list = courseDao.findAllCourse(start,rows,search);
        CoursePage<Course> page = new CoursePage<>(totalCount,totalPage,list,currentPage,rows);
        return page;
    }

    @Override
    public void addCourse(Course aCourse) {
        courseDao.addCourse(aCourse);

    }

    @Override
    public void deleteCourse(String cno) {
        courseDao.deleteCourse(cno);
    }

    @Override
    public Course findCourseBycno(String cno) {
        return courseDao.findCourseBycno(cno);
    }

    @Override
    public void updateCourse(Course aCourse) {
        courseDao.updateCourse(aCourse);
    }
}
