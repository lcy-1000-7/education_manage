package com.chinasoft.education_manage.dao.impl;

import com.chinasoft.education_manage.dao.TeacherDao;
import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TeacherDaoImpl implements TeacherDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查找所有教师信息
     * @return
     */
    @Override
    public List<Teacher> findAllTeacher() {
        String sql = "select * from Teacher8";
        List<Teacher> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
        return list;
    }

    /**
     * 新增教师用户
     */
    @Override
    public void addTeacher(Teacher teacher) {
        String sql1 = "select max(tno) from Teacher8";
        String sql2 = "insert into Teacher8 values(?,?,?,?,?,?,?,?,?,?)";
        String max_tno = jdbcTemplate.queryForObject(sql1, String.class);
        String tno = "t"+(Integer.toString(Integer.parseInt(max_tno.replace("t", "1")) + 1)).substring(1);
        jdbcTemplate.update(sql2,tno, teacher.getTname(),teacher.getTsex(),teacher.getTbirth(),teacher.getTphone(),teacher.getTemail(),
                teacher.getCourse(),teacher.getSchool(),teacher.getEducation(),teacher.getResult());
    }

    /**
     * 修改教师信息
     */
    @Override
    public void updateTeacher(Teacher teacher) {
        String sql = "update Teacher8 set tname = ?,tsex = ?,tbirth = ?,tphone = ?,temail = ?,course = ?,school = ?," +
                " education = ?,result = ? where tno = ?";
        jdbcTemplate.update(sql,teacher.getTname(),teacher.getTsex(),teacher.getTbirth(),teacher.getTphone(),teacher.getTemail(),
                teacher.getCourse(),teacher.getSchool(),teacher.getEducation(),teacher.getResult(),teacher.getTno());
    }

    /**
     * 根据tno查找教师信息
     *
     * @param tno
     */
    @Override
    public Teacher findTeacherByTno(String tno) {
        String sql = "select * from Teacher8 where tno = ?";
        Teacher teacher = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class),tno);
        return teacher;
    }

    /**
     * 根据tno删除一条教师信息
     *
     * @param tno
     */
    @Override
    public void deleteTeacherByTno(String tno) {
        String sql = "delete from Teacher8 where tno = ?";
        jdbcTemplate.update(sql,tno);
    }

    /**
     * 获取教师总数量
     *
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> map) {
        String sql = "select count(*) from Teacher8 where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = map.keySet();
        List<Object> param = new ArrayList<>();
        for (String key : keySet) {
            if("pageNum".equals(key) || "rows".equals(key)){
                continue;
            }
//            取具体参数的值
            String value = map.get(key)[0];
            if(!StringUtils.isEmpty(value)){
                sb.append(" and "+key+" like ? ");
                param.add("%"+value+"%");
            }
        }
        Integer totalCount = jdbcTemplate.queryForObject(sb.toString(), Integer.class, param.toArray());
        return totalCount;
    }

    /**
     * 分页
     *
     * @param start
     * @param rows
     * @return
     */
    @Override
    public List<Teacher> findGroupPage(int start, int rows, Map<String, String[]> map) {
//        String sql = "select * from Teacher8 limit ?,?";
        String sql = "select * from Teacher8 where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = map.keySet();
        List<Object> param = new ArrayList<>();
        for (String key : keySet) {
            if("pageNum".equals(key) || "rows".equals(key)){
                continue;
            }
//            取具体参数的值
            String value = map.get(key)[0];
            if(!StringUtils.isEmpty(value)){
                sb.append(" and "+key+" like ? ");
                param.add("%"+value+"%");
            }
        }
        sb.append("limit ?,? ");
        param.add(start);
        param.add(rows);
        List<Teacher> list = jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<>(Teacher.class), param.toArray());
        return list;
    }
}
