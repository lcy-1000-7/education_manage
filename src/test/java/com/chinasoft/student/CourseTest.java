package com.chinasoft.student;

import com.chinasoft.education_manage.dao.CourseDao;
import com.chinasoft.education_manage.dao.impl.CourseDaoImpl;
import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.domain.CoursePage;
import com.chinasoft.education_manage.service.CourseService;
import com.chinasoft.education_manage.service.impl.CourseServiceImpl;
import org.junit.Test;

import java.util.List;

public class CourseTest {
    CourseService courseService = new CourseServiceImpl();

    @Test
    public void findCourse(){
        System.out.println(courseService.findCourseBycno("c001"));
    }


}
