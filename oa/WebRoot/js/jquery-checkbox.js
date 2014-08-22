(function(jQuery){
	$.fn.controlCheckBox = function(checkname){
		/**
		 * 判断全选按钮的选中状态
		 */
		if($(this).is(':checked')){
			$("input[name='"+checkname+"']").attr("checked",true);
		}else{
			$("input[name='"+checkname+"']").attr("checked",false);
		}
	}
})(jQuery);
