<%@page import="java.util.List"%>
<%@page import="com.hunqin.user.*"%>
<%@page import="com.hunqin.entity.Items"%>
<%@page import="com.hunqin.DAO.ItemsDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="car.css">
<body>
 
	<div id="idid">
	<canvas id="c" style="position: absolute;z-index: -1;text-align: center;"></canvas> 
<div id="d2">
<a href="#"><span>自选标签</span></a><span>></span><a href="#"><span>兰博基尼</span></a>
</div>
<hr>
 
 
<div id="d1">
<div id="d11">
<div class="banner" id="banner1" >
		<div class="banner-view"></div>
		<div class="banner-btn"></div>
		<div class="banner-number"></div>
		<div class="banner-progres"></div>
	</div>
</div>
<div id="d12">
	<div id="d121">
	 <ul><li>兰博基尼<li></ul>
	</div>
	<hr>
	<div class="box">
	<div class="d2d"> 
	 <ul>
	 <li>汽车名称：</li>
	 <li><div class="box0">兰博基尼</div></li>
	 </ul>
	 </div>
		
  <div class="d2d">
  <ul>
  <li>汽车产地：</li>
	<input type="button" onclick="add2()" id="m" name="q" value="意大利" class="box1">
    </ul> 
  </div>
    <div class="d2d">
      <ul>
      <li>汽车价格：</li>
	<input type="button" onclick="add5()" id="qt"  name="q" value="1元" class="box3">
    </ul>
    </div>
    <div class="d2d">
    <ul>
    <li>是否扎花：</li>
	<input type="button" onclick="add4()" id="e" name="q" value="扎花" class="box6">
    </ul>  
  </div>
	<hr>
	<div id="d13">
	 <ul>
	 <div class="box7" id="p1" style="width:160px;"><a href="details.jsp?id=1" style="margin-left: 0;border:0;background:0 ;">商品详情</a></div>
	 </ul>
	  	<a href="#" class="d141"> 咨询客服</a>
	  <form action="gwc" method="post">
	    <div style="text-align:right;font-size:36px;">

</div>
	</form>
	</div>
	<div id="d14">
	<ul>
	<li>此价格为长沙市内4小时/40公里内，原则每天仅限一单，重大节假日以及黄道吉日价格将有所变动，具体以车队长报价为准 </li>
	</ul>
	</div>
	<hr>
	</div>
	
</div>
</div>
 
<div id="d3">
<div id="d31">
<img alt="" src="../image/hc70.jpg">
</div>
<div id="d32">
<img alt="" src="../image/hc72.jpg">
</div>
<hr>
<div id="d33">
<img alt="" src="../image/hc73.png">
</div>
</div>

<div id="d4">
<div id="d41"><img alt="" src="../image/hc74.png"></div>
<div id="d42" ><img alt="" src="../image/hc71.jpg"></div>
</div> </div>
<script src="jquery-3.3.1.slim.min.js"></script>
<script type="text/javascript" src="banner.js"></script>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="canvas_bg.js" ></script>

 <script type="text/javascript">
	var banner = new FragmentBanner({
		container : "#banner1",//选择容器 必选
		imgs : ['../image/hc61.jpg','../image/hc62.jpg','../image/hc63.jpg','../image/hc64.jpg'],//图片集合 必选
		size : {
			width : 573,
			height : 464
		},//容器的大小 可选
		//行数与列数 可选
		grid : {
			line : 12,
			list : 14
		},
		index: 0,//图片集合的索引位置 可选
		type : 2,//切换类型 1 ， 2 可选
		boxTime : 5000,//小方块来回运动的时长 可选
		fnTime : 10000//banner切换的时长 可选
	});
	 
</script>
</body>
</html>