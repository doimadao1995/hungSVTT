package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LichTrinhForm;
import model.bean.GiaVe;
import model.dao.TestDAO;

public class ThemLichTrinhAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		LichTrinhForm lichTrinhForm = (LichTrinhForm) form;

		TestDAO k = new TestDAO();

		// lay danh sach cac gia ve
		ArrayList<GiaVe> listGiaVe = k.getListGiaVe();
		lichTrinhForm.setListGiaVe(listGiaVe);

		/*
		 * // validate du lieu if ("submit".equals(lichTrinhForm.getSubmit())) {
		 * ActionErrors actionErrors = new ActionErrors(); if
		 * (StringProcess.notVaild(lichTrinhForm.getMsv())) {
		 * actionErrors.add("msvError", new ActionMessage("error.msv.trong")); }
		 * if (StringProcess.notVaildNumber(lichTrinhForm.getMsv())) {
		 * actionErrors.add("msvError", new ActionMessage("error.msv.so")); }
		 * saveErrors(request, actionErrors); if (actionErrors.size() > 0) {
		 * return mapping.findForward("themSVerror"); } }
		 */

		if ("submit".equals(lichTrinhForm.getSubmit())) { // nhan nut Xac nhan o
															// trang Them sinh
															// vien
			String maLichTrinh = lichTrinhForm.getMaLichTrinh();
			String diemDi = lichTrinhForm.getDiemDi();
			String diemDen = lichTrinhForm.getDiemDen();
			String maGiaVe = lichTrinhForm.getMaGiaVe();
			String thoiGianChay = lichTrinhForm.getThoiGianChay();
			String quangDuong = lichTrinhForm.getQuangDuong();
			byte[] b = maLichTrinh.getBytes("ISO-8859-1");
			maLichTrinh = new String(b, "UTF-8");
			byte[] b1 = diemDi.getBytes("ISO-8859-1");
			diemDi = new String(b1, "UTF-8");
			byte[] b2 = diemDen.getBytes("ISO-8859-1");
			diemDen = new String(b2, "UTF-8");
			byte[] b3 = thoiGianChay.getBytes("ISO-8859-1");
			thoiGianChay = new String(b3, "UTF-8");
			byte[] b4 = quangDuong.getBytes("ISO-8859-1");
			quangDuong = new String(b4, "UTF-8");

			k.themLichTrinh(maLichTrinh, diemDi, diemDen, maGiaVe, thoiGianChay, quangDuong);
			return mapping.findForward("themLTOK");
		} else { // chuyen sang trang Them sinh vien
			return mapping.findForward("themLT");
		}
	}

}
