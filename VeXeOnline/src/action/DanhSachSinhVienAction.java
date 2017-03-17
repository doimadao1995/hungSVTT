package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachSinhVienForm;
import model.bean.Khoa;
import model.bean.SinhVien;
import model.bo.KhoaBO;
import model.bo.SinhVienBO;

public class DanhSachSinhVienAction extends Action {
	private int page;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DanhSachSinhVienForm danhSachSinhVienForm = (DanhSachSinhVienForm) form;

		// lay danh sach cac khoa
		KhoaBO khoaBO = new KhoaBO();
		ArrayList<Khoa> listKhoa = khoaBO.getListKhoa();
		danhSachSinhVienForm.setListKhoa(listKhoa);

		// lay danh sach sinh vien
		ArrayList<SinhVien> listSinhVien;
		SinhVienBO sinhVienBO = new SinhVienBO();
		String maKhoa = danhSachSinhVienForm.getMaKhoa();
		String tuKhoa = danhSachSinhVienForm.getTuKhoa();
		String sUrl = request.getQueryString();

		String thb = (String) request.getAttribute("page");
		System.out.println("thong bao: " + thb);

		if (sUrl == null || maKhoa == "" && tuKhoa == "") {
			listSinhVien = sinhVienBO.getTimKiemListSinhVien(0);
		} else if (maKhoa == null && tuKhoa == null) {
			page = 0;
			try {
				page = Integer.parseInt(sUrl.replaceAll("page=", ""));
			} catch (Exception e) {
				page = 0;
			} finally {
				listSinhVien = sinhVienBO.getTimKiemListSinhVien(page);
			}

		} else if (maKhoa != "") {
			listSinhVien = sinhVienBO.getListSinhVien(maKhoa);
		} else {
			listSinhVien = sinhVienBO.getTimKiemListSinhVien(tuKhoa, 0);
		}

		danhSachSinhVienForm.setListSinhVien(listSinhVien);

		return mapping.findForward("dsSinhVien");
	}
}
