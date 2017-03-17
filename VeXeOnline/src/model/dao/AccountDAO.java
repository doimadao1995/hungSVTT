package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

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
	 * hàm đăng ký tài khoản người dùng
	 * 
	 * @param ma
	 * @param pass
	 * @param ten
	 * @param email
	 * @param sdt
	 * @param diaChi
	 * @return
	 */
	public boolean dangKy(String ma, String pass, String ten, String email, String sdt, String diaChi) {

		connect();

		String sql = "insert into Account values(N'" + ma + "',N'" + pass + "',0,N'" + ten + "',N'" + email + "',N'"
				+ sdt + "',N'" + diaChi + "',0)";

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
	 * hàm kiểm tra có tồn tại tài khoản không?
	 * 
	 * @param maTK
	 * @return
	 */
	// return true la ton tai tk roi
	public boolean checkDangKy(String maTK) {

		connect();
		String sql = "select * from Account where MaAccount = N'" + maTK + "'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}

		try {
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	/**
	 * hàm kiểm tra login
	 * 
	 * @param tenDangNhap
	 * @param matKhau
	 * @return
	 */
	public boolean checkLogin(String tenDangNhap, String matKhau) {
		connect();
		String sql = String.format("SELECT * FROM Account WHERE MaAccount = '%s' AND MatKhau = '%s'", tenDangNhap,
				matKhau);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
