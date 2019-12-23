package cn.ymt.controller;
import cn.ymt.util.jsonResult;
import cn.ymt.view.VideoView;
import cn.ymt.serviceDao.VideoServiceDao;
import cn.ymt.query.VideoQueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/VideoAction")
public class VideoController  {
@Autowired
    private VideoServiceDao videoServiceDao ;
    //通过课程id 得到课程的视频
    @RequestMapping("/getVideoByCourseId")
    public jsonResult getVideoByCourseId(VideoQueryParams queryParams){
        //VideoView videoView = new VideoView() ;
        //queryParams.setPojos(pojos);
        try {
            List<VideoView> basic = videoServiceDao.getBasic(queryParams);
            long count = videoServiceDao.count(queryParams);
return new jsonResult(true,"查询成功",count,basic) ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,e.getMessage()) ;
        }
    }

}