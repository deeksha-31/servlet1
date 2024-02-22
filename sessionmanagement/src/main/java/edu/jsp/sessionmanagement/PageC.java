package edu.jsp.sessionmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (name= "pagec" , urlPatterns = {"/getvo"})
public class PageC extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		PrintWriter writer=resp.getWriter();
		
		String dbname=(String)session.getAttribute("dbname");
		String dbpass=(String)session.getAttribute("dbpass");
		
		Student student = (Student) session.getAttribute("student");
	
		writer.write("dbname: "+dbname);
		writer.write(" dbpassword: "+dbpass);
		writer.write(" Student id : "+student.getId());
		writer.write(" Name : "+student.getName());
		writer.write(" Email : "+student.getEmail());
		writer.write(" Password : "+student.getPassword());
	
	
	}

}
