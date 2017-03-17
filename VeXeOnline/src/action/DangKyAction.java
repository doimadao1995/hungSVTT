package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AccountForm;
import model.bo.AccountBO;

public class DangKyAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// code xu ly dang ky

		AccountForm accountForm = (AccountForm) form;
		AccountBO accountBO = new AccountBO();

		String maTK = accountForm.getMaAccount();
		String matKhau = accountForm.getMatKhau();
		String hoTen = accountForm.getHoTen();
		String email = accountForm.getEmail();
		String sdt = accountForm.getSoDienThoai();
		String diaChi = accountForm.getDiaChi();

		// kiem tra thong tin nhap vao co day du chua

		// kiem tra nhap thong tin co hop le k

		// kiem tra tk co trung k - true la ton tai roi
		if (accountBO.checkDangKy(maTK))
			return mapping.findForward("thatBai");

		if (accountBO.dangKy(maTK, matKhau, hoTen, email, sdt, diaChi))
			return mapping.findForward("thanhCong");
		else
			return mapping.findForward("thatBai");
	}

}
