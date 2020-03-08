package com.chinasoft.education_manage.dao;

import com.chinasoft.education_manage.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherDao {

    /**
     * 查找所有教师信息
     * @return
     */
    List<Teacher> findAllTeacher();

    /**
     * 新增教师用户
     */
    void addTeacher(Teacher teacher);

    /**
     * 修改教师信息
     */
    void updateTeacher(Teacher teacher);

    /**
     * 根据tno查找教师信息
     */
    Teacher findTeacherByTno(String tno);

    /**
     * 根据tno删除一条教师信息
     */
    void deleteTeacherByTno(String tno);

    /**
     * 获取教师总数量
     * @return
     */
    int findTotalCount(Map<String, String[]> map);

    /**
     * 分页
     * @param start
     * @param rows
     * @return
     */
    List<Teacher> findGroupPage(int start, int rows, Map<String, String[]> map);
}
