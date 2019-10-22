package cn.ymt.util;

public class LorderUtil {

	
	public static String inttoString(int i){
		switch (i) {
		case 0:
			return "待支付" ;

		case 1:
			return "已支付" ;
			default :
		return null;
		}
	}
}
