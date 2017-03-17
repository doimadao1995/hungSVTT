package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.GioXuatPhat;

public class LichXeDAO {

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
	 * hàm lấy danh sách giờ xuất phát theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public ArrayList<GioXuatPhat> getListGioXuatPhat(String maLichTrinh) {
		connect();
		String sql = "select GioXuatPhat from LichXe where MaLichTrinh = N'" + maLichTrinh + "'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<GioXuatPhat> list = new ArrayList<GioXuatPhat>();
		GioXuatPhat gxp;
		try {
			while (rs.next()) {
				gxp = new GioXuatPhat();
				gxp.setGioXuatPhat(rs.getString("GioXuatPhat"));
				list.add(gxp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}
