package com.hunqin.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.hunqin.DAO.User;
import com.hunqin.util.DBUtils;
public class UserDao {
	//修改密码  ：修改密码
	public int Modify(User user) {
		 Connection conn= null;
		 PreparedStatement stat=null;
		 String password =user.getPassword();
		 String password1=user.getPassword1();
		 try {
			conn=DBUtils.getconn();
			String sql = "update user set password=? where email=?";
			stat=conn.prepareStatement(sql);
			stat.setString(1,password1);
			stat.setString(2,user.getEmail());
			stat.executeUpdate();
		
		 } catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, stat, null);
		}
		return 0;
	}
	
	//如果激活成功，将state的状态改为1的方法
	public void Stat(User user) {
		Connection conn=null;
		PreparedStatement stat = null;
		try {
			conn=DBUtils.getconn();
			String sql = "update user set state =1 where email=?  ";
			stat= conn.prepareStatement(sql);
			stat.setString(1,user.getEmail());
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//对比user表和yzm表的email和code是否相等，如果相等则去判断state状态是否为1
	public boolean db(User user) {
		Connection conn=null;
		PreparedStatement stat = null;
		ResultSet rs =null;
		try {
			conn=DBUtils.getconn();
			String sql = "select count(*) from yzm where email=? and code=?";
			stat=conn.prepareStatement(sql);
			stat.setString(1,user.getEmail());
			stat.setString(2,user.getCode());
			rs=stat.executeQuery();
			int count=0;
			while(rs.next()) {
			count =rs.getInt(1);
			}
			if(count>0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	
	}
	//在第二个yzm表中加入邮箱和验证码以便判断
	private void yzm(User user) {
		Connection conn=null;
		PreparedStatement stat = null;
		String email = user.getEmail();
		String code = user.getCode();
		try {
			conn=DBUtils.getconn();
			String sql="insert into yzm values(?,?)";
			stat=conn.prepareStatement(sql);
			stat.setString(1,email);
			stat.setString(2,code);
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//注册方法
	public void finnd(User user) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		String username = user.getUserName();
		String password = user.getPassword();
		String email = user.getEmail();
		String code = user.getCode();
		try {
			Thread.sleep(2000);
			conn = DBUtils.getconn();
			String sql = "insert into user values(null,?,?,?,0,?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, email);
			stat.setString(3, password);
			stat.setString(4, code);
			stat.executeUpdate();
			yzm(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, stat, null);
		}
	}
	 //删除方法
	public void delete (int id) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			conn= DBUtils.getconn();
			String sql = "delete from user where id = ?";
			stat=conn.prepareStatement(sql);
			stat.setInt(1,id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			DBUtils.close(conn, stat, null);
		}
	}
	 
	//登陆邮箱密码判断
	public  int findAll(User user){
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getconn();
			String sql ="select count(*) from user where email=? and password=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1,user.getEmail());
			stat.setString(2,user.getPassword());
			rs = stat.executeQuery();
			int count = 0;
			while(rs.next()) {
			count = rs.getInt(1);
			}
			if(count==0) {
			return 0;
			}else {
			return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw  new RuntimeException(e);
		}finally {
			DBUtils.close(conn, stat, rs);
		}
	}
}