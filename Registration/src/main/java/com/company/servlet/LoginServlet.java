package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImpl();
       
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(userDao.isValidUser(username,password)) {
//			System.out.println("hi roshan");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("Welcome.jsp");
		}	
//		if(username.equals("roshan")) {
//			response.sendRedirect("/Welcome.jsp");
//		}
		else {
			response.sendRedirect("Login.jsp?error=1");
			System.out.println("error is occured!!!");
		}
	}
}


