package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.VeXeForm;
import model.bean.VeXe;
import model.bo.VeXeBO;

public class DanhSachVeXeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		VeXeForm veXeForm = (VeXeForm) form;

		VeXeBO veXeBO = new VeXeBO();

		if (veXeForm.getTuKhoa() != null) {

			ArrayList<VeXe> listVeXe = veXeBO.getTimKiemVeXe(veXeForm.getTuKhoa());
			veXeForm.setListVeXe(listVeXe);
			if (listVeXe.isEmpty())
				veXeForm.setThongBaoTimKiem("Không tìm thấy kết quả tìm kiếm !!!");
			else
				veXeForm.setThongBaoTimKiem("Tìm thấy được " + listVeXe.size() + " kết quả !!!");
		} else {
			// lay danh sach ve xe
			ArrayList<VeXe> listVeXe = veXeBO.getListVeXe();
			veXeForm.setListVeXe(listVeXe);
		}
		return mapping.findForward("listVeXe");
	}

}
