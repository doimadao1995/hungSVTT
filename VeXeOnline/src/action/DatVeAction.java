package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DatVeForm;
import model.bean.DiemDonKhach;
import model.bean.DiemTraKhach;
import model.bean.GioXuatPhat;
import model.bean.LichTrinh;
import model.bo.DiemDonKhachBO;
import model.bo.DiemTraKhachBO;
import model.bo.DuLieuXeBO;
import model.bo.GiaVeBO;
import model.bo.LichTrinhBO;
import model.bo.LichXeBO;

public class DatVeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

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

		int soLuongVe = Integer.parseInt(datVeForm.getSoLuongVe());

		if (!duLieuXeBO.checkSoLuongVe("QN-DN", ngayDi, soLuongVe)) {
			// redirect lỗi hết vé.
			return mapping.findForward("checkFail");
		}

		datVeForm.setMaLichTrinh(maLichTrinh);
		datVeForm.setNgayDi(ngayDi);
		ArrayList<GioXuatPhat> listGXP = lichXeBO.getListGioXuatPhat(maLichTrinh);
		ArrayList<DiemDonKhach> listDDK = diemDonKhachBO.getListDiemDonKhach(maLichTrinh);
		ArrayList<DiemTraKhach> listDTK = diemTraKhachBO.getListDiemTraKhach(maLichTrinh);

		LichTrinh lt = lichTrinhBO.getLichTrinh(maLichTrinh);

		datVeForm.setDiemDi(lt.getDiemDi());
		datVeForm.setDiemDen(lt.getDiemDen());
		float giaVe = giaVeBO.getGiaVe(maLichTrinh);
		datVeForm.setListGioXuatPhat(listGXP);
		datVeForm.setListDiemDonKhach(listDDK);
		datVeForm.setListDiemTraKhach(listDTK);
		datVeForm.setGiaVe(giaVe);
		datVeForm.setGiaVeString(StringProcess.convertNumToString(giaVe));
		double tongTien = giaVe * soLuongVe;
		datVeForm.setTongTien(tongTien);
		datVeForm.setTongTienString(StringProcess.convertNumToString(tongTien));
		return mapping.findForward("checkOK");
	}

}
