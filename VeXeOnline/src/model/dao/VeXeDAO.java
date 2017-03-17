package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.VeXe;

public class VeXeDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=VeXeOnline";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

	/**
	 * hàm kết nối csdl
	 */
	void connect() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException e) {
			System.out.println("loi class connect");
		} catch (SQLException e) {
			System.out.println("loi connect");
		}
	}

	/**
	 * hàm lấy danh sách vé xe ( chi tiết đơn hàng)
	 * 
	 * @return
	 */
	public ArrayList<VeXe> getListVeXe() {
		connect();
		String sql = "SELECT * FROM ChiTietVeXe";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<VeXe> list = new ArrayList<VeXe>();
		VeXe veXe;
		try {
			while (rs.next()) {
				veXe = new VeXe();

				veXe.setMaVeXe(rs.getString("MaVeXe"));
				veXe.setMaLichXe(rs.getString("MaLichXe"));
				veXe.setMaAccount(rs.getString("MaAccount"));
				veXe.setNgayDatVe(rs.getDate("NgayDatVe"));
				veXe.setNgayDi(rs.getDate("NgayDi"));
				veXe.setDiemDonKhach(rs.getString("DiemDonKhach"));
				veXe.setDiemTraKhach(rs.getString("DiemTraKhach"));
				veXe.setSoLuongVe(rs.getInt("SoLuongVe"));
				double tongTien = rs.getFloat("TongTien");
				veXe.setTongTien(tongTien);
				veXe.setTongTienString(StringProcess.convertNumToString(tongTien));
				if (rs.getInt("TinhTrangThanhToan") == 1)
					veXe.setTinhTrangThanhToan("Đã TT");
				else
					veXe.setTinhTrangThanhToan("Chưa TT");
				list.add(veXe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * hàm update xác nhận thanh toán cho vé xe
	 * 
	 * @param maVeXe
	 * @return
	 */
	public boolean updateXacNhanTT(String maVeXe) {

		connect();
		String sql = "update ChiTietVeXe set TinhTrangThanhToan = 1 where MaVeXe = N'" + maVeXe + "'";
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	/**
	 * hàm xóa vé xe theo mã vé xe
	 * 
	 * @param maVeXe
	 * @return
	 */
	public boolean xoaVeXe(String maVeXe) {
		connect();
		String sql = String.format("DELETE FROM ChiTietVeXe WHERE MaVeXe = N'%s'", maVeXe);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * hàm xóa tất cả vé xe chưa thanh toán
	 * 
	 * @return
	 */
	public boolean xoaAllVeXeChuaTT() {
		connect();
		String sql = "DELETE FROM ChiTietVeXe WHERE TinhTrangThanhToan = 0";
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * hàm tìm kiếm vé xe theo từ khóa nhập vào
	 * 
	 * @param tuKhoa
	 * @return
	 */
	public ArrayList<VeXe> getTimKiemVeXe(String tuKhoa) {
		connect();

		String sql = "select * from ChiTietVeXe WHERE MaVeXe LIKE '%" + tuKhoa + "%' or MaLichXe like '%" + tuKhoa
				+ "%' or MaAccount like '%" + tuKhoa + "%' or DiemDonKhach like '%" + tuKhoa
				+ "%' or DiemTraKhach like '%" + tuKhoa + "%'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<VeXe> list = new ArrayList<VeXe>();
		VeXe veXe;
		try {
			while (rs.next()) {
				veXe = new VeXe();
				veXe.setMaVeXe(rs.getString("MaVeXe"));
				veXe.setMaLichXe(rs.getString("MaLichXe"));
				veXe.setMaAccount(rs.getString("MaAccount"));
				veXe.setNgayDatVe(rs.getDate("NgayDatVe"));
				veXe.setNgayDi(rs.getDate("NgayDi"));
				veXe.setDiemDonKhach(rs.getString("DiemDonKhach"));
				veXe.setDiemTraKhach(rs.getString("DiemTraKhach"));
				veXe.setSoLuongVe(rs.getInt("SoLuongVe"));
				double tongTien = rs.getFloat("TongTien");
				veXe.setTongTien(tongTien);
				veXe.setTongTienString(StringProcess.convertNumToString(tongTien));
				if (rs.getInt("TinhTrangThanhToan") == 1)
					veXe.setTinhTrangThanhToan("Đã TT");
				else
					veXe.setTinhTrangThanhToan("Chưa TT");
				list.add(veXe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
