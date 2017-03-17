package model.bo;

import java.util.ArrayList;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

public class SinhVienBO {
	SinhVienDAO sinhVienDAO = new SinhVienDAO();

	public ArrayList<SinhVien> getListSinhVien() {
		return sinhVienDAO.getListSinhVien();
	}

	public ArrayList<SinhVien> getListSinhVien(String maKhoa) {
		return sinhVienDAO.getListSinhVien(maKhoa);
	}

	public void themSinhVien(String msv, String hoTen, String gioiTinh, String maKhoa, String diaChi) {
		sinhVienDAO.themSinhVien(msv, hoTen, gioiTinh, maKhoa, diaChi);
	}

	public SinhVien getThongTinSinhVien(String msv) {
		return sinhVienDAO.getThongTinSinhVien(msv);
	}

	public void suaSinhVien(String msv, String hoTen, String gioiTinh, String maKhoa, String diaChi) {
		sinhVienDAO.suaSinhVien(msv, hoTen, gioiTinh, maKhoa, diaChi);
	}

	public void xoaSinhVien(String msv) {
		sinhVienDAO.xoaSinhVien(msv);
	}

	public ArrayList<SinhVien> getTimKiemListSinhVien(int page) {
		return sinhVienDAO.getTimKiemListSinhVien(page);
	}

	public ArrayList<SinhVien> getTimKiemListSinhVien(String tuKhoa, int page) {
		return sinhVienDAO.getTimKiemListSinhVien(tuKhoa, page);
	}

}
