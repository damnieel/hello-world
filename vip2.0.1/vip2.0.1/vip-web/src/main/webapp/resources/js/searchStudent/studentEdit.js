function changeContent(em){
	  $(em).children("input").show();
	  $(em).children("input").focus();
	  $(em).children("span").hide();
}
function showOrHide(ems){
	  $(ems).hide();
  	  $(ems).siblings("span").show();
}
$(".ondbl1").dblclick(function(){
	  changeContent(this);
    });
$(".ondbl2").dblclick(function(){
	  changeContent(this);
    });
$(".ondbl3").dblclick(function(){
	  changeContent(this);
    });
$(".stuName").blur(function(){
	  showOrHide(this);
    });
$(".telephone").blur(function(){
	  showOrHide(this);
    });
$(".QQ").blur(function(){
      showOrHide(this);
});
	      
$(".again_btn").click(function(){
	  var id = $(this).data("id");
	  var stuNameIn =$(this).parent("td").siblings(".ondbl1").children("input").val();
	  var telephoneIn =$(this).parent("td").siblings(".ondbl2").children("input").val();
	  var QQIn =$(this).parent("td").siblings(".ondbl3").children("input").val();
	  var stuName = $(this).parent("td").siblings(".ondbl1").children().text();
      var telephone =$(this).parent("td").siblings(".ondbl2").children().text();
      var QQ = $(this).parent("td").siblings(".ondbl3").children().text();
      var inte = /^-?\d+$/ ;	//验证整数型
      
	  if(stuNameIn == stuName && telephoneIn == telephone && QQIn == QQ){
		    tmLoading("请双击要修改的学员信息",2);
		    return false;
	  }
	  if(stuNameIn.length>10){
		    tmLoading("学员姓名长度过长",2);
		    return false;
	  }else if(isEmpty(stuNameIn)){
		    tmLoading("学员姓名不能为空",2);
		    return false;
	  }
	  if(telephoneIn.length > 12){
            tmLoading("请输入正确的电话号码",1);
            return false;
      }
	  if(isEmpty(QQIn)){
            tmLoading("请输入QQ",1);
           	return false;
      }else if(QQIn.length < 5){
         	tmLoading("QQ长度太短，至少5位",1);
         	return false;
      }else if(!inte.test(QQIn)){
          	tmLoading("只能是数字,不能有空格",1);
          	return false;
      }else if(QQIn.length>14){
          	tmLoading("QQ长度太长",1);
          	return false;
      }
     
	  tm_dialoag.confirm({
    		sureText : "确定",
    		canceText : "取消",
    		content : "您确定修改学员信息吗?",
    		callback : function(ok) {
	   $.tpAjax.request({
			url:basePath+"student/studentSearch/updateStudent.htmls",
			callback:function(data){
				var data =eval("("+data+")");
				if(data == 1){
					tmLoading("修改成功",1);
					search();
				}else if(data == 0){
					tmLoading("修改失败",1);
				}else if(data == 2){
					tmLoading("系统存在该学员信息", 2);
				}
			}
		},{  "id":id,"stuName":stuNameIn,"telephone":telephoneIn,"QQ":QQIn}); 
    	}});
  });
  	