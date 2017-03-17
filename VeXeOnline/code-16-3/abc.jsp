<%@page import="model.bean.Pagination"%>
<%@page import="model.bean.GioXuatPhat"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>abcd</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <html:form action="/chon-xe" method="get">
            <div class="col-lg-4">
                <html:select property="gioXuatPhat" styleClass="form-control">
					<option value="">-- Chọn khoa --</option>
					<html:optionsCollection name="datVeForm" property="listGioXuatPhat" 
						label="gioXuatPhat" value="gioXuatPhat" />
				</html:select>
            </div>
            <div class="col-lg-4">
                <html:select property="diemDonKhach" styleClass="form-control">
					<option value="">-- Chọn diemDonKhach --</option>
					<html:optionsCollection name="datVeForm" property="listDiemDonKhach" 
						label="diemDonKhach" value="diemDonKhach" />
				</html:select>
            </div>
            <div class="col-lg-4">
                <html:select property="diemTraKhach" styleClass="form-control">
					<option value="">-- Chọn diemTraKhach --</option>
					<html:optionsCollection name="datVeForm" property="listDiemTraKhach" 
						label="diemTraKhach" value="diemTraKhach" />
				</html:select>
            </div>
            
            
            
         
            
            
            
            <html:submit styleClass="btn btn-primary">Xem</html:submit>
        </html:form>
    </div>
    
</div>

</body>
</html>