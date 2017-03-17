<%@page import="common.StringProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<title>Admin</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<html:form action="/ds-lich-trinh" method="post">
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary">Lich trinh</html:submit>
					<button class="btn btn-primary" type="reset">Hủy</button>
				</div>
			</div>
		</html:form>
	</div>
	
	<div class="container">
		<html:form action="/ds-ve-xe" method="post">
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary">ve xe</html:submit>
					<button class="btn btn-primary" type="reset">Hủy</button>
				</div>
			</div>
		</html:form>
	</div>
	
	<div class="container">
		<html:form action="/ds-du-lieu-xe" method="post">
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary">du lieu xe</html:submit>
					<button class="btn btn-primary" type="reset">Hủy</button>
				</div>
			</div>
		</html:form>
	</div>
	
</body>
</html>