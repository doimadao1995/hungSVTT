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
import model.bean.LichTrinh;
import model.dao.TestDAO;

public class SuaLichTrinhAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		LichTrinhForm lichTrinhForm = (LichTrinhForm) form;

		TestDAO k = new TestDAO();

		// lay danh sach cac gia ve
		ArrayList<GiaVe> listGiaVe = k.getListGiaVe();
		lichTrinhForm.setListGiaVe(listGiaVe);

		// sua lich trinh
		String maLichTrinh = lichTrinhForm.getMaLichTrinh();
		if ("submit".equals(lichTrinhForm.getSubmit())) { // nhan nut Xac nhan o
															// trang sua lich
															// trinh

			String diemDi = lichTrinhForm.getDiemDi();
			String diemDen = lichTrinhForm.getDiemDen();
			String maGiaVe = lichTrinhForm.getMaGiaVe();
			String thoiGianChay = lichTrinhForm.getThoiGianChay();
			String quangDuong = lichTrinhForm.getQuangDuong();

			byte[] b1 = diemDi.getBytes("ISO-8859-1");
			diemDi = new String(b1, "UTF-8");
			byte[] b2 = diemDen.getBytes("ISO-8859-1");
			diemDen = new String(b2, "UTF-8");
			byte[] b3 = thoiGianChay.getBytes("ISO-8859-1");
			thoiGianChay = new String(b3, "UTF-8");
			byte[] b4 = quangDuong.getBytes("ISO-8859-1");
			quangDuong = new String(b4, "UTF-8");

			k.suaLichTrinh(maLichTrinh, diemDi, diemDen, maGiaVe, thoiGianChay, quangDuong, 1);
			return mapping.findForward("suaLTOK");
		} else { // chuyen sang trang Sua sinh vien
			LichTrinh lichTrinh = k.getLichTrinh(maLichTrinh);
			lichTrinhForm.setMaLichTrinh(lichTrinh.getMaLichTrinh());
			lichTrinhForm.setDiemDi(lichTrinh.getDiemDi());
			lichTrinhForm.setDiemDen(lichTrinh.getDiemDen());
			lichTrinhForm.setMaGiaVe(lichTrinh.getMaGiaVe());
			lichTrinhForm.setThoiGianChay(lichTrinh.getThoiGianChay());
			lichTrinhForm.setQuangDuong(lichTrinh.getQuangDuong());

			return mapping.findForward("suaLT");
		}
	}
}
