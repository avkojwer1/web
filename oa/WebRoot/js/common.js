

$().ready(function(){
//	$("a").each(function(){ 
//		if($(this).text() == "删除"){
//			$(this).unbind("click");
//			$(this).bind("click",function(){
//				return $(this).confirm("您确认要删除吗?");
//			});
//		}
//
//	});
	$.confirm("您确认是否要删除吗?");
})
