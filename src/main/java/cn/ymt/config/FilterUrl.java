package cn.ymt.config;

import cn.ymt.view.CourseView;
import cn.ymt.view.VideoView;
import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterUrl {
    private static String[] strArrays  = {
            "/test","/CollectAction/auth","/CollectAction/getCollect","/WorkAction/getMyself","/ShopcartAction/addToCart","/UserAction/get","/DetailAction/update",
            "/CollectAction/collect","/getUserStatus","/CourseAction/getMyCourse"
    } ;
    public static List<String> getFilterUrl(){
        return Arrays.asList(FilterUrl.strArrays) ;
    }


    /*

    {
	"bakerName": "aa",
	"addTime": 1576648175966,
	"backerImgUrl": "aa.com",
	"videos": [{
		"createTime": 1576648175966,
		"memo": "0号"
	}, {
		"createTime": 1576648175966,
		"memo": "1号"
	}]
}
     */
  /*  @Test
    public void myTest(){
        CourseView courseView = new CourseView() ;
        courseView.setBakerName("aa");
        courseView.setBackerImgUrl("aa.com");

        List<VideoView> videoViews = new ArrayList<>() ;
        for (int i = 0 ; i < 2 ; i++){
            VideoView videoView = new VideoView() ;
            videoView.setMemo(i+"号");
            videoViews.add(videoView) ;
        }
        courseView.setVideos(videoViews);
        System.out.println(JSON.toJSON(courseView));
    }*/
}
