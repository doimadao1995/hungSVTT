<%@page import="model.bean.Pagination"%>
<%@page import="model.bean.LichTrinh"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.DiemDonKhach"%>
<%@page import="model.bean.DiemTraKhach"%>
<%@page import="model.bean.GioXuatPhat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <title>Thanh toán</title>
    <meta name="description" content="" />
    <meta name="keywords" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="alternate" type="text/html" href="http://vexere.com/vi-VN/Payment/FillBookingDetails" hreflang="x-default" title="Vietnamese" />
    <link rel="alternate" type="text/html" href="http://vexere.com/vi-VN/Payment/FillBookingDetails" hreflang="en" title="English" />
    <link rel="shortcut icon" type="image/x-icon" href="/Content/tp/images/favicon.ico" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
    <link href="https://vexere.com/Content/vxr/css/third-party/bootstrap.min.css" rel="stylesheet" />

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="css/payment.css" rel="stylesheet" />
    <link href="css/toastr.css" rel="stylesheet" />
    <link href="css/ball-spin-clockwise.css" rel="stylesheet" />
    <link href="css/RouteLoadingEffect.css" rel="stylesheet" />

    
    <script type="text/javascript">
        setTimeout(function () {
            var a = document.createElement("script");
            var b = document.getElementsByTagName("script")[0];
            a.src = document.location.protocol + "//script.crazyegg.com/pages/scripts/0054/4518.js?" + Math.floor(new Date().getTime() / 3600000);
            a.async = true; a.type = "text/javascript"; b.parentNode.insertBefore(a, b)
        }, 1);
    </script>
    

    <!-- Start of widget script -->
    
    

    <!-- End of widget script -->

</head>

<body>
    <script>
    (function (w, d, s, l, i) {
        w[l] = w[l] || []; w[l].push({
            'gtm.start':
                new Date().getTime(), event: 'gtm.js'
        }); var f = d.getElementsByTagName(s)[0],
            j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : ''; j.async = true; j.src =
            '//www.googletagmanager.com/gtm.js?id=' + i + dl; f.parentNode.insertBefore(j, f);
    })(window, document, 'script', 'dataLayer', 'GTM-5QZHFF');
    </script>

    
    <!-- >header -->
    
<header id="payment-header">
    <nav class="header-blue">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <a href="/" class="logo-image"><img height="50" src="/Content/vxr/images/Home/logo.svg" /></a>
                </div>
                <div class="col-md-6 header-blue-middle text-center hidden-xs hidden-sm">
                    <p class="text-white">Mua vé online, cùng góp phần vào sứ mệnh</p>
                    <h5 style="color: #f8b917; font-weight: bold">VÌ HÀNG TRIỆU NGƯỜI VIỆT NAM KHÔNG AI PHẢI XẾP HÀNG MUA VÉ</h5>
                </div>
                <div class="col-md-3 header-blue-right-menu time-left">
                    <ul class="header-blue-menu-list">
                        <li>
                            <h4 class="text-white" style="position: relative;"><i class="fa fa-clock-o"></i> <small>Thời gian thanh to&aacute;n c&ograve;n lại</small> <span class="text-time-left mt0 mb0"></span></h4>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

    
</header>


    <!-- /header -->
    <!-- >payment content -->
    


