package com.chinasoft.education_manage.service.impl;

import com.chinasoft.education_manage.dao.ClassDao;
import com.chinasoft.education_manage.dao.StudentDao;
import com.chinasoft.education_manage.dao.impl.ClassDaoImpl;
import com.chinasoft.education_manage.dao.impl.StudentDaoImpl;
import com.chinasoft.education_manage.domain.Class;
import com.chinasoft.education_manage.domain.Student;
import com.chinasoft.education_manage.domain.StudentPage;
import com.chinasoft.education_manage.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public StudentPage findStudentMessage(String pageNum, String rowsNum, String search) {
        int rows = Integer.parseInt(rowsNum);
        int pageNums = Integer.parseInt(pageNum);
        if (pageNums < 1){
            pageNums = 1;
        }
        int totalCount = studentDao.findAllStudentTotal(search);
        int totalPage = (totalCount%rows) == 0 ? (totalCount/rows):(totalCount/rows)+1;
        int start = (pageNums - 1)*rows;
        List<Student> list = studentDao.findAllStudent(start,rows,search);
        StudentPage<Student> studentPage = new StudentPage<>(totalCount, totalPage, list, pageNums, rows);
        return studentPage;
    }

    @Override
    public Student echoStudnet(int sno) {
        return studentDao.echoStudent(sno);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(int sno) {
        studentDao.deleteStudent(sno);
    }

    @Override
    public List<Class> echoClass() {
        List<Class> list = studentDao.stuFindClass();
        return list;
    }
}
