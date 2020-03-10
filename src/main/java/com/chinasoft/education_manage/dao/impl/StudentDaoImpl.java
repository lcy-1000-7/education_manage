package com.chinasoft.education_manage.dao.impl;

import com.chinasoft.education_manage.dao.StudentDao;
import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Student;
import com.chinasoft.education_manage.utils.JDBCUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addStudent(Student student) {
        String sql = "insert into student8 values(null,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,student.getSname(),student.getSsex(),student.getSage(),
                student.getParents(),student.getSphone(),student.getSchool(),student.getCno());
    }

    @Override
    public int findAllStudentTotal(String search) {
        String sql = "select count(*) from student8 where 1=1 ";
        StringBuffer sb = new StringBuffer(sql);
        ArrayList<Object> list = new ArrayList<>();
        if (!StringUtils.isEmpty(search)){
            search = getSqlString(search, sb);
            list.add(search);
        }
        return jdbcTemplate.queryForObject(sb.toString(),int.class,list.toArray());
    }

    private String getSqlString(String search, StringBuffer sb) {
        Boolean flag = verifyString(search);
        if (flag) {
            Integer sno = Integer.parseInt(search);
            double pow = Math.pow(10, sno.toString().length());
            sb.append(" and sno%" + pow + "=?");
        } else {
            sb.append(" and sname like ?");
            search = "%" + search + "%";
        }
        return search;
    }

    private Boolean verifyString(String search) {
        try {
            int num = Integer.parseInt(search);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Student> findAllStudent(int start, int rows, String search) {
        String sql = "select * from student8 where 1=1";
        StringBuffer sb = new StringBuffer(sql);
        ArrayList<Object> list = new ArrayList<>();
        if (!StringUtils.isEmpty(search)){
            search = getSqlString(search, sb);
            list.add(search);
        }
        sb.append(" limit ?,? ");
        list.add(start);
        list.add(rows);
        return jdbcTemplate.query(sb.toString(),new BeanPropertyRowMapper<>(Student.class),list.toArray());
    }

    @Override
    public Student echoStudent(int sno) {
        String sql = "select * from student8 where sno=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Student.class),sno);
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE student8 set parents = ?,sphone=?,school=?,cno=? WHERE sno=?";
        jdbcTemplate.update(sql,student.getParents(),student.getSphone(),student.getSchool(),student.getCno(),student.getSno());
    }

    @Override
    public void deleteStudent(int sno) {
        String sql = "delete from student8 where sno = ? ";
        jdbcTemplate.update(sql,sno);
    }

    @Override
    public List<Class> stuFindClass() {
        String sql = "select * from banji8";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Class.class));
    }
}