<div class="container main-content">
    <div class="container">
    
    
      <html:form action="/thanh-toan" styleClass="form-horizontal" styleId="frmBookingDetail">
    	
         
            
            
            
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
		<html:hidden property="gioXuatPhat" styleClass="form-control" />
		<html:hidden property="diemDonKhach" styleClass="form-control" />
		<html:hidden property="diemTraKhach" styleClass="form-control" />
      

            <div class="row">
                <div class="col-md-8">
                    <div class="row mt5 payment-select-row hidden-xs hidden-sm">
                        <div class="col-md-12">
                            <p class="hidden-xs hidden-sm">
                                <span class="text-ten-thousand">100.000+</span> <span style="position: relative; top: -2px;">vé đã được thanh toán trên VeXeOnline<br /></span>
                            </p>
                        </div>

                        <div class="col-md-12 mt10 pl0">
                            <div class="col-md-6">
                                Giao dịch tại VeXeOnline được cam kết an toàn và bảo mật biểu thị qua biểu tượng ổ khoá màu xanh trên thanh trình duyệt của bạn.
                            </div>
                            <div class="col-md-6">

                                <div class="row" style="border-left: 1px solid #ccc">
                                    <div class="col-md-5">
                                        <img class="img-responsive" src="img/certificate0.png">
                                    </div>
                                    <div class="col-md-5 pl0">
                                        <img class="img-responsive" src="img/certificate1.png">
                                    </div>
                                </div>

                            </div>

                        </div>
                        <div class="col-md-12">
                            
                            <h5 class="text-bold" style="font-size: 17px;color: #F08300;line-height: 18px;">
                                Vui lòng chọn hình thức thanh toán để hoàn tất việc đặt vé
                            </h5>
                        </div>
                    </div>
                    <div class="row mt5">
                        <div class="col-md-12 visible-xs visible-sm">                            
                            <h5 class="text-bold" style="font-size: 17px;color: #F08300;line-height: 18px;">
                                Vui lòng chọn hình thức thanh toán để hoàn tất việc đặt vé
                            </h5>
                        </div>
                        <div class="col-md-12 tab-wrapper">
                            <div class="panel-group" id="accordion" role="tablist">
                                        <div class="panel panel-default">
                                            <div class="panel-heading" role="tab" id="headingFive">
                                                <h4 class="panel-title">
                                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#payment-diemgiaodich" aria-expanded="false" aria-controls="payment-diemgiaodich">
                                                        <span class="ico-dgd"></span>
                                                        <span class="hidden-xs hidden-sm payoo-text ">Thanh toán tiền mặt tại các cửa hàng tiện lợi và siêu thị gần địa chỉ của bạn </span><span class="visible-xs-sm-inline payoo-text-mb  ">Cửa hàng gần nhà </span><i class="fa fa-angle-down pull-right"></i>&nbsp;<span class="img-payment-guide"></span>
                                                        <input type="radio" name="PaymentMethod" class="radio" style="display: none;" value="PAYOO" />
                                                        <span class="check"><span class="inside"></span></span>
                                                    </a>
                                                </h4>
                                            </div>
                                            <div id="payment-diemgiaodich" class="panel-collapse collapse" role="tabpanel">
                                                <div class="panel-body">
                                                    <div class="row payoo-shop-row">
                                                        <div class="col-md-12">
                                                            <div class="payoo-shop circlek"></div>
                                                            <div class="payoo-shop bsmart"></div>
                                                            <div class="payoo-shop vinmart"></div>
                                                            <div class="payoo-shop family-mart"></div>
                                                            <div class="payoo-shop guardian"></div>
                                                            <div class="payoo-shop ministop"></div>
                                                            <div class="payoo-shop trananh"></div>
                                                        </div>
                                                    </div>
                                                    <p class="mt10"><b>1. Nhập địa chỉ bạn muốn tìm cửa hàng gần đó</b></p>
                                                    <div class="row">
                                                        <div class="col-md-6 col-xs-12">
                                                            <select name="BuyerInfo.State" style="width: 100%" id="state-select" class="form-control">
                                                                <option value="">-- Chọn Tỉnh/Thành phố --</option>
                                                            </select>
                                                        </div>
                                                        <div class="col-md-6 col-xs-12 district-select-container">
                                                            <select name="BuyerInfo.District" id="district-select" style="width: 100%" class="form-control">
                                                                <option value="">-- Chọn Quận/Huyện --</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <i class="fa fa-home icon-home-payoo"></i>
                                                            <input id="AddressPayoo" class="form-control payment-input mt5 mb5" name="BuyerInfo.Address" value="" placeholder="Nhập địa chỉ bạn muốn t&#236;m cửa h&#224;ng gần đ&#243;" />
                                                            <button type="button" class="btn btn-get-store btn-block btn-md btn-success no-border-radius visible-sm visible-xs">
                                                                <i class="fa fa-map-marker"></i>&nbsp; Tìm cửa hàng gần chỗ bạn
                                                            </button>
                                                        </div>
                                                    </div>
                                                    <p><b>2. Chọn cửa hàng gần bạn</b></p>
                                                    <div class="row">
                                                        <div class="col-sm-12"><p class="text-red">Lưu ý: Bạn có thể thanh toán tại bất kỳ cửa hàng tiện lợi nào khác với lựa chọn của bạn. </p></div>
                                                        <div class="col-xs-12 col-sm-12 visible-sm visible-xs">

                                                            <table style="display: none;" id="trTemplate">
                                                                <tr>
                                                                    <td><input type="radio" name="BuyerInfo.PayooAddress" class="{index}-payoo-radio" /></td>
                                                                    <td>
                                                                        <p><b>Tên cửa hàng:</b> <span class="{index}-store-name"></span></p>
                                                                        <p><b>Địa chỉ:</b> <span class="{index}-store-address"></span></p>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <table class="table table-payoo-store hidden mb0">
                                                                
                                                                

                                                                
                                                            </table>
                                                        </div>
                                                        <div class="col-md-12 hidden-xs hidden-sm">
                                                            <select name="BuyerInfo.PayooAddress" id="address-payoo-select" class="form-control">
                                                                <option value="">-- Chọn cửa hàng gần bạn --</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                        <p class="text-bold payoo-info mt10 hidden-xs">
                                                            3. Bạn vui lòng đến thanh toan tại địa chỉ này trong vòng 45 phút kể từ khi đặt vé, sau thời gian này vé không thanh toán sẽ tự động huỷ.
                                                        </p>
                                                        <p class="text-bold payoo-info hidden-xs">4. Sau khi thanh toán, bạn sẽ nhận được <span class="">vé điện tử qua tin nhắn và Email thay cho vé giấy để lên xe</span></p>
                                                        <p class="visible-xs"><b>Lưu &yacute;:</b> Thời gian thanh toán là: <b style="color: red">45 phút</b>, sau thời gian này vé không thanh toán sẽ tự động huỷ.</p>

                                                    
                                                        <div class="input-group coupon-row visible-xs w100">
                                                            <input type="text" class="form-control payment-input redeemCode" placeholder="M&#227; giảm gi&#225;">
                                                            <button type="button" class="btn btn-md btn-vxr redeemBtn">Sử dụng</button>
                                                        </div>
                                                    <hr class="hidden-xs" />
                                                    <p class="rule-container text-red text-right text-bold">
                                                        <span class="hidden-xs hidden-sm"><span>Vui lòng nhấn nút </span> <span>Đặt chỗ</span> <span>để hoàn tất việc đặt vé</span></span>
                                                                                                            </p>
                                                    <div class="form-group total-container pull-right mt10">
                                                        <label class="old-total-fare-row pr10">
                                                            <span>Tạm tính: </span>
                                                            <span class="txtOldTotalFare text-pr-mb"></span>
                                                        </label>
                                                        <label class="pr10 coupon-result-row">
                                                            <span class="col-xs-7" style="padding: 0;">
                                                                Mã giảm giá: <b class="txtCouponCode"></b><br />
                                                                <label class="text-edit">Chỉnh sửa</label>
                                                            </span>
                                                            <span class="txtCouponValue text-pr-mb"></span>
                                                        </label>
                                                        <label class="pr0 pl0" style="position: relative; vertical-align: top;">
                                                            <span>Tổng tiền: </span>
                                                            <span class="text-total-fare text-pr-mb">
                                                                <bean:write name="datVeForm" property="tongTienString" />
                                                            </span>

                                                        </label>
                                                        <button type="button" class="btn btn-lg btn-vxr-thanhtoan payment-submit-btn">Đặt chỗ</button>
                                                    </div>
                                                    
                                                    <div class="row visible-md visible-lg">
                                                        
                                                        <div class="col-md-12 mt10">
                                                            <label>
                                                                Bạn gặp vấn đề trong quá trình thanh toán? Gọi ngay VeXeOnline qua hotline 
                                                                
                                                                        <a href="tel:1900 7070" style="font-size: 18px; color: #F08300;">1900 7070</a>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="panel panel-default">
                                            <div class="panel-heading" role="tab" id="headingOne">
                                                <h4 class="panel-title">
                                                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#payment-visa" aria-expanded="true" aria-controls="payment-visa">
                                                        <span class="ico-visa"></span>
                                                        <span class="hidden-xs hidden-sm">Thanh toán bằng thẻ quốc tế
                                                        	<img class="creditcard-logo" src="img/visa-logo-web.png" />
                                                        	<img class="creditcard-logo" src="img/mastercard-logo-web.png" />
                                                        	<img class="creditcard-logo" src="img/jcb-logo-web.png" />
                                                        </span>
                                                        <span class="visible-xs-sm-inline">Thẻ quốc tế
                                                        	<img class="creditcard-logo" src="img/visa-logo-web.png" />
                                                        <img class="creditcard-logo" src="img/mastercard-logo-web.png" />
                                                        <img class="creditcard-logo" src="img/jcb-logo-web.png" />
                                                        </span>
                                                        <i class="fa fa-angle-down pull-right"></i>&nbsp;<span class="img-payment-guide"></span>
                                                        <input type="radio" name="PaymentMethod" style="display: none;" class="radio" value="VISA" />
                                                        <span class="check"><span class="inside"></span></span>
                                                    </a>
                                                </h4>
                                            </div>
                                            
                                            <div id="payment-visa" class="panel-collapse collapse" role="tabpanel">
                                                <div class="panel-body">
                                                    <p><b>Trên thẻ của bạn phải có các ký hiệu Visa, Master hay JCB để thanh toán được bằng hình thức này</b></p>
                                                    
                                                    <p><b>1. Bạn sẽ được chuyển hướng về cổng thanh toán OnePay để hoàn tất thanh toán. OnePay hiện tại hỗ trợ thanh toán qua 25 ngân hàng tại Việt Nam.
