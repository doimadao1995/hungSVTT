package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.StringProcess;
import model.bean.DiemDonKhach;
import model.bean.DiemTraKhach;
import model.bean.GiaVe;
import model.bean.GioXuatPhat;
import model.bean.LichTrinh;

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

	public ArrayList<DiemTraKhach> getListDiemTraKhach(String maLichTrinh) {
		connect();
		String sql = "select distinct TenDiemTraKhach from DiemTraKhach where MaLichTrinh = '" + maLichTrinh + "'";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<DiemTraKhach> list = new ArrayList<DiemTraKhach>();
		DiemTraKhach dtk;
		try {
			while (rs.next()) {
				dtk = new DiemTraKhach();
				dtk.setDiemTraKhach(rs.getString("TenDiemTraKhach"));
				list.add(dtk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

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

	public ArrayList<LichTrinh> getListLichTrinh() {
		connect();
		String sql = "SELECT * FROM LichTrinh inner join GiaVe on LichTrinh.MaGiaVe = GiaVe.MaGiaVe";
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

	public boolean themLichTrinh(String maLichTrinh, String diemDi, String diemDen, String maGiaVe, String thoiGianChay,
			String quangDuong) {
		connect();

		String sql = "insert into LichTrinh values (N'" + maLichTrinh + "',N'" + diemDi + "',N'" + diemDen + "',N'"
				+ maGiaVe + "',N'" + thoiGianChay + "',N'" + quangDuong + "',1)";

		/*
		 * String sql = String.
		 * format("INSERT INTO LichTrinh VALUES ( N'%s',N'%s',N'%s',N'%s',N'%s',%d)"
		 * , maLichTrinh, diemDi, diemDen, maGiaVe, thoiGianChay, quangDuong,
		 * 1);
		 */

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

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

	public static void main(String[] args) {
		TestDAO k = new TestDAO();
		if (k.themLichTrinh("fdsfs-ffb", "diem a", "diem b", "GV02", "10h", "100 km")) {
			System.out.println("thang vien no bi dien");

		} else {
			System.out.println("vien-->11111");
		}

	}

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
