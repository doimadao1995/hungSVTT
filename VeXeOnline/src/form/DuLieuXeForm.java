package form;

import java.util.ArrayList;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import model.bean.DuLieuXe;

public class DuLieuXeForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String maDuLieuXe;
	private String maLichXe;
	private Date ngayDi;
	private int soChoConLai;
	private String maLichTrinh;
	private String diemDi;
	private String diemDen;
	private String gioXuatPhat;
	private String maXe;

	private String tuKhoa;
	private String action;
	private String submit;

	private ArrayList<DuLieuXe> listDuLieuXe;
	private DuLieuXe duLieuXe;

	public String getMaDuLieuXe() {
		return maDuLieuXe;
	}

	public void setMaDuLieuXe(String maDuLieuXe) {
		this.maDuLieuXe = maDuLieuXe;
	}

	public String getMaLichXe() {
		return maLichXe;
	}

	public void setMaLichXe(String maLichXe) {
		this.maLichXe = maLichXe;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public int getSoChoConLai() {
		return soChoConLai;
	}

	public void setSoChoConLai(int soChoConLai) {
		this.soChoConLai = soChoConLai;
	}

	public String getMaLichTrinh() {
		return maLichTrinh;
	}

	public void setMaLichTrinh(String maLichTrinh) {
		this.maLichTrinh = maLichTrinh;
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

	public String getGioXuatPhat() {
		return gioXuatPhat;
	}

	public void setGioXuatPhat(String gioXuatPhat) {
		this.gioXuatPhat = gioXuatPhat;
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) {
		this.maXe = maXe;
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

	public ArrayList<DuLieuXe> getListDuLieuXe() {
		return listDuLieuXe;
	}

	public void setListDuLieuXe(ArrayList<DuLieuXe> listDuLieuXe) {
		this.listDuLieuXe = listDuLieuXe;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public DuLieuXe getDuLieuXe() {
		return duLieuXe;
	}

	public void setDuLieuXe(DuLieuXe duLieuXe) {
		this.duLieuXe = duLieuXe;
	}

}
