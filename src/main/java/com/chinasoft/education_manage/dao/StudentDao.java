package com.chinasoft.education_manage.dao;

import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Student;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    int findAllStudentTotal(String search);

    List<Student> findAllStudent(int start, int rows, String search);

    Student echoStudent(int sno);

    void updateStudent(Student student);

    void deleteStudent(int sno);

    List<Class> stuFindClass();
}
