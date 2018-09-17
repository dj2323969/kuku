package com.hunqin.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hunqin.DAO.User;
import com.hunqin.user.UserDao;

public class zhuce extends HttpServlet{
	protected void service(HttpServletRequest resquest, HttpServletResponse response) throws ServletException, IOException {
		resquest.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = resquest.getParameter("username");
		String password = resquest.getParameter("password");
		String email = resquest.getParameter("email");
		String code =rand.random();
		HttpSession session = resquest.getSession();
		session.setAttribute("username",username);
		session.setAttribute("email",email);
		session.setAttribute("password",password);
		if(username!=""&&password!=""&&email!="") {
		User user = new User(username, email,password, 0,code);
		UserDao dao =new UserDao();
		dao.finnd(user);
		
		System.out.println("发送成功");
		new Thread(new MailUtil(email, code)).start();
		response.sendRedirect("../zhuce/yzm.jsp");
	}else {
		out.print("发送失败");
	}
	}
}
