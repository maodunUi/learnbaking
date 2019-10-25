package cn.ymt.controller;

import cn.ymt.query.CourseQueryParams;
import cn.ymt.serviceDao.CourseServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.CourseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/CourseAction")
public class CourseController {
    @Autowired
    private CourseServiceDao courseServiceDao ;
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
}