</b></p>
                                                    

                                                    <p>
                                                        <b>2. Nhập thông tin trên thẻ</b>
                                                    </p>
                                                    <p>
                                                        <b>3. Sau khi thanh toán, bạn sẽ nhận được <span class="">vé điện tử qua tin nhắn và Email thay cho vé giấy để lên xe</span></b>
                                                    </p>
                                                    

                                                    <div>
                                                        
                                                            <div class="input-group coupon-row visible-xs w100">
                                                                <input type="text" class="form-control payment-input redeemCode" placeholder="M&#227; giảm gi&#225;">
                                                                <button type="button" class="btn btn-md btn-vxr redeemBtn">Sử dụng</button>
                                                            </div>
                                                        <hr class="hidden-xs" />

                                                        <p class="rule-container text-red text-right text-bold">
                                                            <span class="hidden-xs hidden-sm"><span>Vui lòng nhấn nút </span> Thanh toán <span>để hoàn tất việc đặt vé</span></span>
                                                       </p>

                                                        <div class="form-group total-container pull-right mt10">
                                                            <label class="old-total-fare-row pr10">
                                                                <span>Tạm tính: </span>
                                                                <span class="txtOldTotalFare text-pr-mb"></span>
                                                            </label>
                                                            <label class="pr10 coupon-result-row">
                                                                <span class="col-xs-7" style="padding: 0;">
                                                                    Mã giảm giá: <b class="txtCouponCode"></b><br />
                                                                    <label class="text-edit">Chỉnh sửa</label>
                                                                </span>
                                                                <span class="txtCouponValue text-pr-mb"></span>
                                                            </label>
                                                            <label class="pr0 pl0" style="position: relative; vertical-align: top;">
                                                                <span>Tổng tiền: </span>
                                                                <span class="text-total-fare text-pr-mb">
                                                                    <bean:write name="datVeForm" property="tongTienString"/>
                                                                </span>
                                                            </label>

                                                            
                                                            <button type="button" class="btn btn-lg btn-vxr-thanhtoan payment-submit-btn">Thanh toán</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="panel panel-default">
                                            <div class="panel-heading" role="tab" id="headingTwo">
                                                <h4 class="panel-title">
                                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#payment-atm" aria-expanded="false" aria-controls="payment-atm">
                                                        <span class="ico-atm"></span>
                                                        <span class="hidden-xs hidden-sm">Thanh toán bằng thẻ ATM đã đăng ký Internet Banking</span><span class="visible-xs-sm-inline">Thẻ ATM Internet Banking</span><i class="fa fa-angle-down pull-right"></i>&nbsp;<span class="img-payment-guide"></span>
                                                        <input type="radio" name="PaymentMethod" class="radio" style="display: none;" value="ATM" />
                                                        <span class="check"><span class="inside"></span></span>
                                                    </a>
                                                </h4>
                                            </div>
                                            <div id="payment-atm" class="panel-collapse collapse" role="tabpanel">
                                                <div class="panel-body">
                                                    <p><b>Thẻ của bạn phải có đăng ký dịch vụ Internet Banking với ngân hàng</b></p>
                                                    <p><b>1. Chọn ngân hàng trên thẻ của bạn</b></p>
                                                    <div class="container-fluid pl0 pr0">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <select id="bankSelect" style="width: 100%;" class="form-control" name="bankCode">
                                                                    <option value="">Vui lòng chọn Ngân hàng để thanh toán</option>
                                                                    <option value="123PABB-ABB">ABBank - NHTMCP An Bình</option>
                                                                    <option value="123PACB-ACB">ACB - NHTMCP Á Châu</option>
                                                                    <option value="123PAGB-ARGI">Agribank - NH Nông Nghiệp và PT Nông Thôn VN</option>
                                                                    <option value="123PBIDV-BIDV">BIDV - NHTMCP Đầu Tư Và Phát Triển VN</option>
                                                                    <option value="123PDAB-DNA">DongA Bank - NHTMCP Đông Á</option>
                                                                    <option value="123PEIB-EXB">EximBank - NHTMCP Xuất Nhập Khẩu VN</option>
                                                                    <option value="123PGPB-GPB">GP Bank - NHTNHH MTV Dầu Khí Toàn Cầu</option>
                                                                    <option value="123PHDB-HDB">HDBank - NHTMCP Phát Triển TP.HCM</option>
                                                                    <option value="123PMRTB-MRTB">Maritime Bank - NHTMCP Hàng Hải</option>
                                                                    <option value="123PMB-MBB">MBBank - NHTMCP Quân Đội</option>
                                                                    <option value="123PNAB-NAB">Nam A Bank - NHTMCP Nam Á</option>
                                                                    <option value="123PNVB-NVB">Navibank - NHTMCP Nam Việt</option>
                                                                    <option value="123POCB-OCB">OCB - NHTMCP Phương Đông VN</option>
                                                                    <option value="123POCEB-OCEB">Ocean Bank - NHTMTNHH MTV Đại Dương</option>
                                                                    <option value="123PPGB-PGB">PG Bank - NHTMCP Xăng Dầu Petrolimex</option>
                                                                    <option value="123PSCB-SACB">Sacombank - NHTMCP Sài Gòn Thương Tín</option>
                                                                    <option value="123PSGB-SGB">Saigonbank - NHTMCP SG Công Thương</option>
                                                                    <option value="123PTCB-TECH">Techcombank - NHTMCP Kỹ Thương VN</option>
                                                                    <option value="123PVIB-VIB">VIB - NHTMCP Quốc Tế</option>
                                                                    <option value="123PVAB-VAB">VietA Bank - NHTMCP Việt Á</option>
                                                                    <option value="123PVCB-VCOM">Vietcombank - NHTMCP Ngoại Thương Việt Nam</option>  
                                                                    <option value="123PVTB-CTG">VietinBank - NHTMCP Công Thương VN</option>
                                                                    <option value="123PVPB-VPB">VPBank - NHTMCP VN Thịnh Vượng</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <p class="mt10"><b>2. Bạn sẽ được chuyển hướng về cổng thanh toán OnePay để hoàng tất thanh toán. OnePay hiện đã hỗ trợ thanh toán qua 25 ngân hàng tại Việt Nam.
</b></p>
                                                    <p><b>3. Sau khi thanh toán, bạn sẽ nhận được <span class="">vé; điện tử qua tin nhắn và Email thay cho vé giấy để lên xe</span></b></p>


                                                        <div class="input-group coupon-row visible-xs w100">
                                                            <input type="text" class="form-control payment-input redeemCode" placeholder="M&#227; giảm gi&#225;">
                                                            <button type="button" class="btn btn-md btn-vxr redeemBtn">Sử dụng</button>
                                                        </div>
                                                    <hr class="hidden-xs" />
                                                    <p class="rule-container text-red text-right text-bold">
                                                        <span class="hidden-xs hidden-sm"><span>Vui lòng nhấn nút </span> Thanh toán <span>để hoàn tất việc đặt vé</span></span>
                                                                                                            </p>
                                                    <div class="form-group total-container pull-right mt10">
                                                        <label class="old-total-fare-row pr10">
                                                            <span>Tạm tính: </span>
                                                            <span class="txtOldTotalFare text-pr-mb"></span>
                                                        </label>
                                                        <label class="pr10 coupon-result-row">
                                                            <span class="col-xs-7" style="padding: 0;">
                                                                Mã giảm giá: <b class="txtCouponCode"></b><br />
                                                                <label class="text-edit">Chỉnh sửa</label>
                                                            </span>
                                                            <span class="txtCouponValue text-pr-mb"></span>
                                                        </label>
                                                        <label class="pr0 pl0" style="position: relative; vertical-align: top;">
                                                            <span>Tổng tiền: </span>
                                                            <span class="text-total-fare text-pr-mb">
                                                                <bean:write name="datVeForm" property="tongTienString"/>
                                                            </span>
                                                        </label>

                                                        

                                                        <button type="button" class="btn btn-lg btn-vxr-thanhtoan payment-submit-btn">Thanh toán</button>
                                                    </div>
                                                    <div class="row visible-md visible-lg">
                                                        
                                                        <div class="col-md-12 mt10">
                                                            <label>
                                                                Bạn gặp vấn đề trong quá trình thanh toán? Gọi ngay VeXeRe qua hotline 
                                                                        <a href="tel:1900 7070" style="font-size: 18px; color: #F08300;">1900 7070</a>
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                      <!--   Hình thức chuyển khoản -->
                                      <!--   End Hình thức chuyển khoản -->
                            </div>
                        </div>
                        
                    </div>
                </div>
                
                <div class="col-md-4 col-ticket-info hidden-xs hidden-sm">
                    <div class="row">
                        <div style="display: none;" class="col-md-12 receive-ticket"></div>
                        <div class="col-md-12 payoo-banner">


                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            Họ tên:
                        </div>
                        <div class="col-md-7">
                            Đặng Văn Hưng
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            Điện thoại:
                        </div>
                        <div class="col-md-7">
                            0964658984
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            Email:
                        </div>
                        <div class="col-md-7">
                            onlinevuive24h@gmail.com
                        </div>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="col-md-5">
                            Tuyến đường:
                        </div>
                        <div class="col-md-7">
                        	<bean:write name="datVeForm" property="diemDi" /> -
                        	<bean:write name="datVeForm" property="diemDen" /> 
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            Nơi đi:
                        </div>
                        <div class="col-md-7">
                            <bean:write name="datVeForm" property="diemDi" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            Nơi đến:
                        </div>
                        <div class="col-md-7">
                            <bean:write name="datVeForm" property="diemDen" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            Giờ đi:
                        </div>
                        <div class="col-md-7">
                            <bean:write name="datVeForm" property="gioXuatPhat" /> <bean:write name="datVeForm" property="ngayDi" />
                        </div>
                    </div>
                    <div class="row">
                            <div class="col-md-5">
                                Giờ đến:
                            </div>
                            <div class="col-md-7">
                                03:30
                            </div>
                     </div>
                     <div class="row">
                            <div class="col-md-5">
                                Điểm đón khách:
                            </div>
                            <div class="col-md-7">
                                 <bean:write name="datVeForm" property="diemDonKhach" />
                            </div>
                      </div>
                      <div class="row">
                            <div class="col-md-5">
                                Điểm trả khách:
                            </div>
                            <div class="col-md-7">
                                 <bean:write name="datVeForm" property="diemTraKhach" /> 
                            </div>	
                      </div>
                    <div class="row">
                        <div class="col-md-5">
                            Giá một ghế:
                        </div>
                        <div class="col-md-7">
                            <span class="text-single-seat"><bean:write name="datVeForm" property="giaVeString" /> </span> 
                        </div>
                    </div>

                    
                    <div class="row">
                        <div class="col-md-5">
                            Số lượng chỗ:
                        </div>
                        <div class="col-md-7">
                            <bean:write name="datVeForm" property="soLuongVe" /> 
                        </div>
                    </div>
                        <div class="row coupon-row">
                            <div class="col-md-5 pr0">
                                <span id="spHadCoupon">Bạn c&oacute; m&atilde; giảm gi&aacute;?</span>
                                <input id="txtCheckRedeemCode" type="text" style="display: none;" class="form-control payment-input redeemCode" placeholder="Nhập m&#227; giảm gi&#225;">
                            </div>
                            <div class="col-md-7">
                                <label class="lbgiamgia">Sử dụng</label>
                                <button id="btnCheckRedeemCode" type="button" style="display: none;" class="btn btn-md btn-vxr redeemBtn">Sử dụng mã</button>
                            </div>
                        </div>
                    <div class="row old-total-fare-row-lg">
                        <div class="col-md-5">
                            Tạm tính:
                        </div>
                        <div class="col-md-7">
                            <span class="txtOldTotalFare"></span>
                        </div>
                    </div>
                    <div class="row coupon-result-row-lg">
                        <div class="col-md-5">
                            Mã giảm giá: <span class="txtCouponCode"></span>
                        </div>
                        <div class="col-md-7">
                            <span class="txtCouponValue"></span>&nbsp; <label class="text-edit">Chỉnh sửa</label>
                        </div>
                    </div>
                    <div class="row shipping-fee-row" style="display: none;">
                        <div class="col-md-5">
                            Ph&iacute; thu tiền:
                        </div>
                        <div class="col-md-7">
                            <span class="shipping-fee"></span> VNĐ
                        </div>
                    </div>
                    <div class="row row-payoo-discount" style="display: none;">
                        <div class="col-md-5">
                            Giảm giá:
                        </div>
                        <div class="col-md-7">
                            <span class="payoo-discount-value text-vxr"></span>
                        </div>
                    </div>
                    <div class="row row-total">
                        <div class="col-md-5 col-total">
                            Tổng tiền:
                        </div>
                        <div class="col-md-7 col-total">
                            <span class="text-total-fare-col"><bean:write name="datVeForm" property="tongTienString" /> </span><small></small>
                        </div>
                    </div>
                    
                </div>
                
            </div>
	</html:form>
        <hr />



        <div class="row visible-xs visible-sm">
            <div class="col-xs-12 pl0 pr0">
                <div class="container mt5 payment-select-row">
                    <h5 class="text-bold" style="font-size: 16px;">Thông tin chung:</h5>
                </div>

                <table class="table route-info-mobile">
                    <tr>
                        <td><span><bean:write name="datVeForm" property="diemDi"/> - <bean:write name="datVeForm" property="diemDen"/></span></td>
                        <td><span><b><bean:write name="datVeForm" property="ngayDi"/></b></span></td>
                    </tr>
                    <tr>
                        <td><span>Hưng TxT</span></td>
                        <td><span><b><bean:write name="datVeForm" property="gioXuatPhat"/> - <bean:write name="datVeForm" property="gioXuatPhat"/></b></span></td>
                    </tr>
                        <tr>
                            <td><span class="text-total-fare-col"><bean:write name="datVeForm" property="tongTienString"/></span></td>
                            <td><span><b><bean:write name="datVeForm" property="soLuongVe"/> vé</b></span></td>
                        </tr>

                </table>
            </div>
        </div>

        <div class="row visible-xs visible-sm">
            <div class="col-xs-12 pl0 pr0">
                <table class="table route-info-mobile">
                    <tr>
                        <td width="110"><span>Họ tên:</span></td>
                        <td><span>Đặng Văn Hưng</span></td>
                    </tr>
                    <tr>
                        <td><span>SĐT:</span></td>
                        <td><span>0964658984</span></td>
                    </tr>
                    <tr>
                        <td><span>Email:</span></td>
                        <td><span>onlinevuive24h@gmail.com</span></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

