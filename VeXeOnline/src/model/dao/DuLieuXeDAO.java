package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.DuLieuXe;

public class DuLieuXeDAO {
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
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			System.out.println("loi cau lenh ket noi csdl");
		} catch (ClassNotFoundException e) {

			System.out.println("loi k tim thay class jdbc");
		}
	}

	/**
	 * hàm lấy danh sách dữ liệu xe
	 * 
	 * @return
	 */
	public ArrayList<DuLieuXe> getListDuLieuXe() {
		connect();
		String sql = "select * from DuLieuXe inner join LichXe on DuLieuXe.MaLichXe = LichXe.MaLichXe inner join LichTrinh on LichXe.MaLichTrinh = LichTrinh.MaLichTrinh";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<DuLieuXe> list = new ArrayList<DuLieuXe>();
		DuLieuXe duLieuXe;
		try {
			while (rs.next()) {
				duLieuXe = new DuLieuXe();
				duLieuXe.setMaDuLieuXe(rs.getString("MaDuLieuXe"));
				duLieuXe.setMaLichTrinh(rs.getString("MaLichTrinh"));
				duLieuXe.setMaLichXe(rs.getString("MaLichXe"));
				duLieuXe.setSoChoConLai(rs.getInt("SoChoConLai"));
				duLieuXe.setNgayDi(rs.getDate("NgayDi"));
				duLieuXe.setDiemDi(rs.getString("DiemDi"));
				duLieuXe.setDiemDen(rs.getString("DiemDen"));
				duLieuXe.setGioXuatPhat(rs.getString("GioXuatPhat"));
				duLieuXe.setMaXe(rs.getString("MaXe"));
				list.add(duLieuXe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
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
		connect();
		String sql = "select distinct SoChoConLai from DuLieuXe inner join LichXe on DuLieuXe.MaLichXe = LichXe.MaLichXe where MaLichTrinh = '"
				+ maLichTrinh + "' and DuLieuXe.NgayDi = N'" + ngayDi + "'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		try {
			while (rs.next()) {
				if (rs.getInt("SoChoConLai") > soLuongVe)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
