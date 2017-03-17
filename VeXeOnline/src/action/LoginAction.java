package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoginForm;
import model.bo.AccountBO;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("tenDangNhap") != null)
			return mapping.findForward("thanhCong");

		LoginForm loginForm = (LoginForm) form;

		AccountBO accountBO = new AccountBO();

		String tenDangNhap = loginForm.getTenDangNhap();
		String matKhau = loginForm.getMatKhau();
		System.out.println("--tk---:" + tenDangNhap);
		System.out.println("--mk---:" + matKhau);

		if (accountBO.checkLogin(tenDangNhap, matKhau)) { // kiem tra neu

			session.setAttribute("tenDangNhap", tenDangNhap);
			// response.sendRedirect("index.jsp");
			// chinh xac
			return mapping.findForward("thanhCong");
		} else { // neu khong chinh xac
			loginForm.setThongBao("Đăng nhập không thành công");
			return mapping.findForward("thatBai");
		}
	}
}
