package cn.ymt.config;

import java.util.Arrays;
import java.util.List;

public class FilterUrl {
    private static String[] strArrays  = {
            "/test","/CollectAction/auth","/CollectAction/getCollect","/WorkAction/getMyself","/ShopcartAction/addToCart","/UserAction/get","/DetailAction/update",
            "/CollectAction/collect"
    } ;
    public static List<String> getFilterUrl(){
        return Arrays.asList(FilterUrl.strArrays) ;
    }
}
