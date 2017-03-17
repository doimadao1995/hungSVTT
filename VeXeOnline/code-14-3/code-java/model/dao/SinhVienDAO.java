package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Pagination;
import model.bean.SinhVien;

public class SinhVienDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaEE_Example";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

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

	public ArrayList<SinhVien> getListSinhVien() {
		connect();
		String sql = "SELECT sv.msv, sv.HoTen, sv.GioiTinh, sv.DiaChi, k.TenKhoa"
				+ " FROM   SinhVien sv INNER JOIN Khoa AS k ON k.MaKhoa = sv.MaKhoa";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien;
		try {
			while (rs.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMsv(rs.getString("msv"));
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setTenKhoa(rs.getString("TenKhoa"));
				sinhVien.setDiaChi(rs.getString("DiaChi"));
				list.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<SinhVien> getListSinhVien(String maKhoa) {
		connect();
		String sql = String.format("SELECT sv.msv, sv.HoTen, sv.GioiTinh, sv.DiaChi, k.TenKhoa"
				+ " FROM   SinhVien sv INNER JOIN Khoa AS k ON k.MaKhoa = sv.MaKhoa" + " WHERE sv.MaKhoa = '%s'",
				maKhoa);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien;
		try {
			while (rs.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMsv(rs.getString("msv"));
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setTenKhoa(rs.getString("TenKhoa"));
				sinhVien.setDiaChi(rs.getString("DiaChi"));
				list.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void themSinhVien(String msv, String hoTen, String gioiTinh, String maKhoa, String diaChi) {
		connect();
		String sql = String.format(
				"INSERT INTO SinhVien(msv,HoTen,GioiTinh,MaKhoa,DiaChi) " + " VALUES ( '%s',N'%s','%s','%s',N'%s' )",
				msv, hoTen, gioiTinh, maKhoa, diaChi);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public SinhVien getThongTinSinhVien(String msv) {
		connect();
		String sql = String.format("SELECT HoTen, GioiTinh, MaKhoa, DiaChi, msv " + " FROM SinhVien WHERE msv = '%s'",
				msv);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		SinhVien sinhVien = new SinhVien();
		try {
			while (rs.next()) {
				sinhVien.setMsv(msv);
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setMaKhoa(rs.getString("MaKhoa"));
				sinhVien.setDiaChi(rs.getString("DiaChi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sinhVien;
	}

	public void suaSinhVien(String msv, String hoTen, String gioiTinh, String maKhoa, String diaChi) {
		connect();
		String sql = String.format("UPDATE SinhVien "
				+ " SET HoTen = N'%s', GioiTinh = %s, MaKhoa = '%s', DiaChi = N'%s' " + " WHERE msv = '%s'", hoTen,
				gioiTinh, maKhoa, diaChi, msv);
		/*
		 * String sql1 = "UPDATE SinhVien SET HoTen = N'" + hoTen +
		 * "', GioiTinh = '" + gioiTinh + "' WHERE msv = '" + msv + "'";
		 */
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void xoaSinhVien(String msv) {
		connect();
		String sql = String.format("DELETE FROM SinhVien WHERE msv = '%s'", msv);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<SinhVien> getTimKiemListSinhVien(int page) {
		connect();

		int totalItem = 0;
		int itemPerPage = 10;
		int totalPage = 0;
		int offset = page * itemPerPage;
		int feetchnext = page * itemPerPage + itemPerPage;

		String sql0 = "SELECT count(sv.msv) as TotalItem"
				+ " FROM   SinhVien sv INNER JOIN Khoa AS k ON k.MaKhoa = sv.MaKhoa";
		ResultSet rs0 = null;
		try {
			Statement stmt0 = connection.createStatement();
			rs0 = stmt0.executeQuery(sql0);
		} catch (SQLException e) {
			System.out.println("loi sql 1 trong ham getTimKiemListSinhVien(page) ");
		}

		try {
			while (rs0.next()) {
				totalItem = rs0.getInt("TotalItem");
				totalPage = (int) Math.ceil(totalItem * 1.0 / itemPerPage);
				Pagination.page = page;
				Pagination.totalPage = totalPage;
			}
		} catch (SQLException e) {
			System.out.println("loi sql 2 trong ham getTimKiemListSinhVien(page) ");

		}

		String sql = "SELECT * FROM" + " ("
				+ " SELECT ROW_NUMBER() OVER ( ORDER BY msv )  AS RowNum, sv.msv, sv.HoTen, sv.GioiTinh, sv.DiaChi, k.TenKhoa"
				+ " FROM SinhVien sv INNER JOIN Khoa" + " AS k" + " ON k.MaKhoa = sv.MaKhoa"
				+ " ) AS RowConstrainedResult" + " WHERE   RowNum > " + offset + " AND RowNum <= " + feetchnext
				+ " ORDER BY RowNum";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien;
		try {
			while (rs.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMsv(rs.getString("msv"));
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh("1".equals(rs.getString("GioiTinh")) ? "Nam" : "Nu");
				sinhVien.setTenKhoa(rs.getString("TenKhoa"));
				sinhVien.setDiaChi(rs.getString("DiaChi"));
				list.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<SinhVien> getTimKiemListSinhVien(String tuKhoa, int page) {
		connect();

		int totalItem = 0;
		int itemPerPage = 10;
		int totalPage = 0;
		int offset = page * itemPerPage;
		int feetchnext = page * itemPerPage + itemPerPage;

		String sql0 = "SELECT count(sv.msv) as TotalItem"
				+ " FROM   SinhVien sv INNER JOIN Khoa AS k ON k.MaKhoa = sv.MaKhoa" + " WHERE sv.HoTen LIKE '%"
				+ tuKhoa + "%'";
		ResultSet rs0 = null;
		try {
			Statement stmt0 = connection.createStatement();
			rs0 = stmt0.executeQuery(sql0);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs0.next()) {
				totalItem = rs0.getInt("TotalItem");
				totalPage = (int) Math.ceil(totalItem * 1.0 / itemPerPage);
				Pagination.page = page;
				Pagination.totalPage = totalPage;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "" + "SELECT * FROM" + " ("
				+ " SELECT ROW_NUMBER() OVER ( ORDER BY msv )  AS RowNum, sv.msv, sv.HoTen, sv.GioiTinh, sv.DiaChi, k.TenKhoa"
				+ " FROM SinhVien sv INNER JOIN Khoa" + " AS k" + " ON k.MaKhoa = sv.MaKhoa" + " WHERE sv.HoTen LIKE '%"
				+ tuKhoa + "%'" + " ) AS RowConstrainedResult" + " WHERE   RowNum > " + offset + " AND RowNum <= "
				+ feetchnext + " ORDER BY RowNum";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien;
		try {
			while (rs.next()) {
				sinhVien = new SinhVien();
				sinhVien.setMsv(rs.getString("msv"));
				sinhVien.setHoTen(rs.getString("HoTen"));
				sinhVien.setGioiTinh(rs.getString("GioiTinh"));
				sinhVien.setTenKhoa(rs.getString("TenKhoa"));
				sinhVien.setDiaChi(rs.getString("DiaChi"));
				list.add(sinhVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
