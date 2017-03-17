<%@page import="model.bean.Pagination"%>
<%@page import="common.StringProcess"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <title>Quản lý vé xe</title>
  <script type="text/javascript">
         <!--
            function OK() {
               <!--
            
               var retVal = confirm("Bạn có muốn xóa đơn hàng này không ?");
               if( retVal == true ){
                  alert("Bạn đã xóa thành công");
                  return true;
               }
               else{
                  
                  return false;
               }
            }
         
        
         //
         
         
       $(function() {
              $("#searchVeXe").attr("placeholder", "Bạn cần tìm gì?");
       });
       -->
   </script>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
        </button>
        <a class="navbar-brand" href="#myPage"><span class="glyphicon glyphicon-home"></span></a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li class="active"><a href="qlvexe.html">Quản lý vé xe</a></li>
          <li><a href="lichtrinh.html">Quản lý lịch trình</a></li>
          <li><a href="giave.html">Quản lý giá vé </a></li>
		  <li><a href="dontra.html">Quản lý điểm đón-trả khách </a></li>
          <li><a href="quanlyaccount.html">Quản lý account</a></li>
          <li><a href="qltintuc.html">Quản lý tin tức</a></li>
          <li><a href="ThongKe.html">Thống kê</a></li>
          <li>
            <a href="#" style="color:#ffffff;font-weight: bold;">
              <span class="glyphicon glyphicon-log-out"></span> Logout
            </a>
          </li>
        </ul>
        


      </div>
    </div>
</nav>

  <div class="container">
  
  
  <div style="margin-top: 70px;">
  		<html:form action="/xoa-ve-xe" method="post" styleClass="form-inline">
		    <div class="form-group col-xs-5">
		    	<html:submit styleClass="btn btn-danger" property="submit">Thêm dữ liệu xe</html:submit>
		    </div>
	    </html:form>
	    <html:form action="/ds-ve-xe" method="post" styleClass="form-inline">
		    <div class="form-group">
		      <html:text property="tuKhoa" styleClass="form-control" styleId="searchVeXe"></html:text>
		    </div>
		      <div class="form-group" style="padding-left: 25px;">
		      <html:submit styleClass="btn btn-primary">Tìm kiếm</html:submit>
		    </div>
	  	</html:form>

   </div>
   
   <div class="table-responsive" style="margin-top: 25px;">  
     <table class="table" >
      <thead>
        <tr>
        <th>ID</th>
		<th>Mã lịch xe</th>
        <th>Tuyến đường</th>
        <th>Mã xe</th>
		<th>Ngày đi</th>
		<th>Giờ xuất phát</th>
		<th>Số chỗ còn lại</th>
		<th>Chức năng</th>
     	 </tr>
      </thead>
      <tbody>
            <logic:iterate name="duLieuXeForm" property="listDuLieuXe" id="dlx">
            <tr class="success">
            
            	 <td><bean:write name="dlx" property="maDuLieuXe"/></td>
            	 <td><bean:write name="dlx" property="maLichXe"/></td>
            	 <td><bean:write name="dlx" property="diemDi"/> - <bean:write name="dlx" property="diemDen"/></td>
            	 <td><bean:write name="dlx" property="maXe"/></td>
            	 <td><bean:write name="dlx" property="ngayDi"/></td>
            	 <td><bean:write name="dlx" property="gioXuatPhat"/></td>
            	 <td><span style="margin-left: 20px;"><bean:write name="dlx" property="soChoConLai" /></span></td>
            
                <td>
                	<bean:define id="maDuLieuXe" name="dlx" property="maDuLieuXe"></bean:define>
                	<html:link action="/xac-nhan-tt?maDuLieuXe=${maDuLieuXe}">
                		<span class="glyphicon glyphicon-check"></span>
                	</html:link>
                	<html:link action="/xoa-ve-xe?maDuLieuXe=${maDuLieuXe}" style="margin-left: 20px;">
                		<span class="glyphicon glyphicon-trash"></span>
                	</html:link>
                </td>
            </tr>
            </logic:iterate>
      </tbody>
  </table>
  <%-- 
    <div>
	<center> 
		<div class="col-lg-12">
			<span style="color: #1556a6;font-weight: bold;font-size: 18px;"><bean:write name="veXeForm" property="thongBaoTimKiem" /></span>
       </div>
	</center>
  </div>  
  --%>
  <!-- 
  <div>
	<center> 
		<button class="w3-bar-item w3-button w3-black">First</button>
		<button class="w3-bar-item w3-button w3-teal">1</button>
		<button class="w3-bar-item w3-button w3">2</button>
		<button class="w3-bar-item w3-button w3">...</button>
		<button class="w3-bar-item w3-button w3-black">Last</button>
	</center>
  </div> -->
</div>

</body>
</html>
