package model.bo;

import java.util.ArrayList;

import model.bean.LichTrinh;
import model.dao.LichTrinhDAO;

public class LichTrinhBO {

	LichTrinhDAO lichTrinhDAO = new LichTrinhDAO();

	/**
	 * hàm lấy danh sách tất cả lịch trình
	 * 
	 * @return
	 */
	public ArrayList<LichTrinh> getListLichTrinh() {
		return lichTrinhDAO.getListLichTrinh();
	}

	/**
	 * hàm lấy danh sách lịch trình theo điểm xuất phát
	 * 
	 * @param subMaLichTrinh
	 * @return
	 */
	public ArrayList<LichTrinh> getSubListLichTrinh(String subMaLichTrinh) {
		return lichTrinhDAO.getSubListLichTrinh(subMaLichTrinh);
	}

	/**
	 * hàm thêm lịch trình
	 * 
	 * @param maLichTrinh
	 * @param diemDi
	 * @param diemDen
	 * @param maGiaVe
	 * @param thoiGianChay
	 * @param quangDuong
	 * @return
	 */
	public boolean themLichTrinh(String maLichTrinh, String diemDi, String diemDen, String maGiaVe, String thoiGianChay,
			String quangDuong) {
		return lichTrinhDAO.themLichTrinh(maLichTrinh, diemDi, diemDen, maGiaVe, thoiGianChay, quangDuong);
	}

	/**
	 * hàm chỉnh sửa lịch trình
	 * 
	 * @param maLichTrinh
	 * @param diemDi
	 * @param diemDen
	 * @param maGiaVe
	 * @param thoiGianChay
	 * @param quangDuong
	 * @param i
	 * @return
	 */
	public boolean suaLichTrinh(String maLichTrinh, String diemDi, String diemDen, String maGiaVe, String thoiGianChay,
			String quangDuong, int i) {
		return lichTrinhDAO.suaLichTrinh(maLichTrinh, diemDi, diemDen, maGiaVe, thoiGianChay, quangDuong, i);
	}

	/**
	 * hàm xóa lịch trình theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public boolean xoaLichTrinh(String maLichTrinh) {
		return lichTrinhDAO.xoaLichTrinh(maLichTrinh);
	}

	/**
	 * hàm kiểm tra có tồn tại lịch trình hay không?
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public boolean checkLichTrinh(String maLichTrinh) {
		return lichTrinhDAO.checkLichTrinh(maLichTrinh);
	}

	/**
	 * hàm lấy lịch trình theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public LichTrinh getLichTrinh(String maLichTrinh) {
		return lichTrinhDAO.getLichTrinh(maLichTrinh);
	}

	/**
	 * hàm lấy mã lịch trình theo điểm đi và điểm đến
	 * 
	 * @param diemDi
	 * @param diemDen
	 * @return
	 */
	public String getMaLichTrinh(String diemDi, String diemDen) {
		return lichTrinhDAO.getMaLichTrinh(diemDi, diemDen);
	}
}
