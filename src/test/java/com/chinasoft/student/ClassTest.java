package com.chinasoft.student;

import com.chinasoft.education_manage.service.ClassService;
import com.chinasoft.education_manage.service.impl.ClassServiceImpl;
import org.junit.Test;

public class ClassTest {
        ClassService classService = new ClassServiceImpl();

        @Test
        public void deleteClass(){
            classService.deleteClass("c001");
        }
}
