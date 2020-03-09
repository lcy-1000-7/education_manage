package com.chinasoft.student;

import com.chinasoft.education_manage.dao.StudentDao;
import com.chinasoft.education_manage.dao.impl.StudentDaoImpl;
import com.chinasoft.education_manage.domain.Student;
import com.chinasoft.education_manage.service.StudentService;
import com.chinasoft.education_manage.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    StudentService studentService = new StudentServiceImpl();

    @Test
    public void insertStudent(){
        Student student = new Student(null,"pdd","男",18,"刘默","1844064094","希望小学","6年级");
        studentService.addStudent(student);
    }
    @Test
    public void updateStudent(){
        Student student = new Student(202009021,"pdd","男",18,"刘默mom","1844064094","希望小学","6年级");
        studentService.updateStudent(student);
    }

    @Test
    public void findTotal(){
        StudentDao studentDao = new StudentDaoImpl();
        int allStudentTotal = studentDao.findAllStudentTotal(null);
        System.out.println(allStudentTotal);
        List<Student> allStudent = studentDao.findAllStudent(0, 5, null);
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }
    @Test
    public void selectAllStudent(){

    }
}
