package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ThongTinVeTwoForm;
import model.bean.DiemDonKhach;
import model.bean.DiemTraKhach;
import model.bean.GioXuatPhat;
import model.dao.TestDAO;

public class DatVeIndexAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("tenDangNhap") == null) {
			return mapping.findForward("checkFail");

		} else {

			ThongTinVeTwoForm thongTinVeTwoForm = (ThongTinVeTwoForm) form;

			String maLichTrinh = thongTinVeTwoForm.getDiemDi().concat("-" + thongTinVeTwoForm.getDiemDen());

			System.out.println("--Ma LT--:" + maLichTrinh);

			TestDAO test = new TestDAO();

			ArrayList<GioXuatPhat> listGXP = test.getListGioXuatPhat(maLichTrinh);
			ArrayList<DiemDonKhach> listDDK = test.getListDiemDonKhach(maLichTrinh);
			ArrayList<DiemTraKhach> listDTK = test.getListDiemTraKhach(maLichTrinh);

			for (GioXuatPhat gxp : listGXP) {
				System.out.println("--GXP--:" + gxp.getGioXuatPhat());
			}

			String nd = request.getParameter("ngayDi");
			System.out.println(":--Ngay:--:" + nd);

			thongTinVeTwoForm.setNgayDi(nd);
			thongTinVeTwoForm.setListGioXuatPhat(listGXP);
			thongTinVeTwoForm.setListDiemDonKhach(listDDK);
			thongTinVeTwoForm.setListDiemTraKhach(listDTK);
			thongTinVeTwoForm.setGiaVe(test.getGiaVe(maLichTrinh));

			return mapping.findForward("checkOK");
		}

	}

}
