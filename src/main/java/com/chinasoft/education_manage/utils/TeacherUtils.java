package com.chinasoft.education_manage.utils;

import com.chinasoft.education_manage.domain.Teacher;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class TeacherUtils {
    public static Teacher populate(Teacher teacher, Map<String, String[]> map){
        try {
            BeanUtils.populate(teacher,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}
