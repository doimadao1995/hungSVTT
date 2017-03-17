package model.bo;

import java.util.ArrayList;

import model.bean.GiaVe;
import model.dao.GiaVeDAO;

public class GiaVeBO {

	GiaVeDAO giaVeDAO = new GiaVeDAO();

	/**
	 * hàm lấy giá vé theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public float getGiaVe(String maLichTrinh) {
		return giaVeDAO.getGiaVe(maLichTrinh);
	}

	/**
	 * lấy danh sách giá vé
	 * 
	 * @return
	 */
	public ArrayList<GiaVe> getListGiaVe() {
		return giaVeDAO.getListGiaVe();
	}

}
