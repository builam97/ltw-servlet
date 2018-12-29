package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/idparam")
public class favoriteServlet extends HttpServlet{
	private static final long serialVersionUID = 2L;
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 { 
		  String idstr = request.getParameter("idmusic");
		     request.setAttribute("idmusic",idstr);
		  RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Home.jsp");
		  requestDispatcher.forward(request, response);
		  }
}
