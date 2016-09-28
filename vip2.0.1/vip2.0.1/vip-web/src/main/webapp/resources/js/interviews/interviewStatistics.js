/** *浏览器兼容(回车事件)** */
document.onkeydown = function(e) {
	var keycode = document.all ? event.keyCode : e.which;
	if (keycode == 13) {
		$("#search").click();
	}
}

var endDate,startDate,orgId = 1;
$(function(){
	showEchart();   
	$("#search").on("click",function(){
	  var dom = $("#element_id>select:visible:last");
	  var orgProCalId = (dom.val() == 0)?dom.prev("select").val():dom.val();
	  orgId = !isNaN(orgProCalId)?orgProCalId :1;
	  startDate = $("#startDate").val();
	  endDate = $("#endDate").val();
	  if((isEmpty($("#startDate").val())!=isEmpty($("#endDate").val()))){
		  tmLoading("请设置正确的时间段",1);
		  return false;
	  }
	showEchart();
	})
	
});

function showEchart(){
	$.ajax({
		url: basePath + "interview/ivStatisticsData.htmls",
		data: {
			   "orgProCalId":orgId,
			   "startDate":startDate,
			   "endDate":endDate,
			   },
		success : function(data) {
			 if(''==data||null==data){
				 $("#organization").text("");
				 $("#totalPeople").text("");
				 $("#totalInterview").text("");
				 tmLoading("暂无访谈统计数据", 3);
				 return ;
			 }
			 data=eval("("+data+")");
			 var c=data.componentVO;
			 var l=data.learningAimVO;
			 var lArray=new Array(l.makingMoney,l.workNeed,l.carveOut,l.interesting,l.other);
			 var cArray=new Array({value:c.worker,name:'工作人士'},{value:c.unemployee,name:'待业人士'},{value:c.student,name:'学生'},{value:c.other,name:'其他'});
			 optionPie.series[0].data=cArray;
			 optionBar.series[0].data=lArray;
			 /*
			 console.log(cArray);
			 console.log(lArray);
			 console.log(l.learningRecord);
			 console.log(c.componentRecord);*/
			 
			 $("#organization").text(l.orgName);
			 $("#totalPeople").text(c.componentRecord);
			 $("#totalInterview").text(l.learningRecord);
			 if(l.orgName==null||l.orgName=='null'){
				 $("#organization").text('');
			 }
			// 为echarts对象加载数据 
			 myPie.setOption(optionPie); 
			 myBar.setOption(optionBar);
		}
	}) 
	// 基于准备好的dom，初始化echarts图表
    var myPie = echarts.init(document.getElementById('pieChart')); 
    var myBar = echarts.init(document.getElementById('barChart')); 
    var optionPie = {
    	    tooltip : {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    },  
    	    color : ['#f13b6e','#ffbb43','#9ACA40','#24bbea'],
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            
    	            dataView : {show: true, readOnly: false},
    	            magicType : {
    	                show: true, 
    	                type: ['pie', 'funnel'],
    	                option: {
    	                    funnel: {
    	                        x: '25%',
    	                        width: '50%',
    	                        funnelAlign: 'left',
    	                        max: 1548
    	                    }
    	                }
    	            },
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    series : [
    	        {
    	            name: '访谈人数',
    	            type: 'pie',
    	            radius : '55%',
    	            center: ['50%', '60%'],
    	            data:[],
    	            itemStyle: {
    	            	normal: {
    	                    label: {
    	                        show: true,
    	                    },
    	                    labelLine: {
    	                        show: true
    	                    }
    	                } ,
    	                emphasis: {
    	                    shadowBlur: 10,
    	                    shadowOffsetX: 0,
    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	                }
    	            }
    	        }
    	    ]
    	};

    var optionBar = {
            tooltip: {
                show: true
            },
            /*legend: {
                data:['访谈次数']
        		
            },*/
            xAxis : [
                {
                    type : 'category',
                    data : ["挣钱","工作需要","创业","对课程感兴趣","其他"],
                    
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:"访谈次数",
                    type:"bar",
                    barWidth: 27,
                    "itemStyle":{
                    	normal:{
                    		color:['#04b4b3'] /*function (params) {
                                var colorList = ['#f13b6e','#ffbb43','#9ACA40','#24bbea', '#27727B'];
                                return colorList[params.dataIndex]
                            },*/
                    	}
                    },
                    "data":[]
                }
            ]
        };
}