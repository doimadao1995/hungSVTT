package model.bean;

public class ThongTinVe {

	private String diemDi;
	private String diemDen;
	private String ngayDi;
	private int soLuongVe;

	public ThongTinVe() {
		super();
	}

	public ThongTinVe(String diemDi, String diemDen, String ngayDi, int soLuongVe) {
		super();
		this.diemDi = diemDi;
		this.diemDen = diemDen;
		this.ngayDi = ngayDi;
		this.soLuongVe = soLuongVe;
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

	public String getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}

	public int getSoLuongVe() {
		return soLuongVe;
	}

	public void setSoLuongVe(int soLuongVe) {
		this.soLuongVe = soLuongVe;
	}

}
