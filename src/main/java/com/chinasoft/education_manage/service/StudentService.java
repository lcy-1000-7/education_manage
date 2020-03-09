package com.chinasoft.education_manage.service;

import com.chinasoft.education_manage.domain.Student;
import com.chinasoft.education_manage.domain.StudentPage;

public interface StudentService {

    void addStudent(Student student);

    StudentPage findStudentMessage(String pageNum, String rows, String search);

    Student echoStudnet(int sno);

    void updateStudent(Student student);

    void deleteStudent(int sno);
}
