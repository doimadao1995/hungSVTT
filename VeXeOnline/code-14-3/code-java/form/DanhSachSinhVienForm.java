package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Khoa;
import model.bean.SinhVien;

public class DanhSachSinhVienForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKhoa;
	private String tuKhoa;
	private int page;
	private int totalPage;
	private ArrayList<Khoa> listKhoa;
	private ArrayList<SinhVien> listSinhVien;

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public ArrayList<Khoa> getListKhoa() {
		return listKhoa;
	}

	public void setListKhoa(ArrayList<Khoa> listKhoa) {
		this.listKhoa = listKhoa;
	}

	public ArrayList<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
