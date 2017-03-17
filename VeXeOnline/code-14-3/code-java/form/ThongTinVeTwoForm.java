package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.DiemDonKhach;
import model.bean.DiemTraKhach;
import model.bean.GioXuatPhat;

public class ThongTinVeTwoForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String diemDi;
	private String diemDen;
	private String ngayDi;
	private String soLuongVe;
	private float giaVe;
	private ArrayList<GioXuatPhat> listGioXuatPhat;
	private ArrayList<DiemDonKhach> listDiemDonKhach;
	private ArrayList<DiemTraKhach> listDiemTraKhach;

	public float getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(float giaVe) {
		this.giaVe = giaVe;
	}

	public ArrayList<GioXuatPhat> getListGioXuatPhat() {
		return listGioXuatPhat;
	}

	public void setListGioXuatPhat(ArrayList<GioXuatPhat> listGioXuatPhat) {
		this.listGioXuatPhat = listGioXuatPhat;
	}

	public ArrayList<DiemDonKhach> getListDiemDonKhach() {
		return listDiemDonKhach;
	}

	public void setListDiemDonKhach(ArrayList<DiemDonKhach> listDiemDonKhach) {
		this.listDiemDonKhach = listDiemDonKhach;
	}

	public ArrayList<DiemTraKhach> getListDiemTraKhach() {
		return listDiemTraKhach;
	}

	public void setListDiemTraKhach(ArrayList<DiemTraKhach> listDiemTraKhach) {
		this.listDiemTraKhach = listDiemTraKhach;
	}

	public String getDiemDi() {
		return diemDi;
	}

	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}

	public String getDiemDen() {
		return diemDen;
	}

	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}

	public String getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getSoLuongVe() {
		return soLuongVe;
	}

	public void setSoLuongVe(String soLuongVe) {
		this.soLuongVe = soLuongVe;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Ngoai le: UnsupportedEncodingException");
		}
	}

}
