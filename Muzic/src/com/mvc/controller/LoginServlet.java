package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.LoginDao;
import com.mvc.model.LoginBean;

public class LoginServlet extends HttpServlet{
	public LoginServlet() {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginbean = new LoginBean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);
		LoginDao logindao = new LoginDao();
		String userValidate = logindao.authenticateUser(loginbean);
		HttpSession session = request.getSession();
		if(userValidate.equals("SUCCESS")) {
			request.setAttribute("username", username);
			session.setAttribute("username", username);
			session.setAttribute("idusers", loginbean.getId());
			System.out.println(session.getAttribute("idusers"));
			request.getRequestDispatcher("/Home.jsp").forward(request, reponse);
		}
		else {
			session.setAttribute("errMessage", userValidate);
			request.getRequestDispatcher("/Login.jsp").forward(request, reponse);
		}
		
	}
}
