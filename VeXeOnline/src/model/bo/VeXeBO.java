package model.bo;

import java.util.ArrayList;

import model.bean.VeXe;
import model.dao.VeXeDAO;

public class VeXeBO {

	VeXeDAO veXeDAO = new VeXeDAO();

	/**
	 * hàm lấy danh sách vé xe ( chi tiết đơn hàng)
	 * 
	 * @return
	 */
	public ArrayList<VeXe> getListVeXe() {
		return veXeDAO.getListVeXe();
	}

	/**
	 * hàm update xác nhận thanh toán cho vé xe
	 * 
	 * @param maVeXe
	 * @return
	 */
	public boolean updateXacNhanTT(String maVeXe) {
		return veXeDAO.updateXacNhanTT(maVeXe);
	}

	/**
	 * hàm xóa vé xe theo mã vé xe
	 * 
	 * @param maVeXe
	 * @return
	 */
	public boolean xoaVeXe(String maVeXe) {
		return veXeDAO.xoaVeXe(maVeXe);
	}

	/**
	 * hàm xóa tất cả vé xe chưa thanh toán
	 * 
	 * @return
	 */
	public boolean xoaAllVeXeChuaTT() {
		return veXeDAO.xoaAllVeXeChuaTT();
	}

	/**
	 * hàm tìm kiếm vé xe theo từ khóa nhập vào
	 * 
	 * @param tuKhoa
	 * @return
	 */
	public ArrayList<VeXe> getTimKiemVeXe(String tuKhoa) {
		return veXeDAO.getTimKiemVeXe(tuKhoa);
	}
}
