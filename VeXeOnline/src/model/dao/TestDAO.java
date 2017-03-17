package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.VeXe;

public class TestDAO {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=VeXeOnline";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

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

	public ArrayList<VeXe> getTimKiemVeXe(String tuKhoa) {
		connect();
		/*
		 * int totalItem = 0; int itemPerPage = 10; int totalPage = 0; int
		 * offset = page * itemPerPage; int feetchnext = page * itemPerPage +
		 * itemPerPage;
		 * 
		 * 
		 * String sql0 = "SELECT count(sv.msv) as TotalItem" +
		 * " FROM   SinhVien sv INNER JOIN Khoa AS k ON k.MaKhoa = sv.MaKhoa" +
		 * " WHERE sv.HoTen LIKE '%" + tuKhoa + "%'"; ResultSet rs0 = null; try
		 * { Statement stmt0 = connection.createStatement(); rs0 =
		 * stmt0.executeQuery(sql0); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 * 
		 * try { while (rs0.next()) { totalItem = rs0.getInt("TotalItem");
		 * totalPage = (int) Math.ceil(totalItem * 1.0 / itemPerPage);
		 * Pagination.page = page; Pagination.totalPage = totalPage; } } catch
		 * (SQLException e) { e.printStackTrace(); }
		 * 
		 * String sql = "" + "SELECT * FROM" + " (" +
		 * " SELECT ROW_NUMBER() OVER ( ORDER BY msv )  AS RowNum, sv.msv, sv.HoTen, sv.GioiTinh, sv.DiaChi, k.TenKhoa"
		 * + " FROM SinhVien sv INNER JOIN Khoa" + " AS k" +
		 * " ON k.MaKhoa = sv.MaKhoa" + " WHERE sv.HoTen LIKE '%" + tuKhoa +
		 * "%'" + " ) AS RowConstrainedResult" + " WHERE   RowNum > " + offset +
		 * " AND RowNum <= " + feetchnext + " ORDER BY RowNum";
		 */

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
