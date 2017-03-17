package form;

import org.apache.struts.action.ActionForm;

public class VeXeForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String diemDi;
	private String diemDen;
	private String ngayDi;
	private String soLuongVe;
	private float giaVe;
	private String giaVeString;
	private double tongTien;
	private String gioXuatPhat;
	private String diemDonKhach;
	private String diemTraKhach;

	public String getDiemDi() {
		return diemDi;
	}

	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}

	public String getDiemDen() {
		return diemDen;
	}

	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}

	public String getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getSoLuongVe() {
		return soLuongVe;
	}

	public void setSoLuongVe(String soLuongVe) {
		this.soLuongVe = soLuongVe;
	}

	public float getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(float giaVe) {
		this.giaVe = giaVe;
	}

	public String getGiaVeString() {
		return giaVeString;
	}

	public void setGiaVeString(String giaVeString) {
		this.giaVeString = giaVeString;
	}

	public String getGioXuatPhat() {
		return gioXuatPhat;
	}

	public void setGioXuatPhat(String gioXuatPhat) {
		this.gioXuatPhat = gioXuatPhat;
	}

	public String getDiemDonKhach() {
		return diemDonKhach;
	}

	public void setDiemDonKhach(String diemDonKhach) {
		this.diemDonKhach = diemDonKhach;
	}

	public String getDiemTraKhach() {
		return diemTraKhach;
	}

	public void setDiemTraKhach(String diemTraKhach) {
		this.diemTraKhach = diemTraKhach;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

}
