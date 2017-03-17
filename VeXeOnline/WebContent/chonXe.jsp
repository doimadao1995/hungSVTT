<%@page import="model.bean.Pagination"%>
<%@page import="model.bean.LichTrinh"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.DiemDonKhach"%>
<%@page import="model.bean.DiemTraKhach"%>
<%@page import="model.bean.GioXuatPhat"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.*"%>
<%

	Random rn = new Random();
	String merRef = "TEST_" + System.currentTimeMillis() + rn.nextInt();
	String ipClient = request.getRemoteAddr();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Chọn xe</title>
  
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="img/icon.ico" rel="shortcut icon" type="image/x-icon" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <html:form action="/thanh-toan" styleClass="form-horizontal" >
        	
            
            <div class="row form-group">
				<div class="col-lg-4">
					<html:hidden property="maLichTrinh" styleClass="form-control" />
					<html:hidden property="diemDi" styleClass="form-control" />
					<html:hidden property="diemDi" styleClass="form-control" />
					<html:hidden property="diemDen" styleClass="form-control" />
					<html:hidden property="ngayDi" styleClass="form-control" />
					<html:hidden property="soLuongVe" styleClass="form-control" />
					<html:hidden property="giaVe" styleClass="form-control" />
					<html:hidden property="giaVeString" styleClass="form-control" />
					<html:hidden property="tongTien" styleClass="form-control" />
					<html:hidden property="tongTienString" styleClass="form-control" />
                </div>
            </div>
            
            <div class="row form-group">
				<label class="col-lg-2">Điểm đi</label>
				<div class="col-lg-4">
					<bean:write name="datVeForm" property="diemDi" />
                </div>
            </div>
             
             <div class="row form-group">
				<label class="col-lg-2">Điểm đến</label>
				<div class="col-lg-4">
					<bean:write name="datVeForm" property="diemDen" />
                </div>
            </div>
             <div class="row form-group">
				<label class="col-lg-2">Ngày đi</label>
				<div class="col-lg-4">
					<bean:write name="datVeForm" property="ngayDi" />
                </div>
            </div>
             <div class="row form-group">
				<label class="col-lg-2">Số lượng vé</label>
				<div class="col-lg-4">
					<bean:write name="datVeForm" property="soLuongVe" />
                </div>
            </div>
            <div class="row form-group">
				<label class="col-lg-2">Giá vé</label>
				<div class="col-lg-4">
					<bean:write name="datVeForm" property="giaVeString" />
                </div>
            </div>
             
            <div class="row form-group">
				<label class="col-lg-2">Chọn giờ đi</label>
				<div class="col-lg-4">
                <html:select property="gioXuatPhat" styleClass="form-control">
					<html:optionsCollection name="datVeForm" property="listGioXuatPhat" 
						label="gioXuatPhat" value="gioXuatPhat" />
				</html:select>
            </div>
			</div>
            
            <div class="row form-group">
				<label class="col-lg-2">Chọn điểm đón khách</label>
				<div class="col-lg-4">
	                <html:select property="diemDonKhach" styleClass="form-control">
						<html:optionsCollection name="datVeForm" property="listDiemDonKhach" 
							label="diemDonKhach" value="diemDonKhach" />
					</html:select>
           		 </div>
			</div>
			
			<div class="row form-group">
				<label class="col-lg-2">Chọn điểm trả khách</label>
				 <div class="col-lg-4">
                <html:select property="diemTraKhach" styleClass="form-control">
					<html:optionsCollection name="datVeForm" property="listDiemTraKhach" 
						label="diemTraKhach" value="diemTraKhach" />
				</html:select>
          	  </div>
			</div>
            <html:submit styleClass="btn btn-primary">Tiếp tục</html:submit>
        </html:form>
    </div>
    
</div>

</body>
</html>