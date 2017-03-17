<%@page import="model.bean.Pagination"%>
<%@page import="common.StringProcess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.LichTrinh"%>
<%@page import="model.bean.GiaVe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Danh sách lịch trình</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <html:form action="/ds-lich-trinh" method="get">
            <div class="col-lg-6 pull-right">
            	<div class="col-lg-3">
            	<html:link styleClass="btn btn-primary" action="/them-lich-trinh">Thêm mới</html:link>
            	</div>
            	 <div class="col-lg-6">
            	 
                	<html:text property="tuKhoa" styleClass="form-control"></html:text>
                	
           		</div>
            	<html:submit styleClass="btn btn-primary">Tìm kiếm</html:submit>
            </div>
        </html:form>
    </div>
    <br>
    
    <div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Mã Lịch Trình</th>
                <th>Điểm Đi</th>
                <th>Điểm Đến</th>
                <th>Giá Vé</th>
                <th>Thời Gian Chạy</th>
                <th>Quãng Đường</th>
                <th>Tình Trạng</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="lichTrinhForm" property="listLichTrinh" id="lt">
            	<tr>
                <th scope="row">
                	<bean:write name="lt" property="maLichTrinh"/>
				</th>
                <td>
                	<bean:write name="lt" property="diemDi"/>
                </td>
                <td>
                	<bean:write name="lt" property="diemDen"/>
				</td>
                <td>
                	<bean:write name="lt" property="maGiaVe"/>
                </td>
                <td>
                	<bean:write name="lt" property="thoiGianChay"/>
                </td>
                <td>
                	<bean:write name="lt" property="quangDuong"/>
                </td>
                <td>
                	<bean:write name="lt" property="tinhTrang"/>
                </td>
                <td>
                	<bean:define id="maLichTrinh" name="lt" property="maLichTrinh"></bean:define>
                	<html:link action="/sua-lich-trinh?maLichTrinh=${maLichTrinh}">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                	<html:link action="/xoa-lich-trinh?maLichTrinh=${maLichTrinh}" style="margin-left: 30px;">
                		<span class="glyphicon glyphicon-trash"></span>
                	</html:link>
                </td>
            </tr>
            </logic:iterate>
            </tbody>
        </table>
    </div>
    

     
</div>
</body>
</html>