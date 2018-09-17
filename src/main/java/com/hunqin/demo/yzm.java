package com.hunqin.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hunqin.DAO.User;
import com.hunqin.user.UserDao;
import com.hunqin.util.DBUtils;
public class yzm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String code = request.getParameter("code");
			response.setContentType("text/html;charset=utf-8");
			HttpSession session = request.getSession();
			String username=(String) session.getAttribute("username");
			String password=(String) session.getAttribute("password");
			String email=(String) session.getAttribute("email");
			User user = new User(username,  email,password, 0, code);
			System.out.println(code);
			UserDao dao =new UserDao();
			if(code!="" ) {
				if(dao.db(user)) {
					System.out.println(1);
					 dao.Stat(user);
					 response.getWriter().println("登录成功");
					response.sendRedirect("login/login.jsp");
				}else {
					response.getWriter().println("验证码错误");
				}
				}else {
					response.getWriter().println("验证码错误");
			}
			}
	}
