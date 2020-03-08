package com.chinasoft.education_manage.service;

import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Page;

import java.util.Map;

public interface ClassService {
    Page<Class> findClass(int currentPage, int rows, Map<String, String[]> search);

    void addClass(Class aclass);

    void deleteClass(String ccid);

    Class findClassByccid(String ccid);

    void updateClass(Class aclass);
}
