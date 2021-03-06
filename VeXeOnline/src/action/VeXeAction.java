package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DatVeForm;
import model.bo.LichTrinhBO;

public class VeXeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DatVeForm datVeForm = (DatVeForm) form;
		LichTrinhBO lichTrinhBO = new LichTrinhBO();

		String maLichTrinh = lichTrinhBO.getMaLichTrinh(datVeForm.getDiemDi(), datVeForm.getDiemDen());
		System.out.println("--diem di--:" + datVeForm.getDiemDi());
		System.out.println("--diem den--:" + datVeForm.getDiemDen());
		System.out.println("--ma lt--:" + maLichTrinh);
		return mapping.findForward("checkOK");
	}
}
