$(function(){
	/**点击新增职业弹出层 js**/
	$(".addP").click(function(){
		$(".addProfession").fadeIn(200);
	});
	$(".Quit").click(function(){
		$("#codeValue").val("");
		$(".addProfession").hide();
	});
	
	/***删除职业数据****/
	$("body").on("click",".deletInfo",function(){ 
		var check = getData("id");
		var ids = check[0];
		var totalnum = 0;
		$(".items").each(function() {
			if ($(this).prop("checked")) {
				totalnum ++;
			} 
		});
		if(totalnum<=0){
			tmLoading("请勾选要删除的记录",1);
			return false;
		}
		
		tm_dialoag.confirm({title:"删除",content:"您确定删除吗?",height:170,callback:function(ok){
			if(ok){
			if(isEmpty(check)){
				tmLoading("删除失败",2);
			}
			 $.tpAjax.request({
				 type:"post",
				url:basePath + "professional/professional/deleteProfessional.htmls",
				callback:function(data){
					var data =eval("("+data+")");
					if(data == "success"){
						tmLoading("删除成功",1);
						$(this).parents(".removetr").slideUp("1000",function(){
						  $(this).remove();
						});
						setTimeout(function(){
							delLocalCookie("pageId");
							getProfessinalCount();
						},1000);
					}else{
						tmLoading("删除失败",1);
					}
				}
			},{"degree":ids});}
		}}); 
	});
	
});

/***全选/反选***/
function SelectAll(){
	var check = $("#selectAll").prop("checked");
	if(check) {
		$("input[type=checkbox]").prop("checked", true);
	} else {
		$("input[type=checkbox]").prop("checked", false);
	}
};

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
	$("input:checked").each(function(){
	    for(var i=0; i<index;i++) {
	      checkedData[i]=getEachData(this, param[i], checkedData[i]);
	    }			
	});
	return checkedData;
}