package com.hunqin.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hunqin.DAO.User;
import com.hunqin.user.UserDao;
//修改密码的类
public class modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String email =request.getParameter("email");
		String password = request.getParameter("password");
		String password1= request.getParameter("password1");
		System.out.println(password);
		System.out.println(password1);
		 UserDao dao = new UserDao();
		 User user = new User(email, password, password1);
		 int a=dao.findAll(user);
		 if(a==1) {
				  dao.Modify(user);//修改成功
					 request.setAttribute("modify_1","修改成功");
					 response.sendRedirect("login/login.jsp");
		 }else {
			  request.setAttribute("modify_3","修改失败，账号密码输入错误");
		 }
	}
}
