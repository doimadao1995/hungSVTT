package common;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcess {

	/**
	 * Ham tra ve gioi tinh: 1=Nam, 0=Nu
	 * 
	 * @param val
	 * @return String
	 */
	public static String gioiTinh(String val) {
		if ("0".equals(val)) {
			return "Nữ";
		}
		return "Nam";
	}

	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * 
	 * @param s
	 * @return String
	 */
	public static String getVaildString(String s) {
		if (s == null)
			return "";
		return s;
	}

	/**
	 * Ham kiem tra xau rong hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

	/**
	 * Ham kiem tra xem xau co bao gom chi chu so hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaildNumber(String s) {
		if (notVaild(s))
			return true;
		String regex = "[0-9]+";
		if (s.matches(regex))
			return false;
		return true;
	}

	/**
	 * hàm chuyển số sang chữ định đạng tiền tệ
	 * 
	 * @param tongTien
	 * @return String
	 */
	public static String convertNumToString(double tongTien) {
		if (tongTien < 1000)
			return String.valueOf(tongTien);
		DecimalFormat formatter = new DecimalFormat("###,###");
		String result = formatter.format(tongTien);
		return result.replaceAll(",", ".");

	}

	/**
	 * hàm sinh mã tự động
	 * 
	 * @return String
	 */
	public static String sinhMaAuto() {
		Random rn = new Random();
		return String.valueOf(System.currentTimeMillis() + rn.nextInt());
	}

	/**
	 * hàm kiểm tra Email
	 * 
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		Pattern pattern;
		Matcher matcher;
		String EMAIL_PATTERN = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * hàm kiểm tra số điện thoai
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean checkPhone(String phone) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = pattern.matcher(phone);
		if (!matcher.matches() && phone.length() < 7)
			return false;
		else
			return true;
	}

	public static ArrayList<MT> khoiTao(char kt, int gt) {
		int i = gt;
		MT mT;
		ArrayList<MT> list = new ArrayList<>();
		for (char c = kt; c <= 'Z'; ++c) {
			mT = new MT();
			mT.setMa(c + "");
			mT.setValue(i + "");
			list.add(mT);
			i++;
		}
		for (char c = 'A'; c < kt; ++c) {
			mT = new MT();
			mT.setMa(c + "");
			mT.setValue(i + "");
			list.add(mT);
			i++;
		}
		return list;

	}

	public static ArrayList<MT> khoiTao2(char kt, char gt) {
		char i = gt;
		MT mT;
		ArrayList<MT> list = new ArrayList<>();

		for (char c = kt; c <= 'Z'; ++c) {
			mT = new MT();
			mT.setMa(c + "");
			mT.setValue(i + "");
			list.add(mT);
			++i;

		}
		for (char c = 'A'; c < kt; ++c) {
			mT = new MT();
			mT.setMa(c + "");
			mT.setValue(i + "");
			list.add(mT);
			++i;
		}

		return list;

	}

	public static void main(String[] args) {

		ArrayList<MT> ds = khoiTao2('G', 'G');
		for (MT mt : ds) {
			System.out.println(mt.toString());
		}

		System.out.println(okRoiSo('A', 2, "3,2,15,11,-,21,6,6,15,-,8,10,7,-,21,9,6,6,20"));

	}

	public static String okRoiSo(char kt, int gt, String daySo) {
		ArrayList<MT> ds = khoiTao(kt, gt);
		String kq = "";
		int co;

		String[] parts = daySo.split(",");
		for (String string : parts) {
			String k = string;
			co = 0;
			for (MT mt : ds) {
				if (k.equals(mt.getValue())) {
					kq += mt.getMa();
					co = 1;
				}
			}
			if (co == 0)
				kq += "-";

		}
		return kq;
	}

}
