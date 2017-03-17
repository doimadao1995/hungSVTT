package model.bo;

import model.dao.AccountDAO;

public class AccountBO {

	AccountDAO accountDAO = new AccountDAO();

	/**
	 * hàm đăng ký tài khoản người dùng
	 * 
	 * @param ma
	 * @param pass
	 * @param ten
	 * @param email
	 * @param sdt
	 * @param diaChi
	 * @return
	 */
	public boolean dangKy(String ma, String pass, String ten, String email, String sdt, String diaChi) {
		return accountDAO.dangKy(ma, pass, ten, email, sdt, diaChi);
	}

	/**
	 * hàm kiểm tra login
	 * 
	 * @param ma
	 * @param pass
	 * @return
	 */
	public boolean checkLogin(String ma, String pass) {
		return accountDAO.checkLogin(ma, pass);
	}

	/**
	 * hàm kiểm tra tài khoản có tồn tại không?
	 * 
	 * @param maTK
	 * @return
	 */
	public boolean checkDangKy(String maTK) {
		return accountDAO.checkDangKy(maTK);
	}

}
