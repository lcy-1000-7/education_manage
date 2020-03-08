package com.chinasoft.student;

import com.chinasoft.education_manage.dao.TeacherDao;
import com.chinasoft.education_manage.dao.impl.TeacherDaoImpl;
import com.chinasoft.education_manage.domain.Teacher;
import com.chinasoft.education_manage.service.TeacherService;
import com.chinasoft.education_manage.service.impl.TeacherServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    TeacherService service = new TeacherServiceImpl();


    @org.junit.Test
    public void findAllTeacherTest(){

        List<Teacher> allTeacher = service.findAllTeacher();
        System.out.println(allTeacher);
    }

    @org.junit.Test
    public void addTeacher(){
//        Teacher teacher = new Teacher('ddd','于雷1','女','1976-10-13','16736376545','16736376545@163.com','硬笔书法','鲁美学院','研究生','硬笔书法比赛一等奖');
//
//        service.addTeacher(teacher);
        List<String> list = new ArrayList<>();
        list.add("t001");
        Integer tno =   Integer.parseInt(list.get(0).replace("t",""));
        System.out.println(tno);
    }

    @org.junit.Test
    public void findGroupPageTest(){
//    String pageNum, String rows, Map<String, String[]> map
        int pagNum = 1;
        int rows = 5;
        HashMap<String, String[]> map = new HashMap<>();
        TeacherDao dao = new TeacherDaoImpl();
        List<Teacher> groupPage = dao.findGroupPage(pagNum, rows, map);
        System.out.println(groupPage);

    }

}
