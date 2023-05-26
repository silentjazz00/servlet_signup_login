package Cantroller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;
@WebServlet("/signup")
public class SignupServlet  extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		
	

		Student student=new Student();
		student.setEmail(email);
		student.setGender(gender);
		student.setName(name);
		student.setPassword(password);
//		student.setPhone(Long.parseLong(req.getParameter("number")));
		
		StudentDao dao=new StudentDao();
		dao.save(student);
		
		res.getWriter().print("<h1>Data saved succesfully</h1>");
	}

}