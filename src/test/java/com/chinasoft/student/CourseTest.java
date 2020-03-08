package com.chinasoft.student;

import com.chinasoft.education_manage.service.CourseService;
import com.chinasoft.education_manage.service.impl.CourseServiceImpl;
import org.junit.Test;

public class CourseTest {
    CourseService courseService = new CourseServiceImpl();

    @Test
    public void findCourse(){
        System.out.println(courseService.findCourseBycno("c001"));
    }
}
