$(function() {
  	if(isEmpty(getCookie("menuData"))){
 		$.ajax({
			type : "GET",
			url : basePath + "admin/menu/getMenu.htmls",//加载一级菜单
			success : function(data) {
				setCookie("menuData",data);	
				var tdata = eval("(" + data + ")");
				menuLoad(tdata);
				bindclickFun();
				getsubMenu();
			}
		});
   }else{
   		var data=getCookie("menuData");
   	    tdata=eval("("+ data +")");		
     	menuLoad(tdata);
        bindclickFun();
	    getsubMenu();
    }
     $("#loginOut").on("click",function(){
		tm_dialoag.confirm({content:"你确定退出吗???",callback:function(ok){
			if(ok){
				delCookie("menu");
				delCookie("menuData");
				delCookie("submenuData"); 
				window.location.href=basePath+"admin/employee/logout.htmls";
			}		
		}});
	});
});
function bindclickFun(){
	$(".nav_list li p").bind("click",function(){
		var thi = $(this).parent("li");
		thi.addClass("onnav").siblings().removeClass("onnav");
		if(thi.hasClass("onnav")){
			if(thi.children(".down_list").css("display")=="block"){
				thi.children(".down_list").slideUp(200);
				thi.removeClass("onnav");
			}else{
				thi.children(".down_list").slideDown();
				thi.addClass("onnav");
			}
			thi.siblings().children(".down_list").slideUp();			
		}else{
			thi.children(".down_list").slideUp();
		}
	});
}
function getsubMenu(){
      if(isEmpty(getCookie("submenuData"))){
	      	if(typeof(subMenuData) == "undefined") {
		       $.ajax({
					type : "GET",
					url : basePath + "admin/menu/getSubMenu.htmls", //加载子菜单
				    success : function(data) {
				    	setCookie("submenuData",data);	
					    var tdata = eval("(" + data + ")");
						window.subMenuData = tdata;
						submenuLoad(tdata);			
					}
				});
	      	} else {
	      		submenuLoad(subMenuData);		
	      	}
      }else{
        var data =	getCookie("submenuData");
        tdata=eval("("+ data +")");	
        submenuLoad(tdata);			
      }
				
	
}
function menuLoad(tdata){
	var menu = getCookie("menu");
	var subMenuInfo = getSubMenuInfo(menu);
	var html="";
    for (var i = 0; i < tdata.length; i++) {
	    //循环拼出一级菜单Html
//	    if(i == 0) {
		if(subMenuInfo.parentMenuLableId == tdata[i].menuLableId) {
	    	html = html + "<li class='onnav'><p><i class='"+tdata[i].className+"'></i><span>"+tdata[i].name+"</span></p>" +
			"<div class='down_list'><ol id='" + tdata[i].menuLableId +
			 "'></ol></div> <div class='line_nav'></div>" +
			"</li>"
	    } else {
			html = html + "<li><p><i class='"+tdata[i].className+"'></i><span>"+tdata[i].name+"</span></p>" +
			"<div class='down_list'><ol id='" + tdata[i].menuLableId +
			 "'></ol></div> <div class='line_nav'></div>" +
			"</li>"
	    }
	}
	$(".leftHead").append(html);
}
function submenuLoad(tdata){
	var menu = getCookie("menu");
	var html = "";
	//循环插入子菜单
    for (var i = 0; i < tdata.length; i++) {
    	if(tdata[i].menuLableId == menu) {
    		/**
    		 * 根据cookie中子菜单的id，更改子菜单和主菜单的样式
    		 */
    		html = "<li><a class='onlistnav' href='"+basePath + tdata[i].url+"' id='"+
	    		tdata[i].menuLableId+"'>"+tdata[i].name+"</a></li>"; 
	    	$("#" + tdata[i].parentMenuLableId + "").parent().attr("style", "display:block");
	    	$("#" + tdata[i].parentMenuLableId + "").parents("li").attr("class", "onnav");
    	} else {    		
    		html = "<li><a href='"+basePath + tdata[i].url+"' id='"+
	    		tdata[i].menuLableId+"'>"+tdata[i].name+"</a></li>"; 
    	}
    	
		$("#" + tdata[i].parentMenuLableId + "").append(html);
		$("#" + tdata[i].menuLableId + "").off("click").on("click",function() {
			 setCookie("menu", $(this).attr("id"));
			 
			 $(this).parent().parent().find("a")
			 .removeClass("subnav-xuanz");
			 $(this).addClass("subnav-xuanz");
			 var url = "";
			 url = $(this).attr("href");
			 window.location.href =  url;
		});
	}
}



