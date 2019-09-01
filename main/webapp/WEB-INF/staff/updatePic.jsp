<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<%@ include file="/pages/commons/head.jsp" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="${ctx}/static/parts/css/index.css" rel="stylesheet" type="text/css" />
</head>

<body style="background:#efeeec;">
<div class="pagebody6">
        <h3 class="padding1">上传图片</h3>
          <form  method="post" enctype="multipart/form-data" action="${ctx}/enterpriseImgUpload">
       		<input type="hidden" name="picNum" value="${picNum}"/>
        <div class="margin1 padding1" ><span style="font-size:16px;margin-right:10px;">图片路径</span><input type="file" name="file" id="textfield"  /></div>
        <input type="submit" class="tianjia" name="button2" id="button2" value="确认修改" />
        </form>
    </div>
</body>
</html>
