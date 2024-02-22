package edu.jsp.sessionmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet (name= "pageb" , urlPatterns = {"/getv"})
public class PageB extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		
		String dbname=(String)session.getAttribute("dbname");
		String dbpass=(String)session.getAttribute("dbpass");

		Student student=new Student(1, "a", "a@mail.com", "1gdydfd12");
		session.setAttribute("student",student);
		
		
		PrintWriter writer=resp.getWriter();
		writer.write("dbname: "+dbname);
		writer.write("dbpass: "+dbpass);
	}

}
