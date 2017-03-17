package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LichTrinhForm;
import model.bean.LichTrinh;
import model.bo.LichTrinhBO;

public class IndexAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LichTrinhForm lichTrinhForm = (LichTrinhForm) form;

		LichTrinhBO lichTrinhBO = new LichTrinhBO();

		ArrayList<LichTrinh> listLichTrinh = lichTrinhBO.getListLichTrinh();
		lichTrinhForm.setListLichTrinh(listLichTrinh);

		ArrayList<LichTrinh> listLTDaNang = lichTrinhBO.getSubListLichTrinh("DN");
		lichTrinhForm.setListLTDaNang(listLTDaNang);
		ArrayList<LichTrinh> listLTQuyNhon = lichTrinhBO.getSubListLichTrinh("QN");
		lichTrinhForm.setListLTQuyNhon(listLTQuyNhon);
		ArrayList<LichTrinh> listLTHaNoi = lichTrinhBO.getSubListLichTrinh("HN");
		lichTrinhForm.setListLTHaNoi(listLTHaNoi);
		ArrayList<LichTrinh> listLTNhaTrang = lichTrinhBO.getSubListLichTrinh("NT");
		lichTrinhForm.setListLTNhaTrang(listLTNhaTrang);
		ArrayList<LichTrinh> listLTDaLat = lichTrinhBO.getSubListLichTrinh("DL");
		lichTrinhForm.setListLTDaLat(listLTDaLat);
		ArrayList<LichTrinh> listLTSaiGon = lichTrinhBO.getSubListLichTrinh("SG");
		lichTrinhForm.setListLTSaiGon(listLTSaiGon);

		return mapping.findForward("index");
	}

}
