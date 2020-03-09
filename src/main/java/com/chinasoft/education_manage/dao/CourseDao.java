package com.chinasoft.education_manage.dao;

import com.chinasoft.education_manage.domain.Course;


import java.util.List;

public interface CourseDao {
    int findTotal(String search);

    List<Course> findAllCourse(int start, int rows, String search);

    void addCourse(Course aCourse);

    void deleteCourse(String cno);

    Course findCourseBycno(String cno);

    void updateCourse(Course aCourse);
}
