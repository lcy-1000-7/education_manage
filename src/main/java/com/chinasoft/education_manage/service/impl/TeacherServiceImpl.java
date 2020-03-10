package com.chinasoft.education_manage.service.impl;


import com.chinasoft.education_manage.dao.StudentDao;
import com.chinasoft.education_manage.dao.TeacherDao;
import com.chinasoft.education_manage.dao.impl.StudentDaoImpl;
import com.chinasoft.education_manage.dao.impl.TeacherDaoImpl;
import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.domain.TeacherPage;
import com.chinasoft.education_manage.service.TeacherService;

import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao = new TeacherDaoImpl();

    /**
     * 查找所有教师信息
     * @return
     */
    @Override
    public List<Teacher> findAllTeacher() {
        List<Teacher> list = teacherDao.findAllTeacher();
        return list;
    }

    /**
     * 新增教师用户
     *
     * @param teacher
     */
    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    /**
     * 根据tno查找教师信息
     *
     * @param tno
     */
    @Override
    public Teacher findTeacherByTno(String tno) {
        return teacherDao.findTeacherByTno(tno);
    }

    /**
     * 修改教师信息
     *
     * @param teacher
     */
    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    /**
     * 根据tno删除一条教师信息
     *
     * @param tno
     */
    @Override
    public void deleteTeacherByTno(String tno) {
        teacherDao.deleteTeacherByTno(tno);
    }

    /**
     * 分页查询
     *
     * @param pageNums
     * @param rowss
     * @return
     */
    @Override
    public TeacherPage<Teacher> findGroupPage(String pageNums, String rowss, Map<String, String[]> map) {
//        获取当前页号
        int pageNum = Integer.parseInt(pageNums);
//        获取每页显示记录数
        int rows = Integer.parseInt(rowss);
//        总记录数
        int totalCount = teacherDao.findTotalCount(map);
//        总页数
        int totalPage = (totalCount%rows) == 0?(totalCount/rows):(totalCount/rows+1);
//        分页查询起始行数
        int start = (pageNum - 1)*5;
//        获取当前页的rows条数据
        List<Teacher> list = teacherDao.findGroupPage(start,rows,map);
//        new一个Page,将对应的参数传入并返回一个Page<Teacher>对象
        TeacherPage<Teacher> page = new TeacherPage<>(totalCount, totalPage, list, pageNum, rows);
        return page;
    }

    @Override
    public List<Class> echoClass() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Class> list = studentDao.stuFindClass();
        return list;
    }
}
