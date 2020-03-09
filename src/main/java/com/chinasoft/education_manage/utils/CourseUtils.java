package com.chinasoft.education_manage.utils;

import com.chinasoft.education_manage.domain.Course;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CourseUtils {
    public static Course populate(Course course, Map<String, String[]> parameterMap){
        try {
            BeanUtils.populate(course, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return course;
    }
}
