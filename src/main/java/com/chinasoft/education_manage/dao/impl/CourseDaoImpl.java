package com.chinasoft.education_manage.dao.impl;

import com.chinasoft.education_manage.dao.CourseDao;
import com.chinasoft.education_manage.domain.Course;

import com.chinasoft.education_manage.utils.JDBCUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.ArrayList;
import java.util.List;


public class CourseDaoImpl implements CourseDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotal(String search) {
        String sql = "select count(*) from course8 where 1=1 ";
        StringBuffer sb  = new StringBuffer(sql);
        if (!StringUtils.isEmpty(search)){
            return jdbcTemplate.queryForObject(sb.toString(), int.class);
        }else {
            sb.append(" and cname like ?");
            search = "%"+search+"%";
            return jdbcTemplate.queryForObject(sb.toString(),int.class,search);
        }
    }

    @Override
    public List<Course> findAllCourse(int start, int rows, String search) {
        String sql = "select * from course8 where 1 = 1 ";
        StringBuffer sb = new StringBuffer(sql);
        List list = new ArrayList();
        if (!StringUtils.isEmpty(search)){
            search = "%"+search+"%";
            sb.append(" and cname like ?");
            list.add(search);
        }
        sb.append(" limit ?,? ");
        list.add(start);
        list.add(rows);
        return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<>(Course.class),list.toArray());
    }

    @Override
    public void addCourse(Course aCourse) {
        String sql = "insert into course8 values (?,?,?,?,?)";
        jdbcTemplate.update(sql,null, aCourse.getCname(), aCourse.getIntroduce(), aCourse.getStime(),aCourse.getEtime());
    }

    @Override
    public void deleteCourse(String cno) {
        String sql = "delete from course8 where cno = ? ";
        jdbcTemplate.update(sql,cno);
    }

    @Override
    public Course findCourseBycno(String cno) {
        String sql = "select * from course8 where cno = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Course.class),cno);
    }

    @Override
    public void updateCourse(Course aCourse) {
        String sql = "update course8 set cname=?,introduce=?,stime=?,etime=? where cno=?";
        jdbcTemplate.update(sql,aCourse.getCname(),aCourse.getIntroduce(),aCourse.getStime(),aCourse.getEtime(),aCourse.getCno());
    }
}
