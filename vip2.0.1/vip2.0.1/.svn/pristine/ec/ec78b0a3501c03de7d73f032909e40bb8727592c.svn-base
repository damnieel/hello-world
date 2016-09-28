/**
 * 公用函数
 */
function getEachData(e, str, array) {
	var id = $(e).data(str);
	if(isEmpty(id)) 
		return array;//continue
	if(isEmpty(array)) array=id;
	else array=array+","+id;
	return array;
}

/**
 * 获取选中checkbox的data值
 * var res = getData("id","name");
 *	console.log(res[0]);
 *	console.log(res[1]);
 */
function getData(){
	var index = arguments.length;
  	var param = arguments;
	var checkedData = new Object();
	$("input:visible:checked").each(function(){
	    for(var i=0; i<index;i++) {
	      checkedData[i]=getEachData(this, param[i], checkedData[i]);
	    }			
	});
	return checkedData;
}
/**
 * 处理后返回
 */
function backHandler(msg){
	msg = eval("("+ msg +")");
	if(!msg.result) {
		tmLoading(msg.msg, 3);
		return;
	} else {
		tmLoading(msg.msg, 3);	
		setTimeout(function(){
			window.location.reload();
		}, 3);
	}
}  
function getSubMenuByAjax() {
	$.ajax({
			type : "get",
	    	async: false,
			url : basePath + "admin/menu/getSubMenu.htmls", //加载子菜单
			success: function (data) {
				subMenu = eval("("+data+")");
			}
	});
	return subMenu;
}
function getTheSubMenuInfo(subMenuObject, givenParam) {
	var subMenuInfo = new Object();
	$.each(subMenuObject, function(n, em){
		  if(givenParam == em.menuLableId) {
	  		  subMenuInfo.url = basePath + em.url;
	          subMenuInfo.name = em.name;
	  		  subMenuInfo.menuLableId = em.menuLableId;
	          subMenuInfo.parentMenuLableName = em.parentMenuLableName;
	          subMenuInfo.parentMenuLableId = em.parentMenuLableId;
		  }
		  if(givenParam == em.url) {
	  		  subMenuInfo.url = basePath + em.url;
	          subMenuInfo.name = em.name;
	  		  subMenuInfo.menuLableId = em.menuLableId;
	          subMenuInfo.parentMenuLableName = em.parentMenuLableName;
	          subMenuInfo.parentMenuLableId = em.parentMenuLableId;
		  }
	});
	return subMenuInfo;
}
/**
 * 获取当前菜单的信息， 根据cookie或者当前路径
 */
function getSubMenuInfo(givenParam) {
//	var curPage = getCookie("menu");
	var subMenuInfo = new Object();
	if(typeof(subMenuData) == "undefined") {
		subMenuList = getSubMenuByAjax();
		window.subMenuData = subMenu;
	}
	subMenuInfo = getTheSubMenuInfo(subMenuData, givenParam);
	return subMenuInfo;
}
/**
 * 处理后返回上一页面 
 */
function backToBefore(msg){
	msg = eval("("+ msg +")");
	if(!msg.result) {
		tmLoading(msg.msg, 3);
		setTimeout( function(){
			window.location.reload();
		}, 2000)
	} else {		
		var menu = getCookie("menu");
		var subMenuInfo = getSubMenuInfo(menu);
		tmLoading(msg.msg, 2);
		setTimeout( function(){
			window.location.href = subMenuInfo.url;
		}, 2000)
	}
}  
function backArrayObject(msg) {
	msg = eval("("+ msg +")");
	if(isEmptyObject(msg)) {
		console.log("删除成功！");
		window.location.reload();
	}
	$.each(msg,function(n,value) {   
		console.log(value);
		tmLoading(value, 2);
   	});
}
/**
 * 发送分班信息
 */
function sendToServer(url, sendData, callBack) {	
	tm_dialoag.confirm({content:sendData.content,callback:function(ok){
			if(!ok){
				return false;
			} else {
				$.post(url, sendData, callBack);
			}
		}
	});
}
/**
 * 判断一个对象是否为空
 */
