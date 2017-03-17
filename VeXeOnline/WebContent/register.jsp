<%@page import="common.StringProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<title>Register Form</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Đăng ký</h3>
		<br>
		<html:form action="/dang-ky" method="post">
			<div class="row form-group">
				<label class="col-lg-2">Tài khoản</label>
				<div class="col-lg-3">
					<html:text property="maAccount" styleClass="form-control" ></html:text>
					
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Mật khẩu</label>
				<div class="col-lg-3">
					<html:password property="matKhau" styleClass="form-control"></html:password>
			
				</div>
			</div>
			
			<div class="row form-group">
				<label class="col-lg-2">Họ Tên</label>
				<div class="col-lg-3">
					<html:text property="hoTen" styleClass="form-control" ></html:text>
				
				</div>
			</div>
			
			<div class="row form-group">
				<label class="col-lg-2">Email</label>
				<div class="col-lg-3">
					<html:text property="email" styleClass="form-control" ></html:text>
			
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Số điện thoại</label>
				<div class="col-lg-3">
					<html:text property="soDienThoai" styleClass="form-control" ></html:text>
				
				</div>
			</div>
			
			<div class="row form-group">
				<label class="col-lg-2">Địa chỉ</label>
				<div class="col-lg-3">
					<html:text property="diaChi" styleClass="form-control" ></html:text>
				
				</div>
			</div>
			
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary">Đăng ký</html:submit>
					<button class="btn btn-primary" type="reset">Hủy</button>
				</div>
			</div>
		</html:form>
	</div>
</body>
</html>