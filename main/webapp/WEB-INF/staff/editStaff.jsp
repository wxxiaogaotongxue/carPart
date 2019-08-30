<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修配连汽配市场</title>
<link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body style="background: rgba(255,255,255,1);">
<div class="wid mar5">
	<div class="pagebody"><h3>汽配商用户管理</h3></div>
    <div class="pagebody12">
   	    <h>编辑用户内容</h>
        <form action="${ctx}/staff/editStaff" method="post" >
        <ul>
            <table width="90" class="fl pagebody12_left">
              <tr class="border_end">
                <td width="90" height="50" align="left" valign="middle">企业编号</td>
              </tr>
              <tr class="border_end">
                <td width="90" height="50" align="left" valign="middle">汽配商名称</td>
              </tr>
              <tr class="border_end">
                <td width="90" height="50" align="left" valign="middle">地址</td>
              </tr>
              <tr class="border_end">
                <td width="90" height="50" align="left" valign="middle">省</td>
              </tr>
              <tr class="border_end">
                <td width="90" height="50" align="left" valign="middle">市</td>
              </tr>
              <tr>
                <td width="90" height="50" align="left" valign="middle">区/县</td>
              </tr>
              <tr>
                <td width="90" height="50" align="left" valign="middle">手机号</td>
              </tr>

               <tr>
                <td width="90" height="50" align="left" valign="middle">负责人</td>
              </tr> 
              <c:if test="${user.manageLevel==2}">
              <tr>
                <td width="90" height="50" align="left" valign="middle">状态</td>
              </tr>
              </c:if>
              <tr>
                <td width="90" height="50" align="left" valign="middle">&nbsp;</td>
              </tr>
            </table>
            <table width="290" class="fl pagebody12_right">
              <tr class="border_end">
                <td width="290" height="50">${company.id}</td>
              </tr>
              <tr class="border_end">
                <td width="290" height="50">${company.companyName}</td>
              </tr>
              <tr class="border_end">
                <td width="290" height="50">${company.address}</td>
              </tr>
              <tr class="border_end">
                <td width="290" height="50">${province}</td>
              </tr>
              <tr class="border_end">
                <td width="290" height="50">${city}</td>
              </tr>
              <tr>
                <td width="290" height="50">${county} </td>
              </tr>
              <tr>
                <td width="290" height="50">
                <input type="hidden" name="id" id="id"  value="${id}"/>
                <input type="text" name="phone" id="sj" class="text" value="${user.phone}" /></td>
              </tr>
                <input type="hidden" name="id" value="userid">
              <tr>
                <td width="290" height="50">
                <input type="text" name="leader" id="textfield3" class="text" value="${user.leader}" /></td>
              </tr>

              <tr>
              
              <c:if test="${user.remark==0}">
                <td width="290" height="50">
                    <li>在职<input type="radio" name="remark" id="radio" value="0"  checked/><label for="radio"></label></li>
                    <li>离职<input type="radio" name="remark" id="radio1" value="1" /><label for="radio"></label></li>
                </td>
                </c:if>
                    <c:if test="${user.remark==1}">
                <td width="290" height="50">
                    <li>在职<input type="radio" name="remark" id="radio" value="0"  checked/><label for="radio"></label></li>
                    <li>离职<input type="radio" name="remark" id="radio1" value="1" /><label for="radio"></label></li>
                </td>
                </c:if>
              </tr>

              <tr>
                <td width="290" height="50"><input class="baocun" type="submit" name="button" id="button" value="保&nbsp;&nbsp;存" /></td>
              </tr>
            </table>
			<div class="clear"></div>
        </ul>
        </form>
    </div>
    <div class="clear"></div>
</div>
<script type="text/javascript" src="js/jquery.js"></script>

</body>
</html>

