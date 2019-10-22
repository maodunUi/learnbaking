package cn.ymt.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class DateUtil {

	
	   /**计算两个日期相差天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDaysByMillisecond(Date date1,Date date2)
	    {
	        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
	        return days;
	    }
	   
	   /** 日期转数据库接收日期格式
	 * @param date
	 * @return
	 */
	public static Date  dateFormat(Date date){
		   SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		   String format = formate.format(date) ;
		   Timestamp goodsC_date =Timestamp.valueOf(format);//把时间转换 转换成mysql数据库datetime对应的类型
		   return goodsC_date ;
	   }
	   
	   
	   /** 日期转字符串
	 * @param date
	 * @return
	 */
	public static String  dateToString(Date date){
		   SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		   String format = formate.format(date) ;
		  return format ;
	   }
	
	public static String  dateToSubString(Date date){
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd") ;
		String format = formate.format(date) ;
		return format ;
	}
	   
	   @Test
	   public void testdata(){

		    String firstday = "2019-9-19" ;
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
		   try {
			   Date parse = format.parse(firstday);
			   Long l = parse.getTime() ;
			   Long timelong = parse.getTime() +  42*24*60*60*1000L ;
			   Date d= new Date(timelong) ;
			   String str = DateUtil.dateToString(d) ;
			   System.out.println(str);
		   } catch (ParseException e) {
			   e.printStackTrace();
		   }
	   }
}
