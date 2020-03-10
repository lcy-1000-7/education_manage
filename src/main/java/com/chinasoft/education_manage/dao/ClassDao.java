package com.chinasoft.education_manage.dao;

import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Course;
import com.chinasoft.education_manage.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface ClassDao {
    int findTotal(Map<String, String[]> search);

    List<Class> findAllClass(int start, int rows, Map<String, String[]> search);

    void addClass(Class aclass);

    void deleteClass(String ccid);

    Class findClassByccid(String ccid);

    void updateClass(Class aclass);

    List<Teacher> echoTeacher();

    List<Course> echoCourse();
}