<button id="error-button" style="display: none;" type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>
<div id="error-modal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h3><i class="fa fa-exclamation-circle" style="color: #DB0601;font-size: 32px;"></i>&nbsp Thông báo</h3>
            </div>
            <div class="modal-body">
                <p>Thao tác thực hiện của quý khách chưa thành công. Quý khách chưa nhập hoặc nhập chưa chính xác những thông tin sau <br /> <b>Vui lòng nhập thông tin chính xác vào những ô có viền đỏ bên dưới và thực hiện lại</b></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng lại</button>
            </div>
        </div>
    </div>
</div>
<button id="invalid-captcha-button" style="display: none;" type="button" Đà Nẵng - Ninh Thuậnclass="btn btn-primary" data-toggle="modal" data-target=".modal-captcha">Small modal</button>
<div id="invalid-modal" class="modal fade modal-captcha" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h3><i class="fa fa-exclamation-circle" style="color: #DB0601;font-size: 32px;"></i>&nbsp Thông báo</h3>
            </div>
            <div class="modal-body">
                <p>Mã xác nhận không đúng.<br /> <b>Vui lòng nhập lại mã xác nhận!</b></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng lại</button>
            </div>
        </div>
    </div>
</div>

<div id="failed-modal" class="modal fade modal-captcha" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h3><i class="fa fa-exclamation-circle" style="color: #DB0601;font-size: 32px;"></i>&nbsp Thông báo</h3>
            </div>
            <div class="modal-body">
                <p>Thông tin thẻ không hợp lệ.<br /> <b>Xin vui lòng nhập lại thông tin thẻ!</b></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng lại</button>
            </div>
        </div>
    </div>
</div>

<div id="otp-failed-modal" class="modal fade modal-captcha" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h3><i class="fa fa-exclamation-circle" style="color: #DB0601;font-size: 32px;"></i>&nbsp Thông báo</h3>
            </div>
            <div class="modal-body">
                <p>Có lỗi xảy ra trong quá trình xác nhận mã OTP.<br /> <b>Xin vui lòng nhập lại mã OTP hoặc gọi đến số Hotline: 1900 6484 để được tư vấn thêm.</b></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng lại</button>
            </div>
        </div>
    </div>
</div>

<div id="coupon-failed-modal" class="modal fade modal-captcha" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h3><i class="fa fa-exclamation-circle" style="color: #DB0601;font-size: 32px;"></i>&nbsp Thông báo</h3>
            </div>
            <div class="modal-body">
                <p>Mã coupon không hợp lệ<br /> <b>Quý khách vui lòng thử lại</b></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng lại</button>
            </div>
        </div>
    </div>
</div>

<div id="address-modal" class="modal fade modal-captcha" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h3><i class="fa fa-map-marker"></i>&nbsp; Địa chỉ văn phòng VeXeRe trên Google Map</h3>
            </div>
            <div class="modal-body">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.5457919862806!2d106.6472753148007!3d10.76944599232626!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752e959cb6cc49%3A0xf982fadad6a45bd4!2zNzkvSTggw4J1IEPGoSwgcGjGsOG7nW5nIDE0LCBRdeG6rW4gMTEsIEjhu5MgQ2jDrSBNaW5oLCBWaWV0bmFt!5e0!3m2!1sen!2s!4v1447127794056" width="100%" height="450" frameborder="0" style="border:0"></iframe>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng lại</button>
            </div>
        </div>
    </div>
</div>

    <!-- >payment content -->
    <!-- >footer-->
    <footer>
   
</footer>
    <!-- /footer-->
    




<div class="vxr-loading-overlay">
    <div class="la-ball-spin-clockwise la-3x">
            <div></div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
        </div>
</div>

<div class="loader-container" style="text-align: center">
    <div class="loader" style="display: none; text-align: center;">
        <div class="circle"></div>
        <div class="circle"></div>
        <div class="circle"></div>
        <div class="circle"></div>
        <div class="circle"></div>
    </div>
</div>

<div class="route-loader-container" style="text-align: center">
    <div class="route-loader" style="display: none; text-align: center;">
        <div class="circle route-circle"></div>
        <div class="circle route-circle"></div>
        <div class="circle route-circle"></div>
        <div class="circle route-circle"></div>
        <div class="circle route-circle"></div>
    </div>
