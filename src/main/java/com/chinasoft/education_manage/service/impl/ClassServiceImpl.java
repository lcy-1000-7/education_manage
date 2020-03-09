package com.chinasoft.education_manage.service.impl;

import com.chinasoft.education_manage.dao.ClassDao;
import com.chinasoft.education_manage.dao.impl.ClassDaoImpl;
import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Page;
import com.chinasoft.education_manage.service.ClassService;

import java.util.List;
import java.util.Map;

public class ClassServiceImpl implements ClassService {
    private ClassDao classDao = new ClassDaoImpl();

    @Override
    public Page<Class> findClass(int currentPage, int rows, Map<String, String[]> search) {
        int totalCount = classDao.findTotal(search);
        int totalPage = (totalCount%rows == 0 ? (totalCount/rows) : (totalCount/rows+1));
        int start = (currentPage -1)*rows;
        List<Class> list = classDao.findAllClass(start, rows, search);

        Page<Class> page = new Page<>(totalCount,totalPage,list,currentPage,rows);
        return page;
    }

    @Override
    public void addClass(Class aclass) {
        classDao.addClass(aclass);
    }

    @Override
    public void deleteClass(String ccid) {
        classDao.deleteClass(ccid);
    }

    @Override
    public Class findClassByccid(String ccid) {
        return classDao.findClassByccid(ccid);
    }

    @Override
    public void updateClass(Class aclass) {
        classDao.updateClass(aclass);
    }
}
