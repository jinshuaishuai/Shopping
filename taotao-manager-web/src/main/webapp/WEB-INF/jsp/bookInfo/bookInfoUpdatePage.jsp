<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书信息修改页面</title>
<jsp:include page="../../include/commons_base.jsp"></jsp:include>
</head>
<body>
	<form action="" class="layui-form layui-form-pane">
		<input type="hidden" name="id" value="${book.id }" />
		 <div class="layui-form-item">
		    <label class="layui-form-label">书名</label>
		    <div class="layui-input-inline">
		      <input type="text" name="name" class="layui-input" value="${book.name}">
		    </div>
		  </div>
		   <div class="layui-form-item">
		    <label class="layui-form-label">价格</label>
		    <div class="layui-input-inline">
		      <input type="text" name="price" class="layui-input" value="${book.price}">
		    </div>
		  </div>
		   <div class="layui-form-item">
		    <label class="layui-form-label">作者</label>
		    <div class="layui-input-inline">
		      <input type="text" name="author" class="layui-input" value="${book.author}">
		    </div>
		  </div>
		   <div class="layui-form-item">
		 	<button class="layui-btn" lay-filter="bookInfoUpdate" lay-submit="">修改</button>
		  </div>
	</form>
</body>
<script type="text/javascript">
	
	layui.use(['form'],function(){
		var form = layui.form,
		layer = layui.layer;
		form.on('submit()',function(data){
			layer.msg("图书信息修改成功");  

			
			
			return false;
		});
		
		layer.closeAll("iframe");
	});
	
</script>
</html>