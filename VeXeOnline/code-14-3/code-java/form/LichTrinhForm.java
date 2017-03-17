package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.GiaVe;
import model.bean.LichTrinh;

public class LichTrinhForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maLichTrinh;
	private String diemDi;
	private String diemDen;
	private String maGiaVe;
	private String thoiGianChay;
	private String quangDuong;
	private String tuKhoa;
	private String action;
	private ArrayList<GiaVe> listGiaVe;
	private String submit;
	private LichTrinh lichTrinh;
	private ArrayList<LichTrinh> listLichTrinh;

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
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

	public String getMaGiaVe() {
		return maGiaVe;
	}

	public void setMaGiaVe(String maGiaVe) {
		this.maGiaVe = maGiaVe;
	}

	public String getThoiGianChay() {
		return thoiGianChay;
	}

	public void setThoiGianChay(String thoiGianChay) {
		this.thoiGianChay = thoiGianChay;
	}

	public String getQuangDuong() {
		return quangDuong;
	}

	public void setQuangDuong(String quangDuong) {
		this.quangDuong = quangDuong;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public ArrayList<GiaVe> getListGiaVe() {
		return listGiaVe;
	}

	public void setListGiaVe(ArrayList<GiaVe> listGiaVe) {
		this.listGiaVe = listGiaVe;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public LichTrinh getLichTrinh() {
		return lichTrinh;
	}

	public void setLichTrinh(LichTrinh lichTrinh) {
		this.lichTrinh = lichTrinh;
	}

	public ArrayList<LichTrinh> getListLichTrinh() {
		return listLichTrinh;
	}

	public void setListLichTrinh(ArrayList<LichTrinh> listLichTrinh) {
		this.listLichTrinh = listLichTrinh;
	}

}
