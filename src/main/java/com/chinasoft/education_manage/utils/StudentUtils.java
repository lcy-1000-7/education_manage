package com.chinasoft.education_manage.utils;

import com.chinasoft.education_manage.domain.Student;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class StudentUtils {
    public static Student populate(Student student, Map<String, String[]> parameterMap){
        try {
            BeanUtils.populate(student,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return student;
    }
}
