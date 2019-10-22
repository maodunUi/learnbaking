package cn.ymt.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import cn.ymt.pojo.BasicModel;

public class ListUtil {
	// 集合为空
	public static boolean isEmpty(List list) {
		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	// 集合不为空
	public static boolean isNotEmpty(List list) {
		return isEmpty(list) != true;
	}

	// 集合为空
	public static boolean isEmpty(Object[] list) {
		if (list == null || list.length == 0)
			return true;
		return false;
	}

	// 集合不为空
	public static boolean isNotEmpty(Object[] list) {
		return isEmpty(list) != true;
	}

	public static boolean isEmpty(Set list) {
		if (list == null || list.size() == 0)
			return true;
		return false;
	}

	// 集合不为空
	public static boolean isNotEmpty(Set list) {
		return isEmpty(list) != true;
	}

	public static Map<String, Set> SetCompareSet(Set newDatas, Set oldDatas) {
		if (ListUtil.isEmpty(newDatas))
			newDatas = new HashSet(0);
		if (ListUtil.isEmpty(oldDatas))
			oldDatas = new HashSet(0);
		Map<String, Set> map = new HashMap<String, Set>(0);
		Set temp = new HashSet(newDatas);
		temp.retainAll(oldDatas);
		newDatas.removeAll(temp);
		oldDatas.removeAll(temp);
		map.put("addOrUpdate", newDatas);
		map.put("delete", oldDatas);
		return map;
	}

	public static Map<String, List> ListCompareList(List newDatas, List oldDatas) {

		if (ListUtil.isEmpty(newDatas)) {
			newDatas = new ArrayList(0);
		}
		if (ListUtil.isEmpty(oldDatas)) {
			oldDatas = new ArrayList(0);
		}

		Map<String, List> map = new HashMap<String, List>(0);
		List temp = new ArrayList(newDatas);
		temp.retainAll(oldDatas);// temp仅保留相同的元素
		newDatas.removeAll(temp);
		oldDatas.removeAll(temp);
		map.put("addOrUpdate", newDatas);
		map.put("delete", oldDatas);
		return map;
	}

	
	/** 把装有对象的list对象转换为装有数组的list对象
	 * @param <T>
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static <T> List<Object[]> listToListArray(List<T> lists) throws Exception{
		int size = lists.size() ;
		List<Object[]> list = new ArrayList<>() ;
		String[] arr = new String[size] ;
		for(int i = 0 ; i < size ; i++){
			 Class<? extends Object> className = lists.get(i).getClass() ; //得到class对象
			Field[] field = className.getDeclaredFields() ; //得到所有的字段
			int fieldsLen = field.length ; //字段长度
			for(int j = 0 ; j < fieldsLen ; j++){
				String name = field[j].getName() ; //得到字段名称
				Class<?> type = field[j].getType() ; //得到字段类型
				String nameFirst = name.substring(0,1) ; //得到字段名称第一个字母
				nameFirst = nameFirst.toUpperCase() ; //改变字母大写
				name = name.substring(1,name.length()) ; //得到除第一个字母外的字符串
				name = nameFirst + name ; //拼接字符串
				Method method = className.getMethod("get" + name, type) ;
				if(type==String.class){
					list.get(i)[j] = (String) method.invoke(className) ;
				}else if(type==Integer.class){
					list.get(i)[j] = (Integer) method.invoke(className) ;
				}else if(type==Long.class){
					list.get(i)[j] = (Long) method.invoke(className) ;
				}else if(type==Double.class){
					list.get(i)[j] = (Double) method.invoke(className) ;
				}else if(type==Byte.class){
					list.get(i)[j] = (Byte) method.invoke(className) ;
				}
			}
		}
		return list;
	}
}
