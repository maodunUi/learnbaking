package cn.ymt.util;


import org.junit.jupiter.api.Test;

public class LandlrodUtil {

	
	public static String intToString(String i){
		switch (i) {
		case "0":
			return "男" ; 
		default:
			return "女" ; 
		}
	}
	
	@Test
	public void testTop(){
		String intToString = LandlrodUtil.intToString("1") ;
		System.out.println(intToString);
	}
}
