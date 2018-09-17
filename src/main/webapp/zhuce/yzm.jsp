<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统注册</title>
    <link href= "../zhuce/zhuce1.css"rel="stylesheet" type="text/css">
    <link href= "../zhuce/zhuce2.css"rel="stylesheet" type="text/css">
    <link href= "../zhuce/zhuce3.css"rel="stylesheet" type="text/css">
</head>
<body>
<header>
		<div class="zhucedb">
			<div class="zhucebj">
				<div class="zhucelogo">
					<img src="../images/zhucelogo.png">
				</div>
			</div>
		</div>
</header>
<article>
<div class="main">
    <div class="main-form">
        <form action="../yzm" id="form" method="post">
            <div class="form-content">
                <div class="phone-res">
                <div class="form-group">   
                	<%
	String str = "";
	if(request.getAttribute("yzm_failed")!=null){
		str = (String)request.getAttribute("yzm_failed");
	}
		%>
	 <p><%=str%> </p>                   
                    <div class="form-group">
                        <label for="yzm">请输入验证码</label>
                        <div class="input-group">
                            <input id="pwd" type="text" name="code" placeholder="请输入验证码"/>
                            <em></em>
                        </div>
                    </div>
                    <div class="form-group marl">
                         <input class="login-btn" type="submit" value="点击提交">
                    </div>

                </div>
            </div>
         
        </form>
    </div>
</div>
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
<script src="../zhuce/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="../zhuce/drag.js" type="text/javascript"></script>
<script type="text/javascript">
    // input 聚焦清空 离开还原 用户输入时 后边出现清空按钮,点击可以清空
    ~function () {

        //input 聚焦清空 离开还原 用户输入时 后边出现清空按钮,点击可以清空
        function inputFun(input_id) {
            var input_id = document.getElementById(input_id), new_i = document.createElement("i");
            new_i.innerHTML = "×";
            input_id.val = input_id.getAttribute("placeholder"); // 自定义属性
            //聚焦时清空placeholder
            input_id.onfocus = function () {
                this.setAttribute("placeholder", "");
                this.style.color = "#333";
            };
            input_id.onblur = function () {
                this.setAttribute("placeholder", this.val);
                this.style.color = "#888";
            };

            // 用户输入时同时出现后边的清空按钮
            input_id.onkeydown = function () {
                if (this.value != "") {
                    this.parentNode.appendChild(new_i);
                }
            };
            input_id.onkeyup = function () {
                if (this.value == "") {
                    this.parentNode.removeChild(new_i);
                }
            };

            // 点击请空按钮 input 输入清空
            new_i.onclick = function () {
                this.parentNode.children[0].value = "";
                this.parentNode.removeChild(this);
            }
        }

        inputFun("userName");
        inputFun("pwd");
    }();

    //滑动验证
    $('.drag').drag();

    //点击获取验证码
    ~function () {
        function getCode(btnId) {
            var getCodeBtn = document.getElementById(btnId);
            var timer = null, num = 30;
            getCodeBtn.onclick = function () {
                var _this = this;
                this.className = "clicked";
                this.disabled = true;
                timer = window.setInterval(function () {
                    if (num == 0)
                    {
                        _this.className = "";
                        _this.disabled = false;
                        _this.innerHTML = "获取验证码";
                        clearInterval(timer);
                        num = 30;
                        return;
                    }
                    _this.innerHTML = num-- + " s后重新获取";
                }, 1000);
            }
        }

        getCode("getCodeBtn");
        getCode("getCodeBtn0");
    }();
    // 选项卡
    ~function () {
        var lis = document.getElementById("form").children[0].getElementsByTagName("li");
        var form_contents = $(".form-content");
        console.log(form_contents.length);
        for (var i = 0; i < lis.length; i++) {
            var liEle = lis[i];
            liEle.index = i;
            liEle.onclick = function () {
                for (var j = 0; j < lis.length; j++) {
                    var liLink = lis[j];
                    liLink.className = "";
                    form_contents[j].className = "form_contents hide";
                }
                this.className = "cur-tab";
                form_contents[this.index].className = "form_contents show";
            }
        }
    }();
</script>
</body>
</html>