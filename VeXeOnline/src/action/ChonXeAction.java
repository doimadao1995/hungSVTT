package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DatVeForm;
import model.bean.DiemDonKhach;
import model.bean.DiemTraKhach;
import model.bean.GioXuatPhat;
import model.bo.DiemDonKhachBO;
import model.bo.DiemTraKhachBO;
import model.bo.DuLieuXeBO;
import model.bo.GiaVeBO;
import model.bo.LichTrinhBO;
import model.bo.LichXeBO;

public class ChonXeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("tenDangNhap") == null)
			return mapping.findForward("nhapThongTin");

		DatVeForm datVeForm = (DatVeForm) form;

		String maLichTrinh = datVeForm.getDiemDi().concat("-" + datVeForm.getDiemDen());

		LichTrinhBO lichTrinhBO = new LichTrinhBO();
		LichXeBO lichXeBO = new LichXeBO();
		DuLieuXeBO duLieuXeBO = new DuLieuXeBO();
		DiemTraKhachBO diemTraKhachBO = new DiemTraKhachBO();
		DiemDonKhachBO diemDonKhachBO = new DiemDonKhachBO();
		GiaVeBO giaVeBO = new GiaVeBO();

		if (!lichTrinhBO.checkLichTrinh(maLichTrinh)) {
			// redirect lỗi chọn sai lịch trình
			return mapping.findForward("checkFail");
		}

		String ngayDi = request.getParameter("ngayDi");

		if (!duLieuXeBO.checkSoLuongVe("QN-DN", ngayDi, Integer.parseInt(datVeForm.getSoLuongVe()))) {
			// redirect lỗi hết vé.
			return mapping.findForward("checkFail");
		}

		datVeForm.setNgayDi(ngayDi);
		ArrayList<GioXuatPhat> listGXP = lichXeBO.getListGioXuatPhat(maLichTrinh);
		ArrayList<DiemDonKhach> listDDK = diemDonKhachBO.getListDiemDonKhach(maLichTrinh);
		ArrayList<DiemTraKhach> listDTK = diemTraKhachBO.getListDiemTraKhach(maLichTrinh);

		datVeForm.setListGioXuatPhat(listGXP);
		datVeForm.setListDiemDonKhach(listDDK);
		datVeForm.setListDiemTraKhach(listDTK);
		datVeForm.setGiaVe(giaVeBO.getGiaVe(maLichTrinh));

		return mapping.findForward("checkOK");
	}
}
