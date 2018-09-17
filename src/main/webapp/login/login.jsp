<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	<header>
		<div id="bj">
			<img src="../images/dlBG.jpg">
		</div>
		<div id="logo">	
			<a href="#">
				<img src="../images/m_logo.png">
			</a>
		</div>	
		<div id="logo2">
			<img src="../images/dl03_mj.png">
		</div>
	</header>
	<article>
	<form action="login" method="post">
	<div id="form_div">
	<%
	String str = "";
	if(request.getAttribute("login_failed")!=null){
		str = (String)request.getAttribute("login_failed");
	}
		%>
	 <p><%=str%> </p>
		<div class="field">
			<input type="text" id="username" placeholder="请输入您的邮箱号" name="email">
		</div>
		<div class="field">
			<input type="password" id="password" placeholder="请输入您的密码"name="password">
		</div>
		<div class="save_div">	
			<span id="span1">
				<input type="checkbox" id="zddl">
				<label for="zddl">下次自动登录</label>
			</span>
			<a id="a1" href="#" >忘记密码？</a>
		</div>
		<div id="a2">
			<input type="submit" value="登录">
		</div>
			<div id="a3">
				<a href="">注册帐号</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="#">快速登录</a>
			</div>
	</div>
	</form>
	</article>
	<footer>
		<div id="shang"></div>
		<div id="zhong">
			<div id="zhong1">
			<ul>
				<li id="li1">
					<ul>
						<li>买家帮助</li><br><br>
						<li>新手指南</li>
						<li>服务保障</li>
						<li>常见问题</li>
					</ul>
				</li>	
				<li id="li2">
					<ul>
						<li>关于我们</li><br><br>
						<li>加入我们</li>
						<li>隐私保护</li>
						<li>免责声明</li>
					</ul>
				</li>
				<li id="li3">
					<ul>
						<li>商家入驻</li><br><br>
						<li>个人中心</li>
						<li>商户入驻</li>
						<li>婚礼百科</li>
					</ul>
				</li>
			</ul>
			</div>		
		</div>
		<div id="xia"></div>	
	</footer>
</body>
</html>