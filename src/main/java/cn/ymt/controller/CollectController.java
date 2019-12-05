package cn.ymt.controller;
import cn.ymt.pojo.Collect;
import cn.ymt.pojo.User;
import cn.ymt.util.jsonResult;
import cn.ymt.view.CollectView;
import cn.ymt.serviceDao.CollectServiceDao;
import cn.ymt.query.CollectQueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/CollectAction")
public class CollectController  {
    @Autowired
    private CollectServiceDao collectServiceDao ;
    //得到用户自己的收藏
    @RequestMapping("/getCollect")
    public jsonResult getCollect(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        try {
            List<CollectView> details = collectServiceDao.getMyCollectDetail(user.getId()) ;
            List<CollectView> collectViews = collectServiceDao.getMyCollectCourse(user.getId()) ;
            List<Object> lists = new ArrayList<>() ;
            lists.add(details) ;
            lists.add(collectViews) ;
            long l = details.size() + collectViews.size() ;
            return new jsonResult(true,"查询成功",l,lists) ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"失败") ;
        }
    }
    //用户收藏  type courseId[detailId]
    //0:detailId 1:courseId
    @RequestMapping("/collect")
    public jsonResult collect(CollectView collect,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        collect.setUserId(user.getId());
        collect.setCollectTime(new Date());
        try {
            collectServiceDao.insert(collect) ;
            return new jsonResult(true,"收藏成功") ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"收藏失败") ;
        }
    }
    //取消收藏 id collect的id
    @RequestMapping("/cancel")
    public jsonResult cancel(Integer id){
        try {
            collectServiceDao.deleteById(id) ;
            return new jsonResult(true,"取消收藏成功") ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"取消收藏失败") ;
        }
    }
}