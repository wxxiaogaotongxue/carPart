<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<%@ include file="/pages/commons/head.jsp" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修配连汽配市场</title>
<link href="${ctx}/static/parts/css/index.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/parts/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript"> 
function subData(){
 var zone1=$("#zone1").val();
var zone2=$("#zone2").val();
var tel1=$("#tel1").val();
var tel2=$("#tel2").val();

var cellphone=$("#cellphone").val();
var qq=$("#qq").val();
var header=$("#header").val();
var zoneTel1=$("#zone1").val()+"-"+$("#tel1").val();
var zoneTel2=$("#zone2").val()+"-"+$("#tel2").val();
if(!checkTel()){
	alert("固定电话必须符合格式(区号+座机号)");
	return;
}
if(qq==null || $.trim(qq)==''){
	alert("qq不能为空！");
	return ;
}
if(header==null || $.trim(header)==''){
	alert("负责人不能为空！");
	return ;
}
if(zone1==""&&tel1==""){
	zoneTel1="";
}
if(zone2==""&&tel2==""){
	zoneTel2="";
} 
$.ajax({
    url:"${ctx}/salebusinessAction.do?method=editBusiness",    //请求的url地址
    async:true,//请求是否异步，默认为异步，这也是ajax重要特性
    data:{"tel1":zoneTel1,"tel2":zoneTel2,"cellphone":cellphone,"qq":qq,"header":header,},    //参数值
    type:"post",   //请求方式
    success:function(data){
    		jBox.tip("修改成功！",'success',{timeout:1000});
    	   window.location.reload();
    },
});

} 


function cancelData(){
window.location.reload();
}



	function  addPic(obj) {
		$.jBox("iframe:${ctx}/salebusinessAction.do?method=addPic&picNum="+obj, {
			title : "",
			width : 500,
			height : 300,
			buttons : { /*'关闭': true*/}
		});
	} 
    

    function  updatePic(obj) {
    		$.jBox("iframe:${ctx}/salebusinessAction.do?method=updatePic&picNum="+obj, {
    			title : "",
    			width : 500,
    			height : 300,
    			buttons : { /*'关闭': true*/}
    		});
    	} 
    
    function updateMemo(){
    var memo=$("#memo").val();
    $.ajax({
    url:"${ctx}/salebusinessAction.do?method=updateMemo",    //请求的url地址
    async:true,//请求是否异步，默认为异步，这也是ajax重要特性
    data:{"memo":memo,},    //参数值
    type:"post",   //请求方式
    success:function(data){
    	   window.location.reload();
    },
});
    }
    
    
    function checkTel(){
    	var isZone=/^0\d{2,3}$/;
        var isPhone = /^\d{7,8}$/;
        var tel1=document.getElementById("tel1").value.trim();
        var tel2=document.getElementById("tel2").value.trim();
        var zone1=document.getElementById("zone1").value.trim();
        var zone2=document.getElementById("zone2").value.trim();
        if(tel1==""&&tel2==""&&zone1==""&&zone2==""){
        	return true;
        } else{
    	    if(isZone.test(zone1)&&isPhone.test(tel1)){
    	    	if((tel2==""&&zone2=="")||(isZone.test(zone2)&&isPhone.test(tel2))){
    	        return true;
    	    	}else{
    	    		return false;
    	    	}
    	    }
    	    else{
    	    	  if(isZone.test(zone2)&&isPhone.test(tel2)){
    	  	    	if((tel1==""&&zone1=="")||(isZone.test(zone1)&&isPhone.test(tel1))){
    	  	        	return true;
    	  	    	}else{
    	  	    		return false;
    	  	    	}
    	  	    }
    	  	    else{
    	  	        return false;
    	  	    }
    	    }
    	    }
        }
</script>

