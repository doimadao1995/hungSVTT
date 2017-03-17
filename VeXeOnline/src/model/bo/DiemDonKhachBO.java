package model.bo;

import java.util.ArrayList;

import model.bean.DiemDonKhach;
import model.dao.DiemDonKhachDAO;

public class DiemDonKhachBO {

	DiemDonKhachDAO diemDonKhachDAO = new DiemDonKhachDAO();

	/**
	 * hàm lấy danh sách điểm đón khách theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public ArrayList<DiemDonKhach> getListDiemDonKhach(String maLichTrinh) {
		return diemDonKhachDAO.getListDiemDonKhach(maLichTrinh);
	}

}
