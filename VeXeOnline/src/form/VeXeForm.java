package form;

import java.util.ArrayList;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import model.bean.VeXe;

public class VeXeForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String maVeXe;
	private String maLichXe;
	private String maAccount;
	private Date ngayDatVe;
	private Date ngayDi;
	private String diemDonKhach;
	private String diemTraKhach;
	private String soLuongVe;
	private String tongTien;
	private String tongTienString;
	private String tinhTrangThanhToan;
	private String diemDi;
	private String diemDen;
	private String giaVe;
	private String giaVeString;
	private String gioXuatPhat;
	private String tuKhoa;
	private String action;
	private String submit;
	private String thongBaoTimKiem;
	private ArrayList<VeXe> listVeXe;

	public String getThongBaoTimKiem() {
		return thongBaoTimKiem;
	}

	public void setThongBaoTimKiem(String thongBaoTimKiem) {
		this.thongBaoTimKiem = thongBaoTimKiem;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public ArrayList<VeXe> getListVeXe() {
		return listVeXe;
	}

	public void setListVeXe(ArrayList<VeXe> listVeXe) {
		this.listVeXe = listVeXe;
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

	public String getSoLuongVe() {
		return soLuongVe;
	}

	public void setSoLuongVe(String soLuongVe) {
		this.soLuongVe = soLuongVe;
	}

	public String getTongTien() {
		return tongTien;
	}

	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	public String getTongTienString() {
		return tongTienString;
	}

	public void setTongTienString(String tongTienString) {
		this.tongTienString = tongTienString;
	}

	public String getTinhTrangThanhToan() {
		return tinhTrangThanhToan;
	}

	public void setTinhTrangThanhToan(String tinhTrangThanhToan) {
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}

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

	public String getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(String giaVe) {
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

}
