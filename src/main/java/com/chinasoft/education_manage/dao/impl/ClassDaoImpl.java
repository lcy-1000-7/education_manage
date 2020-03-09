package com.chinasoft.education_manage.dao.impl;

import com.chinasoft.education_manage.dao.ClassDao;
import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClassDaoImpl implements ClassDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotal(Map<String, String[]> search) {
        String sql = "select count(*) from banji8 where 1 = 1";
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
        return jdbcTemplate.queryForObject(sb.toString(), int.class, params.toArray());
    }

    @Override
    public List<Class> findAllClass(int start, int rows, Map<String, String[]> search) {
        String sql = "select * from banji8 where 1 = 1";
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
        return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<Class>(Class.class), params.toArray());
    }

    @Override
    public void addClass(Class aclass) {
        String sql = "insert into banji8 values (?,?,?,?)";
        jdbcTemplate.update(sql, aclass.getCcid(), aclass.getCname(), aclass.getTname(), aclass.getCcname());
    }

    @Override
    public void deleteClass(String ccid) {
        String sql = "delete from banji8 where ccid = ?";
        jdbcTemplate.update(sql, ccid);
    }

    @Override
    public Class findClassByccid(String ccid) {
        String sql = "select * from banji8 where ccid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Class.class), ccid);
    }

    @Override
    public void updateClass(Class aclass) {
        String sql = "update banji8 set cname = ?, tname = ?, ccname = ? where ccid = ?";
        jdbcTemplate.update(sql, aclass.getCname(), aclass.getTname(), aclass.getCcname(), aclass.getCcid());
    }
}
