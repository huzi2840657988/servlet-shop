//跳转修改页面
$("#update").bind("click",function(){
	var userId=$("#userId").val();
	window.location="user.do?method=toUpdate&userId="+userId;
});
//删除
$("#del").bind("click",function(){
		if(confirm("确认删除？")){
			window.location="user.do?method=del&userId="+userId;
		}
});
//重置密码
$("#repassword").bind("click",function(){
	var userId=$("#userId").val();
	if(confirm("确认重置密码？")){
		$.get("user.do", {method:"rePassword",userId:userId}, function(data){
				alert(data);
		},"text");
	}
});
