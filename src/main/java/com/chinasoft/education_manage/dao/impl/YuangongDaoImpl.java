package com.chinasoft.education_manage.dao.impl;

import com.chinasoft.education_manage.dao.YuangongDao;
import com.chinasoft.education_manage.domain.Yuangong;
import com.chinasoft.education_manage.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Description TODO
 * @ClassName YuangongDaoImpl
 * @Author Lenovo
 * @Date 2020/3/6 13:39
 * @Version V1.0
 */
public class YuangongDaoImpl implements YuangongDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Yuangong findYuangong(Yuangong yuangong) {
        try {
            String sql = "select * from yuangong where sname=? and password=?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Yuangong>(Yuangong.class), yuangong.getSname(), yuangong.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePasswordBySname(Yuangong yuangong,String newPassword) {
        String sql = "update yuangong set password=? where sname=? ";
        jdbcTemplate.update(sql,newPassword,yuangong.getSname());
    }
}
