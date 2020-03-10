package com.chinasoft.student;

import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.service.ClassService;
import com.chinasoft.education_manage.service.impl.ClassServiceImpl;
import org.junit.Test;

import java.util.List;

public class ClassTest {
        ClassService classService = new ClassServiceImpl();

        @Test
        public void deleteClass(){
            classService.deleteClass("c001");
        }

        @Test
    public void echo(){
            List<Course> courseList = classService.echoCourse();
            for (Course course : courseList) {
                System.out.println(course);
            }
            List<Teacher> teacherList = classService.echoTeacher();
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        }
}
