package model.bo;

import java.util.ArrayList;

import model.bean.DiemTraKhach;
import model.dao.DiemTraKhachDAO;

public class DiemTraKhachBO {

	DiemTraKhachDAO diemTraKhachDAO = new DiemTraKhachDAO();

	/**
	 * hàm lấy danh sách điểm trả khách theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public ArrayList<DiemTraKhach> getListDiemTraKhach(String maLichTrinh) {
		return diemTraKhachDAO.getListDiemTraKhach(maLichTrinh);
	}
}
