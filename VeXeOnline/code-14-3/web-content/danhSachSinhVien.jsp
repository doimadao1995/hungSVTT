<%@page import="model.bean.Pagination"%>
<%@page import="model.bean.Khoa"%>
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
    <title>Danh sách sinh viên</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <html:form action="/danh-sach" method="get">
            <div class="col-lg-4">
                <html:select property="maKhoa" styleClass="form-control">
					<option value="">-- Chọn khoa --</option>
					<html:optionsCollection name="danhSachSinhVienForm" property="listKhoa" 
						label="tenKhoa" value="maKhoa" />
				</html:select>
            </div>
            <script type="text/javascript">
            	$("[name='maKhoa']").val('<bean:write name="danhSachSinhVienForm" property="maKhoa"/>');
            </script>
            <html:submit styleClass="btn btn-primary">Xem</html:submit>
            <div class="col-lg-6 pull-right">
            	<div class="col-lg-3">
            	<html:link styleClass="btn btn-primary" action="/themSV">Thêm mới</html:link>
            	</div>
            	 <div class="col-lg-6">
            	 
                	<html:text property="tuKhoa" styleClass="form-control"></html:text>
                	
           		</div>
            	<html:submit styleClass="btn btn-primary">Tìm kiếm</html:submit>
            </div>
        </html:form>
    </div>
    <br>
    
    
    <script>
function myFunction() {
    var txt;
    var r = confirm("Press a button!");
    if (r == true) {
        return "/xoaSV?msv=${msv}";
    } else {
        txt = "You pressed Cancel!";
    }
}
</script>

    <div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>MSV</th>
                <th>Họ và tên</th>
                <th>Giới tính</th>
                <th>Khoa</th>
                <th>Địa chỉ</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="danhSachSinhVienForm" property="listSinhVien" id="sv">
            	<tr>
                <th scope="row">
                	<bean:write name="sv" property="msv"/>
				</th>
                <td>
                	<bean:write name="sv" property="hoTen"/>
                </td>
                <td>
                	<bean:write name="sv" property="gioiTinh"/>
				</td>
                <td>
                	<bean:write name="sv" property="tenKhoa"/>
                </td>
                <td>
                	<bean:write name="sv" property="diaChi"/>
                </td>
                <td>
                	<bean:define id="msv" name="sv" property="msv"></bean:define>
                	<html:link action="/suaSV?msv=${msv}">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link>
                	<html:link action="/xoaSV?msv=${msv}" style="margin-left: 30px;">
                		<span class="glyphicon glyphicon-trash"></span>
                	</html:link>
                </td>
            </tr>
            </logic:iterate>
            </tbody>
        </table>
    </div>
    
    <script type="text/javascript">
            	$("[name='tuKhoa']").val('<bean:write name="danhSachSinhVienForm" property="tuKhoa"/>');
	            $(document).ready(function() {
	            	var pageStatic = parseInt(<% out.print(Pagination.page + 1); %>); 
	            	if($("[name='page']").val() == ""){
	            		$("[name='page']").val(1);
	            		console.log("Rong");
	            	}
	            	$("#"+ pageStatic).addClass("active");
	            }); 
	            function handleClickAction(page) {
	            	$("[name='page']").val(page);  
	                document.forms[0].submit();
	            }
     </script>
     <div class="container" style=" display: flex; align-items: center;">
	        <ul class="pagination" style="margin: 0 auto;">
	  			<li class="1"><a href="?page=0"  onclick='handleClickAction("1")'>&laquo;</a></li> 
		        <%
		        	if(Pagination.totalPage < 8){
		    	    	for(int i = 0; i < Pagination.totalPage; i++){
		    	    		out.println("<li id='"+ (i + 1) +"'><a href='?page="+i+"' onclick='handleClickAction("+ (i + 1) +");'>"+(i + 1)+"</a></li>");
		    	    	}
		        	}else{
		        		if( Pagination.page < 2){
			    	    	for(int i = 0; i < 4; i++){
			    	    		out.println("<li id='"+ (i + 1) +"'><a href='?page="+i+"' onclick='handleClickAction("+ (i + 1) +");'>"+(i + 1)+"</a></li>");
			    	    	}
			    	    	

							int mid = (Pagination.totalPage - 4 - 4) / 2 + 4;
		    				out.println("<li><a href='?page="+mid+"' onclick='handleClickAction(" + mid + ")'> ... </a></li>");  

		    				
			    	    	for(int i = Pagination.totalPage - 4; i < Pagination.totalPage; i++){
			    	    		out.println("<li id='"+ (i + 1) +"'><a href='?page="+i+"' onclick='handleClickAction("+ (i + 1) +");'>"+(i + 1)+"</a></li>");
			    	    	}
		        		}else{
							int midFirst = (Pagination.page - 2) / 2;
		    				out.println("<li><a href='?page="+midFirst+"' onclick='handleClickAction(" + midFirst + ")'> ... </a></li>");  

		        			int n = Pagination.page + 3 > Pagination.totalPage ? Pagination.totalPage :  Pagination.page + 3;
	        				for(int i = Pagination.page - 2; i < n; i++){
			    	    		out.println("<li id='"+ (i + 1) +"'><a href='?page="+i+"' onclick='handleClickAction("+ (i + 1) +");'>"+(i + 1)+"</a></li>");
			    	    	}
		    				
		    				if(Pagination.page < Pagination.totalPage - 4){
		    					int midLast = (Pagination.totalPage - ( Pagination.page + 2))/2 + Pagination.page + 2 ;
			    				if (midLast > Pagination.totalPage)
			    					midLast = Pagination.totalPage;
			    				out.println("<li><a href='?page="+midLast+"' onclick='handleClickAction(" + midLast + ")'> ... </a></li>"); 
		    				}
		    				
		        		}
		        	}
		        %> 
	  			<li class="<%=Pagination.totalPage%>"><a href="?page=<%=Pagination.totalPage-1%>"  onclick='handleClickAction("<%=Pagination.totalPage%>")'>&raquo;</a></li> 
			</ul>
		</div>
</div>
</body>
</html>