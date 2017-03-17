package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.GiaVe;

public class GiaVeDAO {
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
	 * hàm lấy giá vé theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public float getGiaVe(String maLichTrinh) {
		connect();
		String sql = "select GiaVe from GiaVe inner join LichTrinh on LichTrinh.MaGiaVe = GiaVe.MaGiaVe where MaLichTrinh = '"
				+ maLichTrinh + "'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				return rs.getFloat("GiaVe");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	/**
	 * lấy danh sách giá vé
	 * 
	 * @return
	 */
	public ArrayList<GiaVe> getListGiaVe() {
		connect();
		String sql = "SELECT * FROM GiaVe";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<GiaVe> list = new ArrayList<GiaVe>();
		GiaVe giaVe;
		try {
			while (rs.next()) {
				giaVe = new GiaVe();
				giaVe.setMaGiaVe(rs.getString("MaGiaVe"));
				giaVe.setGiaVe(rs.getFloat("GiaVe"));
				giaVe.setGiaVeString(StringProcess.convertNumToString(rs.getFloat("GiaVe")));
				list.add(giaVe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
