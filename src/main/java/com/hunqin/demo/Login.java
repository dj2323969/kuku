package com.hunqin.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hunqin.DAO.User;
import com.hunqin.user.UserDao;
import com.hunqin.util.DBUtils;

public class Login  extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//发送Cook
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		UserDao dao =new UserDao();
			User user= new User(username, email, password,1, code);
			int a=dao.findAll(user);
			if(a==1&&user.getState()==1) {
				HttpSession session = request.getSession();
		 		  session.setAttribute("username",username);
		 		  //登录成功,重定向到用户列表
		 		  response.sendRedirect("../shouye/shouye.jsp");
			}else {
				 //登录失败，转发到登录页面，并提示用户
			  request.setAttribute("login_failed","邮箱暂未激活或者账号密码错误");
	 			  request.getRequestDispatcher("../login/login.jsp").forward(request,response);
			}
	}

}
