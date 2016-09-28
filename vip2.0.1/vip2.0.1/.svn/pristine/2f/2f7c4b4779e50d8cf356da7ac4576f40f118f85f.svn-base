/** *浏览器兼容(回车事件)** */
document.onkeydown = function(e) {
	var keycode = document.all ? event.keyCode : e.which;
	if (keycode == 13) {
		$("#search").click();
	}
}




var orgId = 1,timeRangeType = 2,startDate,endDate;
$(function(){
	$('input[name=time][value=2]').prop("checked",true);
	$("#startDate").attr("disabled","disabled");
	$("#endDate").attr("disabled","disabled");
	
	showEchart();
	$("#search").on("click",function(){
		  var dom = $("#element_id>select:visible:last");
		  var orgProCalId = (dom.val() == 0)?dom.prev("select").val():dom.val();
		  orgId = !isNaN(orgProCalId)?orgProCalId :1;
		  timeRangeType = $('input:radio[name="time"]:checked').val();
		  startDate = $("#startDate").val();
		  endDate = $("#endDate").val();
		  if(timeRangeType ==5){
			  //只填写一个校验
			  if((isEmpty($("#startDate").val())!=isEmpty($("#endDate").val()))){
				  if(isEmpty($("#startDate").val())){
					  tmLoading("请设置开始时间",1);
					  return false;
				  }
				  if(isEmpty($("#endDate").val())){
					  tmLoading("请设置结束时间",1);
					  return false;
				  }
			  }
		  }
		  showEchart();
	})
	
		
	$("input[name=time]").click(function(){
		var checkval = $('input[name=time]:checked').val();
		if(checkval == 5){
			$("#startDate").removeAttr("disabled");
			$("#endDate").removeAttr("disabled");
		}else{
			$("#startDate").val("");
			$("#endDate").val("");
			$("#startDate").attr("disabled","disabled");
			$("#endDate").attr("disabled","disabled");
		}
	});
	
	function showEchart(){
			$.ajax({
				url: basePath + "/dataStatistic/queStatisticData.htmls",
				data: {
					   "orgProCalId":orgId,
					   "startDate":startDate,
					   "endDate":endDate,
					   "timeRangeType":timeRangeType
					   },
				success : function(data) {
				    tdata=eval("("+ data +")");
				    setOption(tdata);
				    var myChart = echarts.init(document.getElementById('echart'),"macarons"); 
				    options.xAxis[0].data = org; 
				    options.series[0].data = excellent;
				    options.series[1].data = bad;
				    // 为echarts对象加载数据 
				    myChart.setOption(options); 
				}
		})  
	}	  
	// 基于准备好的dom，初始化echarts图表
    var attenData;
    var org = new Array();
    var excellent = new Array();
    var bad = new Array();
    
    var xData;
    var toolb = {
            show : true,
            orient: 'horizontal',      // 布局方式，默认为水平布局，可选为：
                                       // 'horizontal' ¦ 'vertical'
            x: 1500,                // 水平安放位置，默认为全图右对齐，可选为：
                                       // 'center' ¦ 'left' ¦ 'right'
                                       // ¦ {number}（x坐标，单位px）
            y: 'top',                  // 垂直安放位置，默认为全图顶端，可选为：
                                       // 'top' ¦ 'bottom' ¦ 'center'
                                       // ¦ {number}（y坐标，单位px）
            color : ['#1e90ff','#22bb22','#4b0082','#d2691e'],
            backgroundColor: 'rgba(0,0,0,0)', // 工具箱背景颜色
            borderColor: '#ccc',       // 工具箱边框颜色
            borderWidth: 0,            // 工具箱边框线宽，单位px，默认为0（无边框）
            padding: 5,                // 工具箱内边距，单位px，默认各方向内边距为5，
            showTitle: true,
            feature : {
                 mark : {
                    show : false,
                    title : {
                        mark : '辅助线-开关',
                        markUndo : '辅助线-删除',
                        markClear : '辅助线-清空'
                    },
                    lineStyle : {
                        width : 1,
                        color : '#1e90ff',
                        type : 'dashed'
                    }
                },
                dataZoom : {
                    show : false,
                    title : {
                        dataZoom : '区域缩放',
                        dataZoomReset : '区域缩放-后退'
                    }
                },
                dataView : {
                    show : true,
                    title : '数据视图',
                    readOnly: true,
                    lang : ['数据视图', '关闭', '刷新'],
                    optionToContent: function(opt) {
                        var axisData = opt.xAxis[0].data;
                        var series = opt.series;
                        var table = '<table style="width:100%;text-align:center"><tbody><tr>'
                                     + '<td>时间</td>'
                                     + '<td>' + series[0].name + '</td>'
                                     + '<td>' + series[1].name + '</td>'
                                     + '</tr>';
                        for (var i = 0, l = axisData.length; i < l; i++) {
                            table += '<tr>'
                                     + '<td>' + axisData[i] + '</td>'
                                     + '<td>' + series[0].data[i] + '</td>'
                                     + '<td>' + series[1].data[i] + '</td>'
                                     + '</tr>';
                        }
                        table += '</tbody></table>';
                        return table;
                    }
                },
                magicType: {
                    show : false,
                    title : {
                        line : '动态类型切换-折线图',
                        bar : '动态类型切换-柱形图',
                        stack : '动态类型切换-堆积',
                        tiled : '动态类型切换-平铺'
                    },
                    type : ['line', 'bar', 'stack', 'tiled']
                },
                restore : {
                    show : false,
                    title : '还原',
                    color : 'black'
                },
                saveAsImage : {
                    show : false,
                    title : '保存为图片',
                    type : 'jpeg',
                    lang : ['点击本地保存'] 
                },
            }
        }
    var dataZooms =  { //区域缩放
           show : true,
           realtime : true,
           y: 480,
           height: 20,
           start : 0,
           end : 100
       }
    var color ={
        	data:['#9ac940',"#30e0e0"]
    }
    var options = { //工具箱
			  tooltip: {
				   show: true
			   },
			  toolbox: toolb,
			  dataZoom :dataZooms,
			  legend: {
				   data:['好评率',"差评率"],
			   	   x:'1200'
			   },
			  color:color,
			  xAxis : [
			            {
			            	type : 'category',
			            	data : org
			            }
			            ],
              yAxis : [
                     {
                    	 type : 'value',
                    	 name : '百分比(%)'
                    		 
                     }
                     ],
              series : [
                    {
                 	   name:"好评率",
                 	   type:"bar",
                 	   barMaxWidth:26,
                 	   data:[] ,
                 	   itemStyle: {  
                 		          normal: { color:'#24bbea'}
  	    	              },
                    },
                    {
                  	   name:"差评率",
                  	   type:"bar",
                  	   barMaxWidth:26,
                  	   color:'#9ac940',
                  	   itemStyle: {  normal: {   color:'#f13b6e	' }
                  	    	      },
                  	   data:[] ,
                     },
                     ]
	   };
    
    function setOption(tdata) {
    	var data = tdata;
    	console.log(data);
    	var orgName = new Array();
    	var excPercent = new Array();
    	var badPercent = new Array();
    	for (var i = 0; i < data.length; i++) {
    		orgName[i] = data[i].orgName;
    		excPercent[i] = data[i].excellent;
    		badPercent[i] = data[i].bad;
    	}
    	org = orgName;
    	excellent = excPercent;
    	bad = badPercent;
    }
})