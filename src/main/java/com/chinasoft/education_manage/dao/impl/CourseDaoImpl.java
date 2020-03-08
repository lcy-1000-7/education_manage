package com.chinasoft.education_manage.dao.impl;

import com.alibaba.druid.util.StringUtils;
import com.chinasoft.education_manage.dao.CourseDao;
import com.chinasoft.education_manage.domain.Course;

import com.chinasoft.education_manage.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseDaoImpl implements CourseDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int findTotal(Map<String, String[]> search) {
        String sql = "select count(*) from course8 where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        Set<String> keySet = search.keySet();
        List<Object> params = new ArrayList<>();
        for (String key : keySet) {
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = search.get(key)[0];
            if(!StringUtils.isEmpty(value)){
                stringBuilder.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
        return jdbcTemplate.queryForObject(stringBuilder.toString(), int.class, params.toArray());
    }

    @Override
    public List<Course> findAllCourse(int start, int rows, Map<String, String[]> search) {
        String sql = "select * from course8 where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = search.keySet();
        List<Object> params = new ArrayList<>();
        for (String key : keySet) {
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = search.get(key)[0];
            if(!StringUtils.isEmpty(value)){
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
        sb.append(" limit ?,?");
        params.add(start);
        params.add(rows);
        return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<Course>(Course.class), params.toArray());
    }

    @Override
    public void addCourse(Course aCourse) {
        String sql = "insert into course8 values (?,?,?,?,?)";
        jdbcTemplate.update(sql,aCourse.getCno(), aCourse.getCname(), aCourse.getIntroduce(), aCourse.getStime(),aCourse.getEtime());
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
