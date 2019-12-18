package cn.ymt.controller;

import cn.ymt.pojo.User;
import cn.ymt.pojo.Video;
import cn.ymt.query.CourseQueryParams;
import cn.ymt.serviceDao.CourseServiceDao;
import cn.ymt.serviceDao.VideoServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.CourseView;
import cn.ymt.view.VideoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/CourseAction")
public class CourseController {
    @Autowired
    private CourseServiceDao courseServiceDao ;
    @Autowired
    private VideoServiceDao videoServiceDao ;
    @RequestMapping("/search")
    public jsonResult search(CourseQueryParams queryParams){
        try {
            List<CourseView> basic = courseServiceDao.getBasic(queryParams);
            long count = courseServiceDao.count(queryParams);
            return new jsonResult(true,"查询成功",count,basic) ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"查询失败") ;
        }

    }
    //课程搜索详细页
    @RequestMapping("/getById")
    public jsonResult getById(Integer id){
        try {
            CourseView courseview = courseServiceDao.getBasicById(id);
            jsonResult jsonResult = new jsonResult(true,"查询成功") ;
            jsonResult.add(courseview);
            return jsonResult ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"查询失败") ;
        }
    }

    //上传课程 json数据过来 post
    @PostMapping("/insert")
    public jsonResult insert(@RequestBody CourseView courseView, HttpServletRequest request){
        User u  = (User) request.getSession().getAttribute("user");
       /* courseView.setBackerImgUrl(u.getImgUrl());
        courseView.setBakerName(u.getName());*/
        try {
            int insert = courseServiceDao.insert(courseView);
            List<VideoView> videos = courseView.getVideos();
            for (VideoView videoView:videos) {
                videoView.setCourseId(courseView.getId());
                videoView.setUserId(u.getId());
                videoView.setCreateTime(new Date());
            }
            videoServiceDao.inserts(videos) ;
            return new jsonResult(true,"上传课程成功") ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"上传课程失败") ;
        }
    }
}