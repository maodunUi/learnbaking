package cn.ymt.controller;

import cn.ymt.pojo.User;
import cn.ymt.pojo.Video;
import cn.ymt.query.CourseQueryParams;
import cn.ymt.query.OrdersQueryParams;
import cn.ymt.serviceDao.CourseServiceDao;
import cn.ymt.serviceDao.OrdersServiceDao;
import cn.ymt.serviceDao.VideoServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.CourseView;
import cn.ymt.view.OrdersView;
import cn.ymt.view.VideoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @Autowired
    private OrdersServiceDao ordersServiceDao ;
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
    //得到自己下单的课程
    @RequestMapping("/getMyCourse")
    public jsonResult getMyCourse(HttpServletRequest request, OrdersQueryParams queryParams){
        User user = (User) request.getSession().getAttribute("user");
       // OrdersView ordersView = new OrdersView() ;
        //ordersView.setUserId(user.getId());
        //List<OrdersView> ordersViews  = new ArrayList<>() ;
        //ordersViews.add(ordersView) ;
        //queryParams.setPojos(ordersViews);
        queryParams.setUserId(user.getId());
        try {
            List<OrdersView> basic = ordersServiceDao.getBasic(queryParams);
            List<Integer> ids = new ArrayList<>() ;  // 所有课程的id
            for (OrdersView orderv:basic) {
                if (orderv.getCourseId() != null){
                    ids.add(orderv.getCourseId()) ;
                }
            }
            CourseQueryParams courseQueryParams = new CourseQueryParams() ;
            courseQueryParams.setIds(ids);
            List<CourseView> courseViews = courseServiceDao.getBasic(courseQueryParams);
            long count = courseServiceDao.count(courseQueryParams);
            return new jsonResult(true,"查询成功",count,courseViews) ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,e.getMessage()) ;
        }
    }
}