</head>
<body>
    <div class="bg_color1 fix"><!--main颜色-->
            <div class="pagebody1">
                <div class="wid">
                    <div class="box-yhglzx box-yhglzx2">                                                                    
                        <div class="box-staman">
                            <div class="tit-z"><strong>企业基本信息管理</strong></div>
                            <dl class="m1">
                                <dt>
                                    <table class="table-z2" width="100%">
                                        <tr>
                                                <td width="247"><strong>企业代码：</strong><span>${salebusiness.companycode}</span></td>
                                        </tr>
                                    </table>
                                </dt>
                               
                            </dl>
                            <dl class="m1">
                                <dt>
                                    <table class="table-z2" width="100%">
                                        <tr>
                                            <td width="247"><strong>企业名称：</strong><span>${salebusiness.companyname}</span></td>
                                            <td><strong>企业地址：</strong><span>${salebusiness.address}</span></td>
                                        </tr>
                                    </table>
                                </dt>
                                <dd>
                                    <table class="table-z1">
                                        <tr>
                                            <td width="247"><span>固定电话1：</span><input type="text" name="zone1" id="zone1" class="txt txt2 "  value="${zone1}" style="width:30px"/> <input type="text" name="tel1" id="tel1" class="txt txt2 "  value="${tel1}" style="width:70px"/></td>
                                            <td width="247"><span>固定电话2：</span><input type="text" name="zone2" id="zone2" class="txt txt2 "  value="${zone2}" style="width:30px"/> <input type="text" name="tel2" id="tel2" class="txt txt2 "  value="${tel2}" style="width:70px"/></td>
                                            <td width="213"><span>手机号：</span><input type="text" name="cellphone" id="cellphone" class="txt txt2" value="${salebusiness.cellphone}" /></td>
                                            <td><span> QQ：</span><input type="text" name="qq" id="qq" class="txt txt2" value="${salebusiness.qq}" /></td>
                                        </tr>
                                        <tr>
                                            <td width="247"><span>联系人：</span><input type="text" name="header" id="header" class="txt txt2" value="${salebusiness.thehead}" /></td>
                                            
                                        </tr>
                                        
                                    </table>
                                </dd>
                            </dl>
                            <dl class="m1">
                                <dt>
                                    <table class="table-z2" width="100%">
                                    <c:if test="${salebusiness.themain eq 'A' }">
                                        <tr>
                                        
                                            <td width="247"><strong>主营：</strong><span>${salebusiness.thefrainchise}</span></td>
                                            <td width="294"><strong>兼营1：</strong><span>${salebusiness.sideline}</span></td>
                                            <td><strong>兼营2：</strong><span>${salebusiness.other}</span></td>
                                            <td >（<span style="color:red">*</span>如您需要变更经营范围，请联系客服）</td>
                                        </tr>
                                        </c:if>
                                        
                                                                           
                                                                          
                                       <c:if test="${salebusiness.themain eq 'B' }">
                                        <tr>
                                        
                                               
                                            <td width="247"><strong>专营：</strong><span>${salebusiness.thefrainchise}</span></td>
                                            <td >（<span style="color:red">*</span>如您需要变更经营范围，请联系客服）</td>
                                            
                                        </tr>
                                        </c:if>
                                        
                                     <c:if test="${salebusiness.themain eq 'C' }">
                                        <tr>
                                        
                                               
                                            <td width="300"><strong>单项配件：</strong><span>${salebusiness.thefrainchise}</span></td>
                                            
                                            <td >（<span style="color:red">*</span>如您需要变更经营范围，请联系客服）</td>
                                        </tr>
                                        </c:if>
                                        
                                               <c:if test="${salebusiness.themain eq 'D' }">
                                        <tr>
                                        
                                               
                                            <td width="300"><strong>精品种类：</strong><span>${salebusiness.thefrainchise}</span></td>
                                            
                                            <td >（<span style="color:red">*</span>如您需要变更经营范围，请联系客服）</td>
                                        </tr>
                                        </c:if>
                                    </table>
                                </dt>
                            </dl>
                            <div class="btn1">
                            	<a href="javascript:;" onclick="subData()">提交</a>
                                <a href="javascript:;" onclick="cancelData()">取消</a>
                            </div>
                            </div>
                            </div>
                            <div class="box-yhglzx box-yhglzx2" style="position:relative;">
                            <div class="box-extpub">
                                <div class="tit-z"><strong>企业对外宣传信息管理</strong></div>
                                <ul class="ul-img-z">
                                    <li>
                                        <div class="img" >
                                        <a href="javascript:void(0)"  onclick="<c:if test="${empty salebusiness.picurl1}">addPic(1)</c:if><c:if test="${not empty salebusiness.picurl1}">updatePic(1)</c:if>"><img src="${ctx}${salebusiness.picurl1}" alt="" /></a>
                                        
                                        </div>
                                        <div class="txt">
                                                <p><a href="">此图片将默认为企业头像</a></p>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="img" >
                                       
                                                <a href="javascript:void(0)" onclick="<c:if test="${empty salebusiness.picurl2}">addPic(2)</c:if><c:if test="${not empty salebusiness.picurl2}">updatePic(2)</c:if>"><img src="${ctx}${salebusiness.picurl2}" alt="" /></a>
                                                
                                        </div>
                                        <div class="txt">
                                                <p><a href=""></a></p>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="img" >
                                                <a href="javascript:void(0)"onclick="<c:if test="${empty salebusiness.picurl3}">addPic(3)</c:if><c:if test="${not empty salebusiness.picurl3}">updatePic(3)</c:if>"><img src="${ctx}${salebusiness.picurl3}" alt="" /></a>
                                        </div>
                                        <div class="txt">
                                                <p><a href=""></a></p>
                                        </div>
                                    </li>
                                </ul>
                                <textarea name="" class="text" id="memo" cols="30" rows="10">${salebusiness.memo}</textarea>
                                <div class="btn">
                                    <a href="javascript:void(0)" onclick="updateMemo()">保存修改</a>
                                </div>
                                <div class="phone">
                                <textarea name="" class="tt1"  id=""   readonly="readonly" >${salebusiness.memo}</textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--中间内容-->
            </div>
            
     </div><!--main颜色-->
     <div class="bg_color2"><!--end底部-->
        <div class="footer wid">Copyright © 2014-2024 www.xiupeilian.com  All Rights Reserved. 修配连 版权所有</div>
     </div><!--end底部-->

</body>
</html>