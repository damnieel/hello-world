var tm_dialoag = {
		confirm : function(options){
			var defaults = {
					title:"提示",
				content:"您确定要进行这个操作吗?",
				width:400,
				height:200,
				sureText:"确定",
				canceText:"取消",
				showButton:true,
				callback:function(){}
			};
			
			var opts = $.extend({},defaults,options);
			this._init(opts);
		},
		dialogHtml : function(opts){
			var dialogHtml = "<div id=\"vip_dialog\" class=\"pop_div conserveClick\">"
			    +"<div class=\"conserve_con\">"
			    +   "<div class=\"sure_delet clearfix\">"
			    +          "<i class=\"main_icon\"></i>"
			    +          "<p>"+opts.content+"</p>"
			    +          "<div class=\"pop_btn\">"
			    +		         "<a href=\"javascript:void(0);\" class=\"add_btn bg_blue\">"+opts.sureText+"</a>"
			    +		         "<a href=\"javascript:void(0);\" class=\"add_btn bg_gray marl_20 Quit\">"+opts.canceText+"</a>"
			    +		   "</div>"
			    +"     </div>"
			    +"</div>"
			    +"</div>";
	        return $(dialogHtml);
			
		},
		band_Event : function($dialog,opts){
			$dialog.find(".bg_blue").off().on("click",function(e){
				if(opts.callback) opts.callback(true);
				$dialog.hide();
				$dialog.remove();
			});
			$dialog.find(".Quit").off().on("click",function(e){
				$dialog.hide();
				$dialog.remove();
			});
		},
		_init : function(opts){
			$("#vip_dialog").remove();
			var $dialog = tm_dialoag.dialogHtml(opts);
			tm_dialoag.band_Event($dialog,opts);
			tm_dialoag._showOpen($dialog,opts);
		},
		_showOpen : function($dialog,opts){
			$("body").append($dialog);
			$dialog.fadeIn();
		}
};