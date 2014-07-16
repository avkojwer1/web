(function(jQuery){
//	$.fn.confirm = function(message){
//		window.confirm(message);
//		
//	}
	//全局对象
	$.confirm = function(message){
		$("a").each(function(){
			if($(this).text() == "删除"){
				$(this).unbind("click");
				$(this).bind("click", function(){
					return window.confirm(message);
				});
			}
		});
	}
})(jQuery);
