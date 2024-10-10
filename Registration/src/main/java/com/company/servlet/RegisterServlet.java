package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.User;
import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImpl();
	
    public RegisterServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String mail = request.getParameter("email");
		String pass = request.getParameter("password");
		
		User user = new User();
		
		user.setUsername(uname);
		user.setEmail(mail);
		user.setPassword(pass);
		
		if(userDao.addUser(user)) {
			response.sendRedirect("Login.jsp?registration=success");
		}else {
			response.sendRedirect("Register.jsp?error=1");
		}
	}

}
