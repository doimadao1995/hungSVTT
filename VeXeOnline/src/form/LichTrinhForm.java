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
	private String loaiXe;
	private String gioXuatPhat;
	private String giaVeString;

	private String tuKhoa;
	private String action;
	private String submit;
	private LichTrinh lichTrinh;
	private ArrayList<GiaVe> listGiaVe;
	private ArrayList<LichTrinh> listLichTrinh;

	private ArrayList<LichTrinh> listLTDaNang;
	private ArrayList<LichTrinh> listLTQuyNhon;
	private ArrayList<LichTrinh> listLTHaNoi;
	private ArrayList<LichTrinh> listLTNhaTrang;
	private ArrayList<LichTrinh> listLTDaLat;
	private ArrayList<LichTrinh> listLTSaiGon;

	public ArrayList<LichTrinh> getListLTDaNang() {
		return listLTDaNang;
	}

	public void setListLTDaNang(ArrayList<LichTrinh> listLTDaNang) {
		this.listLTDaNang = listLTDaNang;
	}

	public ArrayList<LichTrinh> getListLTQuyNhon() {
		return listLTQuyNhon;
	}

	public void setListLTQuyNhon(ArrayList<LichTrinh> listLTQuyNhon) {
		this.listLTQuyNhon = listLTQuyNhon;
	}

	public ArrayList<LichTrinh> getListLTHaNoi() {
		return listLTHaNoi;
	}

	public void setListLTHaNoi(ArrayList<LichTrinh> listLTHaNoi) {
		this.listLTHaNoi = listLTHaNoi;
	}

	public ArrayList<LichTrinh> getListLTNhaTrang() {
		return listLTNhaTrang;
	}

	public void setListLTNhaTrang(ArrayList<LichTrinh> listLTNhaTrang) {
		this.listLTNhaTrang = listLTNhaTrang;
	}

	public ArrayList<LichTrinh> getListLTDaLat() {
		return listLTDaLat;
	}

	public void setListLTDaLat(ArrayList<LichTrinh> listLTDaLat) {
		this.listLTDaLat = listLTDaLat;
	}

	public ArrayList<LichTrinh> getListLTSaiGon() {
		return listLTSaiGon;
	}

	public void setListLTSaiGon(ArrayList<LichTrinh> listLTSaiGon) {
		this.listLTSaiGon = listLTSaiGon;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public String getGioXuatPhat() {
		return gioXuatPhat;
	}

	public void setGioXuatPhat(String gioXuatPhat) {
		this.gioXuatPhat = gioXuatPhat;
	}

	public String getGiaVeString() {
		return giaVeString;
	}

	public void setGiaVeString(String giaVeString) {
		this.giaVeString = giaVeString;
	}

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
