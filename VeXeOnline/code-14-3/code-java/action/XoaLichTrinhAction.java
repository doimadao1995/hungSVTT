package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LichTrinhForm;
import model.dao.TestDAO;

public class XoaLichTrinhAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		LichTrinhForm lichTrinhForm = (LichTrinhForm) form;

		TestDAO k = new TestDAO();

		// xoa sinh vien
		String maLichTrinh = lichTrinhForm.getMaLichTrinh();
		if (k.xoaLichTrinh(maLichTrinh))
			return mapping.findForward("xoaLTOK");
		else
			return mapping.findForward("xoaLTFail");

	}
}
