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
import model.bo.GiaVeBO;
import model.bo.LichTrinhBO;

public class DanhSachLichTrinhAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LichTrinhForm lichTrinhForm = (LichTrinhForm) form;

		LichTrinhBO lichTrinhBO = new LichTrinhBO();
		GiaVeBO giaVeBO = new GiaVeBO();

		// lay danh sach cac gia ve
		ArrayList<GiaVe> listGiaVe = giaVeBO.getListGiaVe();
		lichTrinhForm.setListGiaVe(listGiaVe);

		// lay danh sach lich trinh
		ArrayList<LichTrinh> listLichTrinh = lichTrinhBO.getListLichTrinh();
		lichTrinhForm.setListLichTrinh(listLichTrinh);

		return mapping.findForward("listLichTrinh");
	}
}