function isEmptyObject(obj){
    for(var n in obj){return false} 
    return true; 
} 

/**
 * 获取界面显示名称字段
 */
function getNameFive()	{ 	
	var disName="";
	var index = 0;		
	$("input:checked").each(function(){
	  var name = $(this).data("name");
	  if(!(isEmpty(name))) {
		  if(index < 5) 
		  	disName = disName + "," + name;
		  else if(index == 5) {
		  	disName = disName + "...";	
		  }
		  index ++;
	  }
	})	
	disName = disName.substring(1);
	disName = disName+"'"+index;
	return disName;
}
/**
 * 时间控件初始化函数
 */
function tzchangeyear(dp){
    $("#keybirthday").val(dp.cal.getNewDateStr());
}
/**
 * 获取search内容
 */
function getSearchVO() {
	var searchVO = new Object();
//	var orgId = $("#element_id>select:visible:last").val();
	var dom = $("#element_id>select:visible:last");
	var orgId = (dom.val() == 0)?dom.prev("select").val():dom.val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	var keyWord = $("#keyWord").val();
	var isArrears = $("#isArrears").val();
	var isRefund = $("#isRefund").val();
	var gradeStatue = $("#gradeStatue").val();
	var startChangeTime = $("#startChangeTime").val();
	var endChangeTime = $("#endChangeTime").val();
	var statue = $("#statue").val();
	
	if(!isEmpty(orgId)) {
		searchVO.organizationId = orgId;//部门id
	}	
	if(!isEmpty(startDate)) {
		searchVO.startDate = startDate;//起始日期
	}	
	if(!isEmpty(endDate)) {
		searchVO.endDate = endDate;//结束日期
	}	
	if(!isEmpty(keyWord)) {
		searchVO.keyWord = keyWord;//搜索关键字
	}	
	if(!(isEmpty(isArrears) || isArrears ==0)) {
		searchVO.isArrears = isArrears;//是否欠费
	}	
	if(!(isEmpty(isRefund) || isRefund ==0)) {
		searchVO.isRefund = isRefund;//是否退费
	}	
	if(!(isEmpty(gradeStatue) || gradeStatue ==0)) {
		searchVO.gradeStatue = gradeStatue;//班级状态
	}	
	if(!(isEmpty(startChangeTime))) {
		searchVO.startChangeTime = startChangeTime;//退休学起始时间
	}		
	if(!(isEmpty(endChangeTime))) {
		searchVO.endChangeTime = endChangeTime;//退休学结束时间
	}		
	if(!(isEmpty(statue) || statue ==0)) {
		searchVO.statue = statue;//学员状态  退学或者休学
	}
	return searchVO;	
}
$(function(){	
	$(document).unbind("keydown").keydown(function(event){ 
		var keycode=document.all?event.keyCode:event.which;
		if($(".sure_delet").length == 1) {
			setTimeout(function(){
				$(".sure_delet").find("a").eq(0).click();
			}, 100);
		} else {
			if(keycode==13){
				$(".search_icon").click();
			}
		}
	}); 
	//输入框 js
	$(".boxbor").unbind("focus").focus(function(){
		$(this).css({"border-color":"#04b4b3","box-shadow":"0px 0px 4px rgba(4,180,179,0.3)"});
		$(this).next(".search_icon").css({"background-position":"-151px -29px"});
	});
	$(".boxbor").unbind("blur").blur(function(){
		$(this).css({"border-color":"#dcdcdc","box-shadow":"none"});
		$(this).next(".search_icon").css({"background-position":"-135px -29px"});
	});
	var href = window.location.href;
	var curUrl = href.replace(basePath, "");
	var subMenuInfo = getSubMenuInfo(curUrl);
	if(!isEmptyObject(subMenuInfo)) {
		setCookie("menu", subMenuInfo.menuLableId);
	}
});
 