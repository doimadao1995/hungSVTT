package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DuLieuXeForm;
import model.bean.DuLieuXe;
import model.bo.DuLieuXeBO;

public class DanhSachDuLieuXeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DuLieuXeForm duLieuXeForm = (DuLieuXeForm) form;

		DuLieuXeBO duLieuXeBO = new DuLieuXeBO();

		// lay danh sach cac du lieu xe
		ArrayList<DuLieuXe> listDuLieuXe = duLieuXeBO.getListDuLieuXe();
		duLieuXeForm.setListDuLieuXe(listDuLieuXe);
		return mapping.findForward("listDuLieuXe");
	}

}
