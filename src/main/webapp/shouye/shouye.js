/**
 * 
 */
onload = function(){
		var imgs = document.getElementById("lbt").getElementsByTagName("img");
		for(var i=0;i<imgs.length;i++){
			var img = imgs[i];
			img.style.left=i*1905+"px";
		}
	}
	function move(){
	/* 开启移动图片的定时器 */
	var moveId=setInterval(function(){
		var imgs = document.getElementById("lbt").getElementsByTagName("img");
		for(var i=0;i<imgs.length;i++){
			var img=imgs[i];
			/* 得到之前的left值-5再放回去 */
			var oldLeft = img.style.left;
			/* 把字符串改成数值 */
			oldLeft = parseInt(oldLeft);
			oldLeft-=5;
			/* 判断是否移出屏幕了 如果是 则把left改为800 */
			if(oldLeft<=-1905){
			oldLeft=3810;
			/*  */
			clearInterval(moveId);
			}
		/* 把计算完的之后的值放回去 */
		img.style.left=oldLeft+"px";
		}
	},1);
	}
	var timeId;
	/* 鼠标移动到图片上面的时候 */
	function stop(){
		clearInterval(timeId);
	}
	/* 鼠标移出图片的时候 */
	function start(){
		/* 停掉之前的定时器，避免连续开启多个定时器导致听不下来的bug */
		clearInterval(timeId);
		/* 每隔3秒执行一次move */
		timeId=setInterval(move,3000);
	}
	/* 让页面刚开始显示的时候就开启还图片的定时器 */
	start();
	/* 页面失去焦点时停止移动 */
	onblur = function(){
		stop();
	}
	/* 让页面获得焦点时继续移动 */
	onfocus = function(){
		start();
	}