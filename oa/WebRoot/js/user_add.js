var user = {
	initEvent:function(){
		$("input[name='username']").unbind("blur");
		$("input[name='username']").bind("blur", function(){
			user.checkUsername($(this).val());
		});
	},
	checkUsername : function(username){
		var parameter = {
			username: username
		}
		$.post("userJSONAction_checkUsername.action", parameter, function(data){
			if(data == "true"){
				$("#message").text("已经存在");
				$("#message").css("color","red");
			}else{
				$("#message").text("Ok");
				$("#message").css("color","blue");
			}
			
		});
	}
}

$().ready(function(){
	user.initEvent();
});