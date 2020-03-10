package com.chinasoft.education_manage.service;

import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.domain.TeacherPage;

import java.util.List;
import java.util.Map;

public interface TeacherService {

    /**
     * 查找所有教师信息
     * @return
     */
    List<Teacher> findAllTeacher();

    /**
     * 新增教师用户
     * @param teacher
     */
    void addTeacher(Teacher teacher);

    /**
     * 根据tno查找教师信息
     */
    Teacher findTeacherByTno(String tno);

    /**
     * 修改教师信息
     */
    void updateTeacher(Teacher teacher);

    /**
     * 根据tno删除一条教师信息
     */
    void deleteTeacherByTno(String tno);

    /**
     * 分页查询
     * @return
     */
    TeacherPage<Teacher> findGroupPage(String pageNum, String rows, Map<String, String[]> map);

    List<Class> echoClass();
}
