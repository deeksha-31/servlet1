package edu.jsp.sendredirect;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="loaninfo" , urlPatterns = {"/loaninfo"})
public class LoadInfo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loan=req.getParameter("loan_type");
		
		if (loan != null) {
			if(loan.equalsIgnoreCase("car")) {
				PrintWriter writer=resp.getWriter();
				writer.write("<html><body><h1>car loan info</h1></body></html>");
			}
			else if(loan.equalsIgnoreCase("home")) {
				PrintWriter writer=resp.getWriter();
				writer.write("<html><body><h1>home loan info</h1></body></html>");
			}
			else if(loan.equalsIgnoreCase("personal")) {
				PrintWriter writer=resp.getWriter();
				writer.write("<html><body><h1>personal loan info</h1></body></html>");
			}
			else {
				resp.sendRedirect("https://www.google.com");
			}
		}
	}
}
