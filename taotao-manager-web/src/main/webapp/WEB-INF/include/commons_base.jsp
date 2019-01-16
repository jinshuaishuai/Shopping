<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 引入指定的指令 -->
<%@ include file="commons_base_taglib.jsp"%>

<!-- 引入指定的头 -->
<%@ include file="commons_base_header.jsp"%>
<!-- 引入单独的jquery组件, layui默认也集成了jquery，具体使用参见官方文档 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.8.3.min.js"></script>
 <!-- 使用layui -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all">
<script src="${pageContext.request.contextPath }/layui/layui.js"></script>
<style>
.input_line_text{
    background-color: transparent;
    border-color:#000000;
    border-style:solid;
    border-top-width:0px;
    border-right-width:0px;
    border-bottom-width:1px;
    border-left-width:0px;
    text-align:center;
    width:50px;
};
</style>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
