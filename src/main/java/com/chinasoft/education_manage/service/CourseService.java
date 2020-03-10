package com.chinasoft.education_manage.service;

import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.domain.CoursePage;

public interface CourseService {
    CoursePage<Course> findCourse(int currentPage, int rows, String search);

    void addCourse(Course aCourse);

    void deleteCourse(String cno);

    Course findCourseBycno(String cno);

    void updateCourse(Course aCourse);
}
