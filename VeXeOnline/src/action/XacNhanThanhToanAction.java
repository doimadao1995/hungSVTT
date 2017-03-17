package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.VeXeForm;
import model.bo.VeXeBO;

public class XacNhanThanhToanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		VeXeForm veXeForm = (VeXeForm) form;

		VeXeBO veXeBO = new VeXeBO();

		// xac nhan thanh toan
		String maVeXe = veXeForm.getMaVeXe();
		if (veXeBO.updateXacNhanTT(maVeXe))
			return mapping.findForward("xacNhanOK");
		else
			return mapping.findForward("xacNhanFail");
	}

}