</div>








    <script src="https://vexere.com/Content/vxr/js/jquery-1.11.2.min.js"></script>
    <script src="https://vexere.com/Content/vxr/js/third-party/bootstrap/bootstrap.min.js"></script>

    <script src="https://vexere.com/Content/vxr/js/newlayout/popover.min.js"></script>
    <script src="https://vexere.com/Content/vxr/js/third-party/toastr/toastr.min.js"></script>
    <script type="text/javascript" src="https://vexere.com/vi-VN/Language/Data" charset="utf-8"></script>

    
    <link href="https://vexere.com/Content/vxr/css/third-party/select2/select2-payment.css" rel="stylesheet" />
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/vendors/jquery.fancybox.min.js"></script>
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/partials/helper1.0.min.js?v=45135"></script>
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/partials/validatePaymentForm1.0.js?v=45135"></script>
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/partials/loading1.0.min.js"></script>
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/vendors/jquery.MetaData.min.js"></script>
    <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=set_to_true_or_false"></script>
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/payment1.1.js?v=45135"></script>
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/common.js?v=45135"></script>
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/third-party/responsive-tab/responsive-tabs.min.js"></script>
    <script src="https://vexere.com/Content/vxr/js/third-party/moment/moment.js"></script>
    <script src="https://vexere.com/Content/vxr/js/third-party/count-down/jquery.countdownTimer.min.js"></script>
    <script type="text/javascript" src="https://vexere.com/Content/vxr/js/third-party/select2/select2.full.min.js"></script>    
    
    <script type="text/javascript" src="https://vexere.com/vi-VN/Language/Data" charset="utf-8"></script>


    <script type="text/javascript">
    $(document).ready(function () {

        toastr.options = {
            "closeButton": true,
            "debug": false,
            "newestOnTop": false,
            "progressBar": false,
            "positionClass": "toast-top-center",
            "preventDuplicates": true,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "10000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }

        if ('false' == 'true') {
            $(".coupon-row").hide()
        }

        var url = location.href.toLowerCase();

        if ('' != '1') {
            /*! Reloads on every visit in mobile safari */
            if ((/iphone|ipod|ipad.*os 5/gi).test(navigator.appVersion)) {
                window.onpageshow = function (evt) {
                    if (evt.persisted) {
                        if (sessionStorage.isCompletedPayment == "true") {
                            document.body.style.display = "none";
                            sessionStorage.isCompletedPayment = "false";
                            if (url.indexOf('en-us') > -1) {
                                window.location.href = "/en-US";
                            } else {
                                window.location.href = "/";
                            }
                        }
                        hideLoading();
                    }
                };
            }

            if (sessionStorage.isCompletedPayment == "true") {
                sessionStorage.isCompletedPayment = "false";
                if (url.indexOf('en-us') > -1) {
                    window.location.href = "/en-US";
                } else {
                    window.location.href = "/";
                }
            }
        }


        //var listFuckingCompIds = ['528', '536', '543', '544', '971', '1041', '1373', '11102', '11801', '12538', '12853', '12900', '17314', '11698', '11224'];
        var listCompanyNotApplyPayooOffer = [0, 0];
        var currentCompid = $("input[name='BookingDetailsVM.CompId']").val();


        

        if ($.inArray(parseInt(currentCompid), listCompanyNotApplyPayooOffer) >= 0) {
            $(".payoo-banner").hide();
            $(".receive-ticket").removeAttr("style");
            //var url = location.href.toLowerCase();
            if (url.indexOf('en-us') > -1) {
                $(".payoo-text").text("Pay at near by convenience stores");
                $(".payoo-text-mb").text("Pay at near by convenience stores");
            } else {
                $(".payoo-text").text("Thanh toán tiền mặt tại các cửa hàng tiện lợi và siêu thị gần địa chỉ của bạn");
                $(".payoo-text-mb").text("Cửa hàng gần nhà");
            }
            $(".payoo-title").css({ "color": "#333", "font-weight": "normal" });
        }

        $("body").removeAttr("style");

        var routeName = $('<textarea />').html('Đ&#224; Nẵng - Ninh Thuận').text(),
        brand = $('<textarea />').html('H&#224; Linh').text();
        registerProduct(routeName + ' - ' + '12/03/2017' + ' - ' + '17:00', '95189',
            '220000', brand, routeName, '17:00', '1');

        var language = "Tiếng Việt";
        if ('vi-vn' == 'en-us')
            language = "English";

        dataLayer.push({
            event: 'PageType',
            language: language,
            pagetype: "Thanh toán"
        });

        //nmthang - Check trang thai ve khi load page
        $.ajax({
            url: "/vi-VN/Payment/CheckTicketStatus",
            type: "post",
            data: { validate_code: '4d6508aa-8f8c-4172-ae7f-f22dfdcf2c1f' },
            success: function (response) {
                if (response.invalid) {
                    alert(Language["YourTicketsWereCanceledPleaseTryToBookAgain"]);
                    window.history.back();
                }
            }
        });

        $("a[data-toggle='collapse']").click(function () {
            var $this = $(this);
            $this.children("i").toggleClass('fa fa-angle-up fa fa-angle-down');
            $(".fa-angle-up").not($this.children()).removeClass('fa-angle-up').addClass('fa-angle-down');
            setTimeout(function () {
                $('html, body').animate({
                    scrollTop: $this.offset().top - 10
                }, 700);
            }, 500);
        });

        var jsonModel = '{"BuyerInfo":{"FullName":"Dang Van Hung","FirstName":null,"LastName":null,"IdNumber":null,"Email":"onlinevuive24h@gmail.com","ConfirmEmail":null,"PhoneNumber":"0964658984","Address":null,"PayooAddress":null,"State":null,"District":null,"StateName":null,"DistrictName":null,"ReceiveEmail":false,"Password":null,"ConfirmPassword":null,"CardName":null,"CardNumber":null,"CardMonth":null,"CardYear":null,"CardType":null,"AuthMethod":null},"PassengerVMs":null,"BookingDetailsVM":{"TicketStatus":0,"tripCode":"2b8c7f1794704e43e73643aaf9f8eb7ce1bee5ba6e04227883c4d4f515633416c1ec1ed3c31194f912808471d8f6b4e01ecdd857ec2717cd632fdc83707c99f3351c08a84024a63f1993bd428c63f149595016f0dc25f6effb440cbe9a8d616cc0e8dd62a6887ac618939c86ce30e8445622990eb9632444871c98d1b51984b5cdba7ade99586182b136406e82efc9e0235ec3d6ed79e4fe639be87cf58f5204efde30e6cd65447379bf9f1801ae988ed8c45585cab05d91a8dc609d07754edf93fade5f3e62cac1c5268bbac89f8d7aa9d964d3ba52f7182f5eff34633637d3ffc144f6f1bb658b2c0a59eea2f8","CouponCode":null,"CouponValue":null,"OperatorId":0,"OperatorName":"Hà Linh","OperatorPhone":null,"TripId":95189,"TripIdChild":0,"DraftId":null,"DraftBookingCode":null,"RouteId":0,"RouteType":0,"RouteName":"Đà Nẵng - Ninh Thuận","ScheduleId":0,"FromBusStopId":767,"FromBusStopName":"Đà Nẵng","FromBusStopAddress":"201 Tôn Đức Thắng, P. Hòa An - Thanh Khê - Đà Nẵng","ToBusStopId":67584,"ToBusStopName":"Nha Trang - Khánh Hòa","FromArea":"767|15|BXTTĐN|Bến Xe Trung Tâm Đà Nẵng","ToArea":"67584|16|NTG|Vp Nha Trang","CompId":582,"PassCode":0,"BookingCode":"4G049RJ","SDepartureTime":"12-03-2017-17-00-00","SDropOffTime":"03:30","DepartureTime":"\/Date(-62135596800000)\/","PickUpTime":"\/Date(-62135596800000)\/","PickUpDate":"17:00 12-03-2017","BoardingTime":null,"DropoffTime":"\/Date(1489251600000)\/","ReservationTime":"\/Date(-62135596800000)\/","ReservationTimeExpire":null,"ExpiredTime":"11:30 12-03-2017","SBookingSeats":"32-0-2-5-5-220000-","BookingSeats":{"32-2-5-5":{"SeatCode":"32","SeatNumber":0,"SeatFloor":2,"SeatRow":5,"SeatCol":5,"SeatFare":220000}},"FarePerPeople":220000,"OldFare":0,"OldTotalFare":0,"DiscountValue":0,"Deposit":0,"ExpectedTotalFare":220000,"TicketDeliveryFee":0,"Notice":null,"BookingStatusCode":null,"CancelFee":0,"PickUpPoint":null,"ScheduleDetailId":0,"IsRePayment":null,"CustomerFullName":"Dang Van Hung","CustomerID":null,"CustomerPhone":"0964658984","CustomerEmail":"onlinevuive24h@gmail.com","CustomerAddress":null,"HasTransfer":false,"TransferAddress":null,"FutaBankCode":null,"userAgent":null,"source":null,"headerReferer":null,"IsBookTempSeat":"NO","TicketCode":"C8R77K","ticketIds":"10011399","totalStage":4,"totalSeats":1,"fromStateId":15,"extraNote":null,"PickupId":null,"PickupName":null,"PickupIndex":null,"PickupTimeMinute":"0","PickupAddress":null,"PickupUnfixedAddress":null,"PickupUnFixedPoint":"0","PickupDepartTime":null,"TransferId":null,"TransferName":null,"TransferIndex":null,"TransferTime":"0","TransferUnfixedAddress":null,"TransferUnFixedPoint":"0","momoSecretKey":null,"momoProviderId":"vexere","momoBillId":"4G049RJ","momoTransactionId":"KW4462V","momoChecksum":"9A8E9E85E6B99601F53BCF2996D24C64","momoAppId":"com.mservice.com.vn.momotransfer","momoRedirect":"1","ipAdress":"10.0.0.3","isDraftBooking":null,"CountryCode":"VN","LanguageInfo":null,"ValidateCode":"4d6508aa-8f8c-4172-ae7f-f22dfdcf2c1f","Duration":"630","DepositSelling":0,"Refundable":1,"Unchoosable":0,"UnuseCancelTime":0,"HaveEating":0,"vxrMobileApp":"0","vxrMobileAppOS":null},"PaymentSystemType":null,"PaymentSupplierType":null,"PaymentMethod":null,"VxrPaymentInfo":null,"BankCode":null,"Payment123PayURL":null,"BankTransferCode":null,"BankId":null,"Captcha":null,"CaptchaHash":null,"PaymentToken":null,"TicketDelivery":null,"TransactionCode":null,"DepartureTicketCode":null,"ApiTicketCode":null,"ReturnTicketCode":null,"UserId":null,"IsCancelTicket":false,"Confirm":false,"IsBookTempSeat":null,"ScheduleDetailId":0,"TimeslotId":0,"WaitTicketNumber":0,"isRequestCheckout":null,"BannerVM":{"home_right_banner":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-NG4aJA3UtC.png","link":"https://vexere.com/vi-VN/ve-xe-khach-tu-sai-gon-di-ha-tien-kien-giang-129t23691.html#25012017","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-uxPBwo01Ip.png","link":"#","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-yd5jP75PjI.png","link":"https://vexere.com/vi-VN/ve-xe-khach-tu-ha-noi-di-sa-pa-lao-cai-124t24241.html","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-LGUUMcZc4y.jpg","link":"","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-h9fl6U6VPb.jpg","link":"","status":false}],"home_horizontal_banner":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-1RZHAr8ceM.png","link":"https://vexere.com/vi-VN/tin-tuc/nha-xe/valentine-ma-minh-thich-thi-minh-di-thoi-6477.html","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-Ce1zZy0Gac.png","link":"","status":false}],"route_banner":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-SaGfEpdgOh.png","link":"https://vexere.com/vi-VN/tin-tuc/nha-xe/valentine-ma-minh-thich-thi-minh-di-thoi-6477.html","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-lD35K7Mre8.png","link":"https://vexere.com/vi-VN/tin-tuc/nha-xe/book-bus-tickets-hanoi-sapa-only-8-at-vexere-com-6469.html","status":false}],"company_banner":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-9BF85bV9ND.png","link":"https://vexere.com/vexetet","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-HmF5yMJCLx.png","link":"https://vexere.com/vi-VN/ve-xe-khach-tu-sai-gon-di-tuy-hoa-phu-yen-129t25081.html#20012017-01540234","status":false}],"bus_stop_banner":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-gw4OvnnkR1.png","link":"https://vexere.com/vi-VN/ve-xe-khach-tu-sai-gon-di-tuy-hoa-phu-yen-129t25081.html#20012017-01540234","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-XaDoAKYBsr.png","link":"#","status":false}],"payment_banner":{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-LR7gs600cp.png","link":"https://vexere.com/vi-VN/tin-tuc/bang-tin-ve-tet-2017/50-000-ve-xe-tet-di-toan-quoc-se-duoc-mo-ban-ngay-12-12-duy-nhat-tai-vexere-com-6444.html","status":false},"popup_banner":{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-0q9qFv55Td.jpg","link":"#","status":false},"home_right_banner_mobile":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-4eg1XRdo81.png","link":"#","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-uHgxn2KAVq.jpg","link":"","status":false},{"src":"","link":"","status":false},{"src":"","link":"","status":false},{"src":"","link":"","status":false}],"home_horizontal_banner_mobile":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-31vAk4ZUpS.png","link":"https://vexere.com/vi-VN/tin-tuc/nha-xe/valentine-ma-minh-thich-thi-minh-di-thoi-6477.html","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-VZT2qmkZV6.png","link":"#","status":false}],"route_banner_mobile":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-nD1VMrVA5t.png","link":"https://vexere.com/vi-VN/tin-tuc/nha-xe/valentine-ma-minh-thich-thi-minh-di-thoi-6477.html","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-i4p541a471.png","link":"https://vexere.com/vi-VN/tin-tuc/nha-xe/ve-xe-ha-noi-sapa-chi-169k-duy-nhat-tai-vexere-com-6467.html","status":false}],"company_banner_mobile":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-jhIXJ204s3.png","link":"https://vexere.com/vexetet","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-MrBJheb4uH.png","link":"https://vexere.com/vi-VN/ve-xe-khach-tu-sai-gon-di-tuy-hoa-phu-yen-129t25081.html#20012017-01540234","status":false}],"bus_stop_banner_mobile":[{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-yy3LDBapZp.png","link":"https://vexere.com/vexetet","status":false},{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-ZERuG8jFki.png","link":"#","status":false}],"payment_banner_mobile":{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-LR7gs600cp.png","link":"https://vexere.com/vi-VN/tin-tuc/bang-tin-ve-tet-2017/50-000-ve-xe-tet-di-toan-quoc-se-duoc-mo-ban-ngay-12-12-duy-nhat-tai-vexere-com-6444.html","status":false},"popup_banner_mobile":{"src":"//static.vexere.com/c/i/69696969/banner-VeXeRe-KI6geBQrxy.jpg","link":"","status":false}},"UnuseCancelTime":0,"Partner":null,"vxrMobileApp":"0"}';
        jsonModel = jsonModel.toString();
        jsonModel = jsonModel.replace(/'/g, '');
        jsonModel = jsonModel.replace(/"/g, "'");
        var isMobile = false;
        if ($(window).width() < 768) {
            isMobile = true;
        }

        $(".text-edit").click(function () {
            $('.text-discount').remove();
            $('.text-old').removeClass('text-old').addClass('text-total-fare');
            $('.cod-total-fare').removeClass('text-total-fare');
            $('.coupon-row').removeAttr('style')
            $('#txtCheckRedeemCode').removeAttr('style')
            $('#btnCheckRedeemCode').removeAttr('style')
            if (isMobile) {
                $(".old-total-fare-row").hide();
                $(".coupon-result-row").hide();
            } else {
                $(".old-total-fare-row-lg").hide();
                $(".coupon-result-row-lg").hide();
            }

            var url = '/vi-VN/Payment/RemoveCouponCode';
            $.ajax({
                url: url,
                type: "post",
                data: { info: jsonModel },
                success: function (response) {
                    if (response.isValid == '1') {
                        if (response.visaUrl) {
                            var iframeEle = "<iframe id='visa123pay-iframe' class='visa-iframe' width='100%' height='805' scrolling='no'></iframe>";
                            $("#visa123pay-iframe").replaceWith(iframeEle);
                            $("#visa123pay-iframe").attr("src", response.visaUrl);
                            $("#visa123pay-iframe").load(function () { });
                        }
                        $("#applyCoupon").val('false');
                        $(".txtCouponCode").text("");
                        var totalFare = response.totalFare;
                        var codTotalFare = response.totalFare + Number($("#shippingFee").val());
                        $("#hidden-input-total-fare").val(totalFare);
                        $("#hidden-input-cod-total-fare").val(codTotalFare);
                        if ($("#cod-method").closest('.active').length == 1) {
                            $(".text-total-fare-col").text(codTotalFare + " VNĐ");
                        } else {
                            $(".text-total-fare-col").text(totalFare + " VNĐ");
                        }
                    } else if (response.isValid == '0') {

                    }
                },
                error: function () {
                    return false;
                }
            });
        })

        $(".redeemBtn").click(function () {

            var shippingFee = Number($("#shippingFee").val());
            var url = '/vi-VN/Payment/CheckRedeemCode';
            var coupon_value = "";
            if (!isMobile) {
                coupon_value = $("#txtCheckRedeemCode").val();
            } else {
                coupon_value = $(this).prev('input').val();
            }
            var $thisRedeemBtn = $(this);
            $thisRedeemBtn.prop('disabled', true);
            $thisRedeemBtn.html('<i class="fa fa-spinner fa-lg fa-spin"></i>');
            showLoading();
            $.ajax({
                url: url,
                type: "post",
                data: { info: jsonModel, code: coupon_value },
                success: function (response) {
                    hideLoading();
                    if (response.isValid == '0') {
                        $thisRedeemBtn.prop('disabled', false);
                        $thisRedeemBtn.html(Language["use"]);
                        $("#coupon-failed-modal").modal('show');
                    } else if (response.isValid == '1') {
                        if (response.url) {
                            window.location = response.url;
                        } else {
                            var couponValue = (response.couponValue).format(0, 3, '.', '.');
                            $("#couponValue").val(response.couponValue);
                            $("#applyCoupon").val('true');
                            //var oldTotalFare = $($(".text-total-fare-col")[0]).text();

                            if (response.visaUrl) {
                                var iframeEle = "<iframe id='visa123pay-iframe' class='visa-iframe' width='100%' height='805' scrolling='no'></iframe>";
                                $("#visa123pay-iframe").replaceWith(iframeEle);
                                $("#visa123pay-iframe").attr("src", response.visaUrl);
                                $("#visa123pay-iframe").load(function () { });
                            }
                            $("#momoFare").val(response.newTotalFare);
                            var newTotalFare = (response.newTotalFare).format(0, 3, '.', '.');
                            var newCODTotalFare = (response.newTotalFare + shippingFee).format(0, 3, '.', '.');
                            if (newTotalFare) {
                                $(".text-total-fare").after("</br><p class='text-discount'>" + newTotalFare + " VNĐ</p>");
                                $(".text-total-fare").removeClass('text-total-fare').addClass('text-old');
                                $(".text-old").parent('label').attr('style', 'vertical-align: top');
                                $(".txtOldTotalFare").text((response.originalTotalFare).format(0, 3, '.', '.') + "VNĐ");
                                $(".text-total-fare-col").text(newTotalFare + " VNĐ");
                                $("#hidden-input-total-fare").val(response.newTotalFare);

                                //For COD Payment
                                $(".cod-total-fare").after("</br><p class='text-discount'>" + newCODTotalFare + " VNĐ</p>");
                                $(".cod-total-fare").removeClass('text-total-fare').addClass('text-old');
                                $("#cod-total-fare").val(newCODTotalFare);
                                $("#hidden-input-cod-total-fare").val(response.newTotalFare + shippingFee);
                                if ($("#cod-method").closest('.active').length == 1) {
                                    $(".text-total-fare-col").text(newCODTotalFare + " VNĐ");
                                }

                                $(".coupon-row").attr('style', 'display:none !important');
                                $("#txtCheckRedeemCode").hide();
                                $thisRedeemBtn.prop('disabled', false);
                                $thisRedeemBtn.html(Language["use"]);
                                $("#btnCheckRedeemCode").hide();
                                if (isMobile) {
                                    $(".old-total-fare-row").fadeIn();
                                    $(".coupon-result-row").fadeIn();
                                } else {
                                    $(".old-total-fare-row-lg").fadeIn();
                                    $(".coupon-result-row-lg").fadeIn();
                                }
                                $(".txtCouponCode").text(response.couponCode).fadeIn();
                                $(".txtCouponValue").text("-" + couponValue + "VNĐ").fadeIn();
                            }
                        }
                    }
                },
                error: function () {
                    return false;
                }
            });
        });

        $("#districtSelection2").change(function () {
            var district_id = this.value.split('~')[0];
            $.ajax({
                url: "/vi-VN/Payment/GetShippingFee",
                type: "post",
                data: { district_id: district_id },
                success: function (response) {
                    if (response.isOk == "1") {
                        $("#shippingFee").val(response.fee);
                        var shippingFee = Number($("#shippingFee").val()).format(0, 3, '.', '.');
                        var totalCodFare = Number($("#hidden-input-total-fare").val()) + Number($("#shippingFee").val());

                        $(".shipping-fee").text(shippingFee)
                        $(".shipping-fee-row").fadeIn();
                        $(".shipping-fee-dv").fadeIn();

                        if ($("#couponValue").val() != "") {
                            var oldTotalCodFare = Number($("#hidden-input-total-fare").val()) + Number($("#couponValue").val()) + Number($("#shippingFee").val());
                            $(".cod-total-fare").text(oldTotalCodFare.format(0, 3, '.', '.') + " VNĐ")
                            $(".cod-total-fare").parent().children(".text-discount").text(totalCodFare.format(0, 3, '.', '.') + " VNĐ");
                            $(".text-total-fare-col").text(totalCodFare.format(0, 3, '.', '.') + " VNĐ");
                            $("#hidden-input-cod-total-fare").val(totalCodFare);
                        } else {
                            $(".cod-total-fare").text(totalCodFare.format(0, 3, '.', '.') + " VNĐ");
                            $(".text-total-fare-col").text(totalCodFare.format(0, 3, '.', '.') + " VNĐ");
                        }

                    } else {
                        console.log(response.message);
                    }
                },
                error: function () { }
            });
        });

        //Set validateCode
        sessionStorage["validateCode"] = '4d6508aa-8f8c-4172-ae7f-f22dfdcf2c1f';
        sessionStorage["backFromPaymentPage"] = 'true';

        //Lay thoi gian dem nguoc tu session

        var dt = '';
        if (sessionStorage["enddate"]) {
            dt = sessionStorage["enddate"];
        } else {
            var curDate = new Date();
            curDate.setMinutes(curDate.getMinutes() + 10);
            //dt = curDate.toLocaleDateString() + " " + curDate.toLocaleTimeString();
            dt = moment(curDate).format('MM/DD/YYYY HH:mm:ss');
            sessionStorage["enddate"] = dt;
        }

        var dateAr = dt.split('/');
        //var newDate = dateAr[1] + '/' + dateAr[0] + '/' + dateAr[2];

        //var end = new Date(dateAr[1] + '/' + dateAr[0] + '/' + dateAr[2]);
        var end = new Date(dt);

        var _second = 1000;
        var _minute = _second * 60;
        var _hour = _minute * 60;
        var _day = _hour * 24;

        var now = new Date();

        if (end > now) {
            var distance = end - now;
            var minutes = Math.floor((distance % _hour) / _minute);
            var seconds = Math.floor((distance % _minute) / _second);
            //$('.clock-minute').text(minutes);
            //$('.clock-second').text(seconds);

            $('.text-time-left').countdowntimer({
                minutes: minutes,
                seconds: seconds,
                tickInterval: 1,
                timeSeparator: ":",
                timeUp: timeisUp
            });
        } else {
            $('.text-time-left').countdowntimer({
                minutes: 0,
                seconds: 0,
                tickInterval: 1,
                timeSeparator: ":",
                timeUp: timeisUp
            });
        }
    });

    $(".btn-momo").click(function () {
        thanhtoan();
    });

    $(".btn-momoweb").click(function () {
        window.parent.postMessage(
            {
                tid: '4G049RJ',
                maDichVu: 'vexere',
                maKhachHang: '',
                trangThaiGiaoDich: '',
                tenKhachHang: 'Dang Van Hung',
                soDienThoaiKH: '0964658984',
                tienVe: '220000',
                soLuongGhe: '1',
                tenGhe: '32',
                nhaXe: 'H&#224; Linh',
                tuyenDi: 'Đ&#224; Nẵng',
                tuyenDen: 'Nha Trang - Kh&#225;nh H&#242;a',
                thoiGianDi_Nam: '2017',
                thoiGianDi_Thang: '03',
                thoiGianDi_Ngay: '12',
                thoiGianDi_Gio: '17',
                thoiGianDi_Phut: '00',
                thoiGianDen_Nam: '2017',
                thoiGianDen_Thang: '3',
                thoiGianDen_Ngay: '13',
                thoiGianDen_Gio: '03',
                thoiGianDen_Phut: '30',
                ghiChu: ''
            }, 'https://vexere.com'
        );
    });

    function timeisUp() {
        jQuery('div#errorMessage div.message-content p').html('<em>Quá trình thanh toán của bạn đã thực hiện quá 10 phút. Nhấn vào <a href="javascript:history.back();">đây</a> để trở về trang chủ, hệ thống sẽ tự chuyển về trang đặt vé sau 5 giây</em>')
        jQuery('form#frmBookingDetail').hide();
        jQuery('div#errorMessage').show();

        setTimeout(function () {
            if (window.history.length > 5) {
                VxrGoBack();
            } else {
                var url = location.href.toLowerCase();
                if (url.indexOf('en-us') > -1) {
                    window.location = "/en-US"
                } else {
                    window.location = "/"
                }
            }
        }, 1000);
    }

    var tabsFn = (function () {

        function init() {
            setHeight();
        }

        function setHeight() {
            var $tabPane = $('.tab-pane'),
                tabsHeight = $('.nav-tabs').height();

            $tabPane.css({
                height: tabsHeight
            });
        }

        $(init);
    })();

    function getMobileOperatingSystem() {

        var userAgent = navigator.userAgent || navigator.vendor || window.opera;
        if (userAgent.match(/iPad/i) || userAgent.match(/iPhone/i) ||
            userAgent.match(/iPod/i)) {
            return 'iOS';
        } else if (userAgent.match(/Android/i)) {
            return 'Android';
        } else {
            return 'unknown';
        }
    }

    function thanhtoan() {

        var mobileOS = getMobileOperatingSystem();
        var seat = '32';
        var qty = '1';
        var payreference = {
            "billid": "4G049RJ",
            "amt": $("#momoFare").val(),
            "html": "<table style='width: 100%'><tr><td>Nhà xe:</td><td style='text-align: right;'>H&#224; Linh</td></tr><tr><td>Tuyến đường:</td><td style='text-align: right;'>Đ&#224; Nẵng - Ninh Thuận</td></tr><tr><td>Thời gian:</td><td style='text-align: right;'>17:00 - 03:30</td></tr><tr><td>Mã ghế:</td><td style='text-align: right;'>" + seat + "</td></tr><tr><td>Số lượng ghế:</td><td style='text-align: right;'>" + qty + "</td></tr><tr><td>Mã đặt chỗ:</td><td style='text-align: right;'>4G049RJ</td><tr><td>Số tiền:</td><td style='text-align: right;'>220.000 đ</td></tr></table>"
        };
        

        if (mobileOS == 'iOS') {
            openIOS(JSON.stringify(payreference));
        } else {
            open_app_android(JSON.stringify(payreference));
        }
    }

    function open_app_android(payReference) {
        Android.sendOrderToMoMo('KW4462V', 'vexere', '4G049RJ', $("#momoFare").val(), payReference, 'test', '1');
    }

    function openIOS(payReference) {
        window.location = 'com.mservice.com.vn.momotransfer' + "?transactionId=" + 'KW4462V' + "&providerId=" + 'vexere' + "&customerCode=" + '4G049RJ' + "&amount=" + $("#momoFare").val() + "&description=" + 'test' + "&appSource=" + "&reference=" + payReference + "&clientIP=" + '10.0.0.3' + "&checkSum=" + '9A8E9E85E6B99601F53BCF2996D24C64' + "&redirect=" + '1';

    }

    function matchStart(term, text) {
        if (locdau(text).toUpperCase().indexOf(locdau(term).toUpperCase()) == 0) {
            return true;
        }
        return false;
    }

    function locdau(str) {
        str = str.toLowerCase();
        str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
        str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
        str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
        str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
        str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
        str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
        str = str.replace(/đ/g, "d");
        str = str.replace(/!|%|\^|\*|\(|\)|\+|\=|\<|\>|\?|\/|,|\.|\:|\;|\'| |\"|\&|\#|\[|\]|~|$|_/g, "-");
        /* tìm và thay thế các kí tự đặc biệt trong chuỗi sang kí tự - */
        str = str.replace(/-+-/g, "-"); //thay thế 2- thành 1-
        str = str.replace(/^\-+|\-+$/g, "");
        //cắt bỏ ký tự - ở đầu và cuối chuỗi
        return str;
    }

    $(function () {
        $.ajax({
            url: "/vi-VN/Support/GetListBank",
            type: "get",
            success: function (res) {
                if (res.success) {
                    for (var i = 0 ; i < res.result.length ; i++) {
                        var optionEle = "<option value='" + res.result[i].code + "'>" + Language[res.result[i].code + "_BankName"] + '</option>';
                        $("#bankSelection").append(optionEle);
                    }
                    var transferBankSelected = $('#transferBankSelected').val();
                    if (transferBankSelected != null && transferBankSelected != '') {
                        $("#bankSelection").val(transferBankSelected);
                        $("#bankSelection").trigger('change');
                    }

                }
            }
        })

        //<option value="ARGI">Ngân hàng Agribank </option>
        //$('#accordion123').collapse();

        //Khởi tạo trang thanh toán
        initPaymentPage();
        $('#frmBookingDetail input[type=text]').first().focus();

        //Khoi tao danh sach city, province
        initPaymenGetCashMethod();
        initPaymenGetCashMethod(true);

        //Khoi tao hinh thuc chuyen khoan
        initPaymentBankMethod();

        //Khoi tao hinh thuc DGD
        initPaymentPayooMethod();

        //Get previous ATM
        var atmBankSelected = $('#atmBankSelected').val()
        if (atmBankSelected != null && atmBankSelected != '') {
            $('#bankSelect').val(atmBankSelected);
            $('#bankSelect').trigger('change')
        }

        var paymentMethodPrevious = $('#paymentMethodPrevious').val()
        if (paymentMethodPrevious == 'PAYOO') {
            $("a[aria-controls='payment-diemgiaodich']").trigger('click')
        } else if (paymentMethodPrevious == 'VISA') {
            $("a[aria-controls='payment-visa']").trigger('click')
        } else if (paymentMethodPrevious == 'ATM') {
            $("a[aria-controls='payment-atm']").trigger('click')
        } else if (paymentMethodPrevious == 'CSH') {
            $("a[aria-controls='payment-chuyenkhoan']").trigger('click')
        } else if (paymentMethodPrevious == 'VO') {
            $("a[aria-controls='payment-tienmat']").trigger('click')
        }
    });

    $.fn.select2.amd.require(['select2/compat/matcher'], function (oldMatcher) {
        $("#state-select").select2({
            "language": {
                "noResults": function () {
                    return Language["NoResultsFound"];
                }
            },
            matcher: oldMatcher(matchStart)
        }),
        $("#district-select").select2({
            "language": {
                "noResults": function () {
                    return Language["NoResultsFound"];
                }
            },
            matcher: oldMatcher(matchStart)
        })
    });

    $('#state-select').select2();
    $('#district-select').select2();
    var isApply123PayDiscount = false;
    setTimeout(function () {
        $('#state-select').val($('#payooState').val())
        if ($('#payooState').val())
            $('#state-select').trigger('change')
        $('#district-select').val($('#payooDistrict').val())
        if ($('#payooDistrict').val())
            $('#district-select').trigger('change')

        if ($('#state-select').val()
            && $('#district-select').val()
            && $('#AddressPayoo').val()
            && $('#payooDistrict').val()) {
            //console.log('trigger click')
            if ($(window).width() >= 992) {
                $('#address-payoo-select').trigger('click');
            } else {
                $(".btn-get-store").trigger('click');
            }
            
        }
    }, 1000)
    

    </script>
        <script>
            sessionStorage["inSession"] = 'true';
        </script>


    <script>
        $("body").removeAttr("style");
    </script>

    
</body>
</html>
