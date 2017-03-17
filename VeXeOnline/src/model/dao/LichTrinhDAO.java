package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.LichTrinh;

public class LichTrinhDAO {
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
	 * hàm lấy danh sách tất cả lịch trình
	 * 
	 * @return
	 */
	public ArrayList<LichTrinh> getListLichTrinh() {
		connect();
		String sql = "select * from LichXe inner join Xe on LichXe.MaXe = Xe.MaXe inner join LichTrinh on LichXe.MaLichTrinh = LichTrinh.MaLichTrinh inner join GiaVe on LichTrinh.MaGiaVe = GiaVe.MaGiaVe";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<LichTrinh> list = new ArrayList<LichTrinh>();
		LichTrinh lichTrinh;
		try {
			while (rs.next()) {
				lichTrinh = new LichTrinh();
				lichTrinh.setMaLichTrinh(rs.getString("MaLichTrinh"));
				lichTrinh.setDiemDi(rs.getString("DiemDi"));
				lichTrinh.setDiemDen(rs.getString("DiemDen"));
				lichTrinh.setMaGiaVe(rs.getString("MaGiaVe"));
				lichTrinh.setThoiGianChay(rs.getString("ThoiGianChay"));
				lichTrinh.setQuangDuong(rs.getString("QuangDuong"));
				lichTrinh.setLoaiXe(rs.getString("LoaiXe"));
				lichTrinh.setGioXuatPhat(rs.getString("GioXuatPhat"));
				lichTrinh.setGiaVeString(StringProcess.convertNumToString(rs.getFloat("GiaVe")));
				if (rs.getInt("TinhTrang") == 0)
					lichTrinh.setTinhTrang("Tạm ngưng");
				else
					lichTrinh.setTinhTrang("Hoạt động");
				list.add(lichTrinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * hàm lấy danh sách lịch trình theo điểm xuất phát
	 * 
	 * @param subMaLichTrinh
	 * @return
	 */
	public ArrayList<LichTrinh> getSubListLichTrinh(String subMaLichTrinh) {
		connect();
		String sql = "select * from LichXe inner join Xe on LichXe.MaXe = Xe.MaXe inner join LichTrinh on LichXe.MaLichTrinh = LichTrinh.MaLichTrinh inner join GiaVe on LichTrinh.MaGiaVe = GiaVe.MaGiaVe where SUBSTRING (LichTrinh.MaLichTrinh ,1 , 2 ) = N'"
				+ subMaLichTrinh + "'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<LichTrinh> list = new ArrayList<LichTrinh>();
		LichTrinh lichTrinh;
		try {
			while (rs.next()) {
				lichTrinh = new LichTrinh();
				lichTrinh.setMaLichTrinh(rs.getString("MaLichTrinh"));
				lichTrinh.setDiemDi(rs.getString("DiemDi"));
				lichTrinh.setDiemDen(rs.getString("DiemDen"));
				lichTrinh.setMaGiaVe(rs.getString("MaGiaVe"));
				lichTrinh.setThoiGianChay(rs.getString("ThoiGianChay"));
				lichTrinh.setQuangDuong(rs.getString("QuangDuong"));
				lichTrinh.setLoaiXe(rs.getString("LoaiXe"));
				lichTrinh.setGioXuatPhat(rs.getString("GioXuatPhat"));
				lichTrinh.setGiaVeString(StringProcess.convertNumToString(rs.getFloat("GiaVe")));
				if (rs.getInt("TinhTrang") == 0)
					lichTrinh.setTinhTrang("Tạm ngưng");
				else
					lichTrinh.setTinhTrang("Hoạt động");
				list.add(lichTrinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * hàm thêm lịch trình
	 * 
	 * @param maLichTrinh
	 * @param diemDi
	 * @param diemDen
	 * @param maGiaVe
	 * @param thoiGianChay
	 * @param quangDuong
	 * @return
	 */
	public boolean themLichTrinh(String maLichTrinh, String diemDi, String diemDen, String maGiaVe, String thoiGianChay,
			String quangDuong) {
		connect();

		String sql = "insert into LichTrinh values (N'" + maLichTrinh + "',N'" + diemDi + "',N'" + diemDen + "',N'"
				+ maGiaVe + "',N'" + thoiGianChay + "',N'" + quangDuong + "',1)";

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
	 * hàm chỉnh sửa lịch trình
	 * 
	 * @param maLichTrinh
	 * @param diemDi
	 * @param diemDen
	 * @param maGiaVe
	 * @param thoiGianChay
	 * @param quangDuong
	 * @param i
	 * @return
	 */
	public boolean suaLichTrinh(String maLichTrinh, String diemDi, String diemDen, String maGiaVe, String thoiGianChay,
			String quangDuong, int i) {

		connect();
		String sql = "update LichTrinh set DiemDi = N'" + diemDi + "', DiemDen = N'" + diemDen + "', ThoiGianChay = N'"
				+ thoiGianChay + "', MaGiaVe = N'" + maGiaVe + "', QuangDuong = N'" + quangDuong
				+ "' where MaLichTrinh = N'" + maLichTrinh + "'";

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
	 * hàm xóa lịch trình theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public boolean xoaLichTrinh(String maLichTrinh) {
		connect();
		String sql = String.format("DELETE FROM LichTrinh WHERE MaLichTrinh = N'%s'", maLichTrinh);
		System.out.println(sql);
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
	 * hàm kiểm tra có tồn tại lịch trình hay không?
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public boolean checkLichTrinh(String maLichTrinh) {
		connect();
		String sql = "select distinct * from LichTrinh where MaLichTrinh = N'" + maLichTrinh + "'";
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
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * hàm lấy lịch trình theo mã lịch trình
	 * 
	 * @param maLichTrinh
	 * @return
	 */
	public LichTrinh getLichTrinh(String maLichTrinh) {
		connect();
		String sql = "select distinct * from LichTrinh where MaLichTrinh = '" + maLichTrinh + "'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		LichTrinh lichTrinh = new LichTrinh();
		try {
			if (rs.next()) {
				lichTrinh.setMaLichTrinh(maLichTrinh);
				lichTrinh.setDiemDen(rs.getString("DiemDen"));
				lichTrinh.setDiemDi(rs.getString("DiemDi"));
				lichTrinh.setMaGiaVe(rs.getString("MaGiaVe"));
				lichTrinh.setThoiGianChay(rs.getString("ThoiGianChay"));
				lichTrinh.setQuangDuong(rs.getString("QuangDuong"));
				if (rs.getInt("TinhTrang") == 0)
					lichTrinh.setTinhTrang("Tạm ngưng");
				else
					lichTrinh.setTinhTrang("Hoạt động");
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return lichTrinh;

	}

	/**
	 * hàm lấy mã lịch trình theo điểm đi và điểm đến
	 * 
	 * @param diemDi
	 * @param diemDen
	 * @return
	 */
	public String getMaLichTrinh(String diemDi, String diemDen) {
		connect();
		String sql = String.format("SELECT MaLichTrinh FROM LichTrinh WHERE DiemDi = N'%s' and DiemDen = N'%s'", diemDi,
				diemDen);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String abc = "";
		try {
			while (rs.next()) {
				abc = rs.getString("MaLichTrinh");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return abc;
	}
}
