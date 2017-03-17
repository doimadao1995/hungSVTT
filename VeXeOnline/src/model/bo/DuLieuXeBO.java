package model.bo;

import java.util.ArrayList;

import model.bean.DuLieuXe;
import model.dao.DuLieuXeDAO;

public class DuLieuXeBO {

	DuLieuXeDAO duLieuXeDAO = new DuLieuXeDAO();

	/**
	 * hàm lấy danh sách dữ liệu xe
	 * 
	 * @return
	 */
	public ArrayList<DuLieuXe> getListDuLieuXe() {
		return duLieuXeDAO.getListDuLieuXe();
	}

	/**
	 * hàm kiểm tra số lượng vé khách hàng mua có còn k
	 * 
	 * @param maLichTrinh
	 * @param ngayDi
	 * @param soLuongVe
	 * @return
	 */
	public boolean checkSoLuongVe(String maLichTrinh, String ngayDi, int soLuongVe) {
		return duLieuXeDAO.checkSoLuongVe(maLichTrinh, ngayDi, soLuongVe);
	}
}
