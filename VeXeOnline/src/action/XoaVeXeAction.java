package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.VeXeForm;
import model.bo.VeXeBO;

public class XoaVeXeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		VeXeForm veXeForm = (VeXeForm) form;

		VeXeBO veXeBO = new VeXeBO();
		// xoa ve xe
		if (veXeForm.getSubmit() != null) {
			if (veXeBO.xoaAllVeXeChuaTT())
				return mapping.findForward("xoaVXOK");
			else
				return mapping.findForward("xoaVXFail");
		} else {
			if (veXeBO.xoaVeXe(veXeForm.getMaVeXe()))
				return mapping.findForward("xoaVXOK");
			else
				return mapping.findForward("xoaVXFail");
		}
	}
}
