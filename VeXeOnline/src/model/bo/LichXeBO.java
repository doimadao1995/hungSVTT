package model.bo;

import java.util.ArrayList;

import model.bean.GioXuatPhat;
import model.dao.LichXeDAO;

public class LichXeBO {

	LichXeDAO lichXeDAO = new LichXeDAO();

	/**
	 * hàm lấy danh sách giờ xuất phát theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public ArrayList<GioXuatPhat> getListGioXuatPhat(String maLichTrinh) {
		return lichXeDAO.getListGioXuatPhat(maLichTrinh);
	}
}
