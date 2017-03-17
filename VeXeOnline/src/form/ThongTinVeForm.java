package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ThongTinVeForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String gioXuatPhat;
	private String diemDonKhach;
	private String diemTraKhach;

	public String getGioXuatPhat() {
		return gioXuatPhat;
	}

	public void setGioXuatPhat(String gioXuatPhat) {
		this.gioXuatPhat = gioXuatPhat;
	}

	public String getDiemDonKhach() {
		return diemDonKhach;
	}

	public void setDiemDonKhach(String diemDonKhach) {
		this.diemDonKhach = diemDonKhach;
	}

	public String getDiemTraKhach() {
		return diemTraKhach;
	}

	public void setDiemTraKhach(String diemTraKhach) {
		this.diemTraKhach = diemTraKhach;
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
