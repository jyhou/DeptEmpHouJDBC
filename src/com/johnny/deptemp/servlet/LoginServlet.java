package com.johnny.deptemp.servlet;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;
import com.johnny.deptemp.utility.LoadDB;
import com.johnny.deptemp.utility.UserUtility;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1640326258280507140L;

	public static void main(String[] args) {

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("password");
		boolean isValidUser = true;
		if(userName.isEmpty() && pwd.isEmpty()){
			request.setAttribute("isValidUser", false);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			isValidUser = UserUtility.validateUser(userName, pwd, request);
		
		    if (isValidUser){
			    request.getSession().setAttribute("isValidUser",true);
			    request.getSession().setAttribute("currentUser", userName);
			    // Load data from DB
			    List<Department> allDept = LoadDB.loadDept();
			    List<Employee> allEmp = LoadDB.loadEmp();
			    request.getServletContext().setAttribute("allDept", allDept);
			    request.getServletContext().setAttribute("allEmp", allEmp);			    
			    request.getRequestDispatcher("/success.jsp").forward(request, response);
		    }else{
			    request.setAttribute("isValidUser", false);
			    request.getRequestDispatcher("/index.jsp").forward(request, response);
		    }
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws IOException, ServletException{
		doGet(request, reponse);
	}

}
