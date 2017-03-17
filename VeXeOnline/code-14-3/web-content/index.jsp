<%@page import="common.StringProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
	<meta charset="UTF-8">
	<title>Trang chủ</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="img/icon.ico" rel="shortcut icon" type="image/x-icon" />
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
   <script type="text/javascript">
   var today = new Date();
   var dd = today.getDate();
   var mm = today.getMonth()+1; //January is 0!
   var yyyy = today.getFullYear();

   if(dd<10) {
       dd='0'+dd
   } 

   if(mm<10) {
       mm='0'+mm
   } 

   today = dd+'/'+mm+'/'+yyyy;
   document.getElementById("mytext").value = "My value";
   </script>
    
</head>
<body>

<div class="container">
	<!-- Header -->
	<nav class="header-blue">
        <div class="container">
            <div class="row">
                <div class="col-md-3" >
                   <a href="" class="logo-image">
                       <img height="50" src="img/logo1.svg">
                   </a>
                    <!-- <ul class="header-action-bar visible-sm visible-xs">
                        <li><a href="" onclick="showMenu();">
                            <i class="fa fa-bars"></i></a></li>
                        </ul> -->
                    </div>
                    <div id="overlay-layout" style="position: fixed; width: 100%; height: 100%; background-color: #A6A6A6; opacity: 0.7; z-index: 99; margin-top: 7px; display: none;">
                    </div> 
                    <div class="col-md-9 header-blue-right-menu" >
                     <ul class="nav navbar-nav header-blue-menu-list" >
                        <li><a href="" data-toggle="modal" data-target="#myModal"> <span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        <li><a href=""> <span class="glyphicon glyphicon-cog"></span> Liên hệ</a></li>
                        <li><a href=""> <span class="glyphicon glyphicon-dashboard"></span> Tin tức</a></li>
                        <li><a href=""> <span class="glyphicon glyphicon-share-alt"></span> Lịch trình</a></li>
                        <li><a href=""> <span class="glyphicon glyphicon-check"></span> Kiểm tra vé</a></li>
                        <li><a href=""><span class="glyphicon glyphicon-home"></span> Trang chủ</a></li>
                     </ul>
                </div>
            </div>
        </div>
    </nav>
    <!-- End Header -->
    
    
    <div class="container">
		<html:form action="/dat-ve" method="post">
			<div class="row form-group">
				<label class="col-lg-2">Điểm Đi</label>
				<div class="col-lg-3">
					<html:select property="diemDi" styleClass="form-control">
						<html:option value="QN">Quy Nhơn</html:option>
						<html:option value="DN">Đà Nẵng</html:option>
					</html:select>
					<html:errors property="tenDangNhapError"/>
				</div>
			</div>
			
			<div class="row form-group">
				<label class="col-lg-2">Điểm đến</label>
				<div class="col-lg-3">
					<html:select property="diemDen" styleClass="form-control">
						<html:option value="DN">Đà Nẵng</html:option>
						<html:option value="QN">Quy Nhơn</html:option>
					</html:select>
				</div>
			</div>
			
			<div class="row form-group">
				<label class="col-lg-2">Ngày đi</label>
				<div class="col-lg-3">
					<input type="date" value="2017-03-10" name="ngayDi" id="ngayDi" class="form-control">
				</div>
			</div>
			
			
			<div class="row form-group">
				<label class="col-lg-2">Số lượng vé</label>
				<div class="col-lg-3">
					<html:select property="soLuongVe" styleClass="form-control">
						<html:option value="1">-- 1 --</html:option>
						<html:option value="2">-- 2 --</html:option>
						<html:option value="3">-- 3 --</html:option>
						<html:option value="4">-- 4 --</html:option>
						<html:option value="5">-- 5 --</html:option>
						<html:option value="6">-- 6 --</html:option>
						<html:option value="7">-- 7 --</html:option>
						<html:option value="8">-- 8 --</html:option>
						<html:option value="9">-- 9 --</html:option>
						<html:option value="10">-- 10 --</html:option>
					</html:select>
				</div>
			</div>
			
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary">Đặt vé</html:submit>
				</div>
			</div>
		</html:form>
	</div>
    
    <!-- Login Form -->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <center> 
              <h1 class="col-lg-8 col-lg-offset-1" style="color: blue">Login</h1>
            </center>
			
			<html:form action="/login" method="post">
              <div class="row form-group">
                <h5 class="col-lg-10 col-lg-offset-2" style ="color:green">
                  Thông tin đánh dấu (*) là bắt buộc không được để trống
                </h5>
              </div>
              <div class="row form-group" >
                <label class="col-lg-4 col-lg-offset-1">Tài khoản (*)</label>
                <div class="col-lg-5">
               		<html:text property="tenDangNhap" styleClass="form-control" value="ADMIN" maxlength="10" size="10" ></html:text>
					<html:errors property="tenDangNhapError"/>
               
                </div>
              </div>
              <div class="row form-group">
                <label class="col-lg-4 col-lg-offset-1">Mật khẩu (*)</label>
                <div class="col-lg-5">
                  	<html:password property="matKhau" styleClass="form-control" value="ADMIN"></html:password>
					<html:errors property="matKhauError"/>
                </div>
              </div> 

              <div class="row form-group">
                <div class="col-lg-8 col-lg-offset-1">
                 <center>
                  	 <html:submit styleClass="btn btn-primary">Đăng nhập</html:submit>
					<button class="btn btn-primary" type="reset">Hủy</button>
                 </center>
               </div>
             </div>
             <div class="row form-group">
              <div class="col-lg-12 col-lg-offset-1 ">
              <html:link href="a.jsp">Đăng ký</html:link> nếu bạn chưa có tài khoản...
              <html:link href="b.jsp">Quên mật khẩu</html:link>
                
              </div>
            </div>
         </html:form>
        </div>
      </div>
    </div>
    </div>
    <!-- End Login Form -->
    
    
     <div class="br-modal">
        <div id="sb-site">
        
        	<!-- Nav Tab -->
		    <div class="row">
		        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-ms-12">
		           <!--  <h3 class="text-primary text-uppercase">Tuyến đường</h3> -->
		            <center><h2 class="text-danger">NHỮNG LỊCH TRÌNH CÓ SẴN</h2></center>
		            <ul class="nav nav-tabs">
		                <li class="active"><a href="#home">ĐÀ NẴNG</a></li>
		                <li><a href="#menuHaNoi">HÀ NỘI</a></li>
		                <li><a href="#menuSaiGon">SÀI GÒN</a></li>
		                <li><a href="#menuNhaTrang">NHA TRANG</a></li>
		                <li><a href="#menuDaLat">ĐÀ LẠT</a></li>
		            </ul>
		
					<!-- Tab Content -->
		            <div class="tab-content"> 
		               <div id="home" class="tab-pane fade in active">
		                <div class="section-list">
		                    <h3 class="text-uppercase text-success">
		                        <span class="sprite ico-drive"></span> Đà Lạt <i class="fa fa-exchange"></i>
		                    </h3>
		                    <div class="table-responsive">
		                        <table class="table ">
		                            <thead>
		                                <tr class="text-white bg-light-green">
		                                    <th>STT</th>
		                                    <th data-toggle="true">Bến đi</th>
		                                    <th>Bến đến</th>
		                                    <th data-hide="phone">Loại xe</th>
		                                    <th data-hide="phone">Quãng đường</th>
		                                    <th data-hide="phone">Thời gian</th>
		                                    <th data-hide="phone">Số chuyến</th>
		                                    <th data-hide="phone">Giá vé</th>
		                                    <th data-hide="phone">Giờ chạy</th>
		                                    <th></th>
		                                </tr>
		                            </thead>
		                            <tbody>
		
		                                <tr class="route-row45">
		                                    <td>1</td>
		                                    <td>Đà Lạt</td>
		                                    <td>Nha Trang</td>
		                                    <td>Ghế</td>
		                                    <td>138 km</td>
		                                    <td>
		
		                                        04h00
		                                    </td>
		                                    <td>7 chuyến/ngày</td>
		                                    <td>
		                                        <p>
		                                            <strong class="text-primary">
		                                                125,000<sup>đ/vé</sup>
		                                            </strong>
		                                        </p>
		                                    </td>
		                                    <td>
		
		                                        <a class="br-btn-flat br-watch-schedule" href="">
		                                            <i class="fa fa-clock-o icon-flat text-success"></i>
		                                        </a>
		                                    </td>
		                                    <td>
		
		
		                                      <a href="#" class="btn btn-success btn-md" data-toggle="modal" data-target="#myModal">
		                                       <span class="glyphicon glyphicon-share-alt"></span> Mua vé 
		                                   </a>
		
		                              		</td>
		                        		 </tr>
		   							</tbody>
								</table>
							</div>
						</div>
						</div>
		
						<div id="menuSaiGon" class="tab-pane fade">
						 <div class="section-list">
							    <h3 class="text-uppercase text-success">
							        <span class="sprite ico-drive"></span> Sài gòn <i class="fa fa-exchange"></i>
							    </h3>
							    <div class="table-responsive">
							        <table class="table ">
							            <thead>
							                <tr class="text-white bg-light-green">
							                    <th>STT</th>
							                    <th data-toggle="true">Bến đi</th>
							                    <th>Bến đến</th>
							                    <th data-hide="phone">Loại xe</th>
							                    <th data-hide="phone">Quãng đường</th>
							                    <th data-hide="phone">Thời gian</th>
							                    <th data-hide="phone">Số chuyến</th>
							                    <th data-hide="phone">Giá vé</th>
							                    <th data-hide="phone">Giờ chạy</th>
							                    <th></th>
							                </tr>
							            </thead>
							            <tbody>
							                <tr class="route-row45">
							                    <td>1</td>
							                    <td>Đà Lạt</td>
							                    <td>Nha Trang</td>
							                    <td>Ghế</td>
							                    <td>138 km</td>
							                    <td>04h00</td>
							                    <td>7 chuyến/ngày</td>
							                    <td><p>
							                            <strong class="text-primary">
							                                125,000<sup>đ/vé</sup>
							                            </strong>
							                        </p>
							                    </td>
							                    <td>
							                        <a class="br-btn-flat br-watch-schedule" href="">
							                            <i class="fa fa-clock-o icon-flat text-success"></i>
							                        </a>
							                    </td>
							                    <td>
							                        <a href="#" class="btn btn-success btn-md">
							                           <span class="glyphicon glyphicon-share-alt"></span> Mua vé 
							                       </a>
							
							                   </td>
							               </tr>
										</tbody>
									</table>
									</div>
								</div>
							</div>
		
						</div>
						<!-- End Tab Content -->
				</div>
			</div>
			<!-- End Nav Tab -->

		</div>
	</div>

<script>
    $(document).ready(function(){
        $(".nav-tabs a").click(function(){
            $(this).tab('show');
        });
    });
</script>
    
    
    
</body>
</html>