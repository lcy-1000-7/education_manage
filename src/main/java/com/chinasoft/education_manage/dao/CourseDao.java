package com.chinasoft.education_manage.dao;

import com.chinasoft.education_manage.domain.Course;


import java.util.List;
import java.util.Map;

public interface CourseDao {
    int findTotal(Map<String, String[]> search);

    List<Course> findAllCourse(int start, int rows, Map<String, String[]> search);

    void addCourse(Course aCourse);

    void deleteCourse(String cno);

    Course findCourseBycno(String cno);

    void updateCourse(Course aCourse);
}
