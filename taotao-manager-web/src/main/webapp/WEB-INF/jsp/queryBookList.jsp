<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书查询</title>
<jsp:include page="../include/commons_base.jsp"></jsp:include>
</head>
<body>
	<div class="layui-field-box">
		<form action="" method="post" name="form1" id="form1" class="layui-form">
			 <div class="layui-form-item">
			    <div class="layui-inline">
			      <label class="layui-form-label">按书号查询</label>
			      <div class="layui-input-inline">
			        <input type="text" name="bookId" autocomplete="off" class="layui-input">
			      </div>
			    </div>
			    <div class="layui-inline">
			      <label class="layui-form-label">按书名查询</label>
			      <div class="layui-input-inline">
			        <input type="text" name="bookName" autocomplete="off" class="layui-input">
			      </div>
			    </div>
			  </div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="bookInfoQuery">查询</button>
					<button class="layui-btn layui-btn-normal layui-btn-radius" type="reset">重置</button>
				</div>
			</div>
		</form>
	</div>
	
	<!-- 定义一个数据表格 -->
	<table lay-filter="bookTableFilter" id="bookTable" class="layui-hide"></table>
</body>
<script type="text/html" id="dataOperatorBar">
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="dataUpdate">修改</a>
</script>
<script type="text/javascript">
	layui.use(['form','table','element'],function(){
		var form = layui.form,
		table = layui.table;		
		form.on('submit(bookInfoQuery)',function(data){
			
			table.render({
				elem:	'#bookTable',
				method:	'post',
				where:	data.field,
				page:	true,
				even:	true,
				url:contextPath+"/queryBookList.json",
				cols:[[

					     {
					    	 field:'id',align: 'center',title: '图书编号'
					     },
					     {
					    	 field:'name',align: 'center',title: '书名'
					     },
					     {
					    	 field:'price',align: 'center',title: '价格'
					     },
					     {
					    	 field:'author',align: 'center',title: '作者'
					     },
					     {
					    	 title:'操作',align:'center',fixed:'right',toolbar:'#dataOperatorBar'
					     }
					     ]]
			});
			return false;
		});
		table.on('tool(bookTableFilter)',function(obj){
			var data = obj.data;
			openShowUpdateBookInfoPage(data);
		});   
		function openShowUpdateBookInfoPage(data){
			var bookName = data.name;
			var id = data.id;
			var price = data.price;
			var author = data.author;
			layer.open({
				id : 'bookInfoUpdate', // 唯一ID，防止重复生成
				type : 1, // 页面类型
				title : '图书信息修改', // 标题
				area: ['500px', '300px'],
				content:
					"<input type='hidden' name='id' value="+id+"type='text' />"
				+ "<br/><br/>书名:<input type='text' name='name' id ='bookName' value= "+bookName+" />"
				+ "<br/><br/>单价:<input type='text' name='price' id='price' value="+price+" />"
				+ "<br/><br/>作者:<input type='text' name='author' id='author' value= "+author+" />"
				+ "<br/><br/><input type='button' value='修改' onclick='bookInfoUpdate("+id+")' />"
			});
		};	
	});
	function bookInfoUpdate(bookId){
		var bookName = $("#bookName").val();
		var price = $("#price").val();
		var author = $("#author").val();
		console.log("bookInfoUpdate方法中获得的表单数据为:------------>{}",bookId,bookName,price,author);
		$.ajax({
			type:"post",
			url:contextPath + "/bookInfoUpdateById",
			dataType:'json',
			data:{
				"id":bookId,
				"name":bookName,
				"price":price,
				"author":author
			},
			success:function(data){
				console.log("处理Ajax数据返回的值为：-------------->",data);
				var updateStatus = data.data;
				if(updateStatus != '' || updateStatus != null){
					layer.msg("修改成功");
				}else{
					layer.msg("修改失败");
				}
			}
		});
		layer.closeAll();
	}
</script>
</html>