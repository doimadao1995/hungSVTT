package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.DiemDonKhach;

public class DiemDonKhachDAO {
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
	 * hàm lấy danh sách điểm đón khách theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public ArrayList<DiemDonKhach> getListDiemDonKhach(String maLichTrinh) {
		connect();
		String sql = "select distinct TenDiemDonKhach from DiemDonKhach where MaLichTrinh = '" + maLichTrinh + "'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<DiemDonKhach> list = new ArrayList<DiemDonKhach>();
		DiemDonKhach dtk;
		try {
			while (rs.next()) {
				dtk = new DiemDonKhach();
				dtk.setDiemDonKhach(rs.getString("TenDiemDonKhach"));
				list.add(dtk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

}
