package model.bean;

import java.util.Date;

public class VeXe {

	private String maVeXe;
	private String maLichXe;
	private String maAccount;
	private Date ngayDatVe;
	private Date ngayDi;
	private String diemDonKhach;
	private String diemTraKhach;
	private int soLuongVe;
	private double tongTien;
	private String tongTienString;
	private String tinhTrangThanhToan;

	public String getTongTienString() {
		return tongTienString;
	}

	public void setTongTienString(String tongTienString) {
		this.tongTienString = tongTienString;
	}

	public String getMaVeXe() {
		return maVeXe;
	}

	public void setMaVeXe(String maVeXe) {
		this.maVeXe = maVeXe;
	}

	public String getMaLichXe() {
		return maLichXe;
	}

	public void setMaLichXe(String maLichXe) {
		this.maLichXe = maLichXe;
	}

	public String getMaAccount() {
		return maAccount;
	}

	public void setMaAccount(String maAccount) {
		this.maAccount = maAccount;
	}

	public Date getNgayDatVe() {
		return ngayDatVe;
	}

	public void setNgayDatVe(Date ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
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

	public int getSoLuongVe() {
		return soLuongVe;
	}

	public void setSoLuongVe(int soLuongVe) {
		this.soLuongVe = soLuongVe;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getTinhTrangThanhToan() {
		return tinhTrangThanhToan;
	}

	public void setTinhTrangThanhToan(String tinhTrangThanhToan) {
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}

}
