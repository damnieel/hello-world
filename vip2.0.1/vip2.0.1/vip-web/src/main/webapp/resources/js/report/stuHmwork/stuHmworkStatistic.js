/** *浏览器兼容(回车事件)** */
document.onkeydown = function(e) {
	var keycode = document.all ? event.keyCode : e.which;
	if (keycode == 13) {
		$("#search").click();
	}
}

var cluster = $(".cluster").val();
var dept = $(".part").val();
var orgId = 1;
if(!isEmpty(cluster) && cluster!=0){
	orgId = Number(cluster);
}
if(!isEmpty(dept) && dept != 0){
	orgId = Number(dept);
}

$(function() {
	$('input[name=time][value=1]').prop("checked",true);
	$("#startDate").attr("disabled","disabled");
	$("#endDate").attr("disabled","disabled");
	$.ajax({
		url : basePath + "statistic/homeworkRpt.htmls",
		data : {
			"orgProCalId" : orgId,
			"timeRangeType" : 1
		},
		success : function(data) {
			console.log(data);
			tdata = eval("(" + data + ")");
			setOption(tdata);
			var myChart = echarts.init(document.getElementById('chart'),
					"macarons");
			options.xAxis[0].data = org;
			options.series[0].data = submitHmwk;
			// 为echarts对象加载数据 
			myChart.setOption(options);
		}
	})
	
	$("#search").click(function(){
		var timeRangeType = $('input[name=time]:checked').val();
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		var cluster = $(".cluster").val();
		var dept = $(".part").val();
		var orgProCalId = 1;
		if(!isEmpty(cluster) && cluster!=0){
			orgProCalId = Number(cluster);
		}
		if(!isEmpty(dept) && dept != 0){
			orgProCalId = Number(dept);
		}
		
		$.ajax({
			url : basePath + "statistic/homeworkRpt.htmls",
			data : {
				"orgProCalId" : orgProCalId,
				"timeRangeType" : timeRangeType,
				"startDate" : startDate,
				"endDate" : endDate
			},
			success : function(data) {
				console.log(data);
				tdata = eval("(" + data + ")");
				setOption(tdata);
				var myChart = echarts.init(document.getElementById('chart'),
						"macarons");
				options.xAxis[0].data = org;
				options.series[0].data = submitHmwk;
				// 为echarts对象加载数据 
				myChart.setOption(options);
			}
		})
	});
	
	$("input[name=time]").click(function(){
		var checkval = $('input[name=time]:checked').val();
		if(checkval == 4){
			$("#startDate").removeAttr("disabled");
			$("#endDate").removeAttr("disabled");
		}else{
			$("#startDate").val("");
			$("#endDate").val("");
			$("#startDate").attr("disabled","disabled");
			$("#endDate").attr("disabled","disabled");
		}
	});

})

// 基于准备好的dom，初始化echarts图表
var org = new Array();
var submitHmwk = new Array();
var xData;
var toolb = {
	show : true,
	orient : 'horizontal', // 布局方式，默认为水平布局，可选为：
	// 'horizontal' ¦ 'vertical'
	x : 1000, // 水平安放位置，默认为全图右对齐，可选为：
	// 'center' ¦ 'left' ¦ 'right'
	// ¦ {number}（x坐标，单位px）
	y : 'top', // 垂直安放位置，默认为全图顶端，可选为：
	// 'top' ¦ 'bottom' ¦ 'center'
	// ¦ {number}（y坐标，单位px）
	color : [ '#1e90ff', '#22bb22', '#4b0082', '#d2691e' ],
	backgroundColor : 'rgba(0,0,0,0)', // 工具箱背景颜色
	borderColor : '#ccc', // 工具箱边框颜色
	borderWidth : 0, // 工具箱边框线宽，单位px，默认为0（无边框）
	padding : 5, // 工具箱内边距，单位px，默认各方向内边距为5，
	showTitle : true,
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
		}/*
			 * , dataView : { show : true, title : '数据视图', readOnly : true, lang : [
			 * '数据视图', '关闭', '刷新' ], optionToContent : function(opt) { var
			 * axisData = opt.xAxis[0].data; var series = opt.series; var table = '<table
			 * style="width:100%;text-align:center"><tbody><tr>' + '<td>部门</td>' + '<td>' +
			 * series[0].name + '</td>' + '</tr>'; for (var i = 0, l =
			 * axisData.length; i < l; i++) { table += '<tr>' + '<td>' +
			 * axisData[i] + '</td>' + '<td>' + series[0].data[i] + '</td>' + '</tr>'; }
			 * table += '</tbody></table>'; return table; } }
			 */,
		magicType : {
			show : false,
			title : {
				line : '动态类型切换-折线图',
				bar : '动态类型切换-柱形图',
				stack : '动态类型切换-堆积',
				tiled : '动态类型切换-平铺'
			},
			type : [ 'line', 'bar', 'stack', 'tiled' ]
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
			lang : [ '点击本地保存' ]
		},
	}
}
var dataZooms = { // 区域缩放
	show : true,
	realtime : true,
	y : 480,
	height : 20,
	start : 0,
	end : 100
}
var color = {
	data : [ '#04b4b3', "#30e0e0" ]
}
var options = { // 工具箱
	tooltip : {
		show : true
	},
	toolbox : toolb,
	dataZoom : dataZooms,
	legend : {
		data : [ '作业提交率(%)' ]
	},
	color : color,
	xAxis : [ {
		type : 'category',
		data : org
	} ],
	yAxis : [ {
		type : 'value',
		name : '作业提交率(%)'

	} ],
	series : [ {
		name : "作业提交率(%)",
		type : "bar",
		barMaxWidth : 35,
		data : [],
		itemStyle : {
			normal : {
				color : '#04b4b3'
			}
		},
	} ]

};
function setOption(tdata) {
	var data = tdata;
	var orgName = new Array();
	var percent = new Array();
	for (var i = 0; i < data.length; i++) {
		orgName[i] = data[i].organizationName;
		percent[i] = Math.round(data[i].percenage.mul(100), 2);
	}
	org = orgName;
	submitHmwk = percent;
}