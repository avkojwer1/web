<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="description" content="This is my page">
  </head>
  <style type="text/css">
       .oddClass{
           background-color: red;}
       .evenClass{
           background-color:blue;}
  </style>
  <body>
	ognlTag.jsp<br>
	-------------------------------------------------------------------------------------------------------<br>
	property标签用于输出指定值：<br>
	
	<s:property value="#request.username"/><br/>
    <s:property value="#request.username11" default="xxx"/>
    <s:property value="%{'<hr> hr use'}"  escape="false"/>
	-------------------------------------------------------------------------------------------------------<br>
	set标签用于将某个值放入指定范围:<br>
	<s:set value="#request.username" var="xxx"></s:set><br/>
		<s:property value="#xxx"/><br/>
	-------------------------------------------------------------------------------------------------------<br>
	push:将对象放入栈顶,不能放入其他范围,当标签结束,会从栈顶删除。<br>
	
	
	-------------------------------------------------------------------------------------------------------<br>
	Action:通过指定命名空间和action名称,该标签允许在jsp页面直接调用Action <br>
	
	-------------------------------------------------------------------------------------------------------<br>
	Iterator:标签用于对集合进行迭代，这里的集合包含List、Set和数组。<br>
	
	-------------------------------------------------------------------------------------------------------<br>
	if/elseif/else  基本的流程控制.‘If’标签可单独使用也可以和‘Else If’标签和(或)一个多个‘Else’一起使用 <br>
	
	-------------------------------------------------------------------------------------------------------<br>
	url:该标签用于创建url,可以通过"param"标签提供request参数. <br>
	
	-------------------------------------------------------------------------------------------------------<br>
	使用ognl操作list和数组. <br>
	
	ognl也可直接创建集合对象. <br>
	
	使用ognl操作map <br>
	
	-------------------------------------------------------------------------------------------------------<br>
	集合的投影(只输出部分属性) <br>
	
	集合的过滤<br>
	
	集合的投影和过滤<br>
	
  </body>
</html>
