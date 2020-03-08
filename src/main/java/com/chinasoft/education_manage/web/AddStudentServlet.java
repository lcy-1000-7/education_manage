package com.chinasoft.education_manage.web;

<<<<<<< HEAD
import com.chinasoft.education_manage.domain.Student;
import com.chinasoft.education_manage.service.StudentService;
import com.chinasoft.education_manage.service.impl.StudentServiceImpl;
import com.chinasoft.education_manage.utils.StudentUtils;

=======
>>>>>>> 6b002d26b49f6047317ddbecd5c0bcf6f33a3057
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
<<<<<<< HEAD
        Student student = StudentUtils.populate(new Student(),request.getParameterMap());
        StudentService studentService = new StudentServiceImpl();
        studentService.addStudent(student);
        response.sendRedirect(request.getContextPath()+"/studentMessageServlet?pageNum=1&rows=5");
=======
        Student student =
>>>>>>> 6b002d26b49f6047317ddbecd5c0bcf6f33a3057
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 6b002d26b49f6047317ddbecd5c0bcf6f33a3057
