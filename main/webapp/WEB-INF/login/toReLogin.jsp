<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修配连汽配市场</title>
    <link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/js/jquery.min.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/js/validator/formValidator.js" type="text/javascript" charset="UTF-8"></script>
    <script src="${ctx}/js/validator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="password_d"><!--main颜色-->
    <div class="dang">当前位置：找回密码</div>
    <div class="password_f">
        <dl><dt><span style="color:red"> <input id="telnum" type="text" autocomplete="off" placeholder="请输入已绑定的手机号"/></dd><dd>输入您的手机号</dd></dl>
        <i id="telnumTip" style="font-size:14px;width:250px;font-style:normal;"></i>
        <dl><dt><span style="color:red"><input id="code1" type="text" autocomplete="off" placeholder="短信验证码"/></dt></dl>
        <dl style="border:0;"><dt>&nbsp;</dt><dd><input id="btnSendCode1" type="button" class="btn btn-default" value="获取验证码" onClick="sendMessage1()" /></dd></dl>
        <p id="tips"
           style="margin-left:100px;margin-top:60px;color:red;font-size:16px"></p>
        <button onclick="binding()">确定</button>
    </div>
</div>

<script>
    var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;//手机号正则
    var count = 60; //间隔函数，1秒执行
    var InterValObj1; //timer变量，控制时间
    var curCount1;//当前剩余秒数
    /*第一*/
    function sendMessage1() {
        curCount1 = count;
        var phone = $.trim($('#telnum').val());
        if (!phoneReg.test(phone)) {
            alert(" 请输入有效的手机号码");
            return false;
        }
        //设置button效果，开始计时
        $("#btnSendCode1").attr("disabled", "true");
        $("#btnSendCode1").val( + curCount1 + "秒再获取");
        InterValObj1 = window.setInterval(SetRemainTime1, 1000); //启动计时器，1秒执行一次
        //向后台发起请求
        $.ajax({
            type : "post",
            url : "${ctx}/login/smsControllter",
            data : {
                'phone' : phone

            },
            success : function(data) {
                sendMessage1

            }

        });

    }
    function SetRemainTime1() {
        if (curCount1 == 0) {
            window.clearInterval(InterValObj1);//停止计时器
            $("#btnSendCode1").removeAttr("disabled");//启用按钮
            $("#btnSendCode1").val("重新发送");
        }
        else {
            curCount1--;
            $("#btnSendCode1").val( + curCount1 + "秒再获取");
        }
    }

    /*提交*/
    function binding(){
        var code1 = $.trim($('#code1').val());
        var telnum = $.trim($('#telnum').val());
        $.ajax({
            type : "post",
            url : "${ctx}/login/smsQuery",
            data : {
                'code' : code1,
                'phone':telnum

            },
            success : function(data) {
                if(data=='1'){
                    $("#tips").html("验证码已过期，请重新获取");
                }else if(data=='2'){
                    $("#tips").html("正确，您的新密码为123456");
                }else if(data=='3'){
                    $("#tips").html("验证码错误");
                }else{
                    $("#tips").html("正确，您的新密码为123456");
                }


            }

        });
    }
</script>
<script type="text/javascript">
    $(function(){
//手机号
        $("#telnum").formValidator({onshow:"请输入手机号",onfocus:"输入的手机号必须合法",oncorrect:"该手机号不存在"}).inputValidator({min:11,max:11,onerror:"手机号码必须是11位的哦"}).regexValidator({regexp:"mobile",datatype:"enum",onerror:"手机号格式不正确"})
            .ajaxValidator({
                type : "post",
                url : "${ctx}/login/checkPhoneUser",
                data:{"telnum" : function(){return $("#telnum").val();}},
                success : function(data){
                    if( data == "1" )
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }

                },
                buttons: $("#button"),
                error: function(){alert("服务器没有返回数据，可能服务器忙，请重试");},
                alert : "手机号不正确",
                alert : "正在对手机号进行合法性校验，请稍候..."
            });
    });

</script>






</div><!--main颜色-->
</body>
</html>
