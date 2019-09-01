<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修配连汽配市场</title>

<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/validator.css"></link>
<script src="${ctx}/js/formValidator.js" type="text/javascript" charset="UTF-8"></script>
<script src="${ctx}/js/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.formValidator.initConfig({formid:"registerForm",onerror:function(msg){},onsuccess:function(){top.jBox.tip("正在注册！",'loading');return true;}});
	
	//用户名
	$("#loginName").formValidator({onshow:"请输入用户名",onfocus:"6-20位字母、数字、下划线组成",oncorrect:"该用户名可以注册"}).inputValidator({min:6,max:20,onerror:"用户名长度不满足要求"}).regexValidator({regexp:"username",datatype:"enum",onerror:"用户名格式不正确"})
	    .ajaxValidator({
	    type : "post",
		url : "${ctx}/login/checkLoginName",
		data:{"loginName" : function(){return $("#loginName").val();}},
		success : function(data){	
            if( data == "1" )
			{
                return true;
			}
            else
			{
                return false;
			}
		},
		buttons: $("#button"),
		error: function(){alert("服务器没有返回数据，可能服务器忙，请重试");},
		onerror : "此用户名已被注册",
		onwait : "正在对用户名进行合法性校验，请稍候..."
	});
	
	//手机号
	$("#telnum").formValidator({onshow:"请输入手机号",onfocus:"输入的手机号必须合法",oncorrect:"该手机号可以注册"}).inputValidator({min:11,max:11,onerror:"手机号码必须是11位的哦"}).regexValidator({regexp:"mobile",datatype:"enum",onerror:"手机号格式不正确"})
	.ajaxValidator({
	type : "post",
	url : "${ctx}/login/checkPhone",
	data:{"telnum" : function(){return $("#telnum").val();}},
	success : function(data){	
	    if( data == "1" )
		{
	        return true;
		}
	    else
		{
	        return false;
		}
	},
	buttons: $("#button"),
	error: function(){alert("服务器没有返回数据，可能服务器忙，请重试");},
	onerror : "此手机号已被注册",
	onwait : "正在对手机号进行合法性校验，请稍候..."
	});
	
	//邮箱
	$("#email").formValidator({onshow:"请输入邮箱",onfocus:"此邮箱用来找回密码",oncorrect:"该邮箱可以注册"}).regexValidator({regexp:"email",datatype:"enum",onerror:"邮箱格式不正确"})
	.ajaxValidator({
	type : "post",
	url : "${ctx}/login/checkEmail",
	data:{"email" : function(){return $("#email").val();}},
	success : function(data){	
	    if( data == "1" )
		{
	        return true;
		}
	    else
		{
	        return false;
		}
	},
	buttons: $("#button"),
	error: function(){alert("服务器没有返回数据，可能服务器忙，请重试");},
	onerror : "此邮箱已被注册",
	onwait : "正在对邮箱进行合法性校验，请稍候..."
	});
	
	$("#password").formValidator({onshow:"请输入密码",onfocus:"密码必须为6位以上哦",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码不能为空,请确认"});
	
	$("#username").formValidator({onshow:"请输入姓名",onfocus:"请输入姓名",oncorrect:"格式正确"}).inputValidator({min:2,onerror:"不能少于2个字符"});
});
</script>
</head>
                <body style="background: rgba(255,255,255,1);">
                <div class="pagebody13 wid" style="width:890px;">
                    <div class="pagebody13_left" style=""><h3>汽配商用户管理</h3></div>
                    <div class="pagebody13_right" style="width:630px">
                        <form action="${ctx}/staff/addStaff" method="post"  id="registerForm">
                            <ul>
                                <h3>新增用户</h3>

                <li><span>用户名:</span><input class="user" type="text" placeholder="用户名" name="loginName" id="loginName">
                	<em>*</em>
                    <i id="loginNameTip" style="font-size:14px;font-style:normal;"></i>
                </li>
                 <li><span>手机号:</span><input class="user" type="text" placeholder="联系电话" name="phone" id="telnum">
	                 <em>*</em>
	                  <i id="telnumTip" style="font-size:14px;width:250px;font-style:normal;"></i>
                 </li>
                <li><span>邮箱:</span><input class="user" type="text" placeholder="邮箱" name="email" id="email">
                	<em>*</em>
                     <i id="emailTip" style="font-size:14px;width:250px;font-style:normal;"></i>
                </li>
                <li><span>密码:</span><input class="user" type="text" placeholder="密码" name="password" id="password">
                	<em>*</em>
                    <i id="passwordTip" style="font-size:14px;width:250px;font-style:normal;"></i>
                </li>
                
                <li><span>员工姓名:</span><input class="user" type="text" placeholder="员工姓名" name="username" id="username">
                	<em>*</em>
                       <i id="usernameTip" style="font-size:14px;width:250px;font-style:normal;"></i>
         		</li>
                

                <li class="beizhu"><span>备注:</span><textarea name='remark' id='textarea' class="user11" placeholder="备注【0在职/1离职】"></textarea></li>
                <li class="beizhu"><span>&nbsp;</span><input type="submit" name="button" id="button" class="user1" value="提交" /></li>
            </ul>
            </form>
        </div>
        <div class="clear"></div>
    </div>
</body>
</html>
