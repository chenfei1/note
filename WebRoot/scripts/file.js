$(function(){
	$("#regist_button").click(function(){
	$("#warning_1").hide();
	$("#warning_2").hide();
	$("#warning_3").hide();
		//获取表单信息
		var name = $("#regist_username").val().trim();
		var nick = $("#nickname").val().trim();
		var password = $("#regist_password").val().trim();
		var final_password = $("#final_password").val().trim();
		var ok=true;
		if(name==""){
		$("#warning_1 span").html("用户名不能为空");
		$("#warning_1").show();
		ok=false;
		}
		if(password==""){
		$("#warning_2 span").html("密码不能为空");
		$("#warning_2").show();
		ok=false;
		}
		if(final_password!=password){
		$("#warning_3 span").html("密码不一致");
		$("#warning_3").show();
		ok=false;
		}
		//发送Ajax请求
		if(ok){
		$.ajax({
			url:"http://localhost:8080/cloud_note/user/regist.do",
			type:"post",
			data:{"name":name,"password":password,"nickname":nick},
			dataType:"json",
			success:function(result){
			alert("---------------------");
				if(result.status==0){
					alert(result.msg);
					$("#back").click();//触发返回按钮的单击
				}else if(result.status==1){//用户名被占用
					$("#warning_1 span").html(result.msg);
					$("#warning_1").show();//显示提示信息
				}
			}
		});
		}
	});
});