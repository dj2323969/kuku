/**
 * 
 */
onload = function(){
	 var imgs = document.getElementById('d11').getElementsByTagName('img');
	/* 遍历每张图片*/
	for(var i=0;i<imgs.length;i++){
		var img = imgs[i];
		img.style.left = i*600+"px";
	}
}

function move(){
/* 开启移动图片的定时器*/
var moveId = setInterval(function(){
	 var imgs = document.getElementById('d11').getElementsByTagName('img');
	 for(var i=0;i<imgs.length;i++){
		 var img = imgs[i];
		 /* 得到之前的left值 -5 再放回去*/
		 var oldLeft = img.style.left;
		 oldLeft = parseInt(oldLeft);
		 oldLeft-=1;
		img.style.left = oldLeft+"px";
		
	 	/*判断是否移出了屏幕，如果是则left改为800*/
	 	if(oldLeft<=-600){
	 		oldLeft=2400;
	 		/*让移动的定时器停止*/
	 		clearInterval(moveId);
	 	}
	 	/* 把计算完之后的值放回去*/
	 	img.style.left = oldLeft+"px";
	 }
},1);
}
/*每隔3s调用一词Move 移动一张图片*/
var timeId;
/*鼠标移动到图片上面的时候*/
function stop(){
clearInterval(timeId);
}
function start(){
	/* 停掉之前的定时器避免连续开启多个定时器导致停不下来的Bug*/
 clearInterval(timeId);
  timeId = setInterval(move,3000);
}
/*让页面刚开始显示的时候就开启换图片的定时器*/
start();
/*页面失去焦点时， 停止移动*/
onblur = function(){
	stop();
}
/*获得焦点时,继续移动*/
onfocus = function(){
	start();
}