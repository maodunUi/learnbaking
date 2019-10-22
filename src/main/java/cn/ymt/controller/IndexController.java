package cn.ymt.controller;

import cn.ymt.query.CourseQueryParams;
import cn.ymt.serviceDao.CategoryServiceDao;
import cn.ymt.serviceDao.CourseServiceDao;
import cn.ymt.serviceDao.DetailServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.CategoryView;
import cn.ymt.view.CourseView;
import cn.ymt.view.DetailView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/incex")
public class IndexController {
    @Autowired
    private DetailServiceDao detailServiceDao ;
    @Autowired
    private CourseServiceDao courseServiceDao ;
    @Autowired
    private CategoryServiceDao categoryServiceDao ;
    //得到首页的数据
    @RequestMapping("/get")
    public jsonResult get() throws Exception{
        List<DetailView> flists = detailServiceDao.getFour() ;
        List<DetailView> slists = detailServiceDao.getSix() ;
        List<Object> list = new ArrayList<>( ) ;
        list.add(flists) ;
        list.add(slists) ;
        return new jsonResult(true,"查询成功",list.size(),list) ;
    }
    //得到视频学堂的数据
    @RequestMapping("/getTwo")
    public jsonResult getTwo(CourseQueryParams queryParams) throws Exception{
      List<CategoryView> clist =  categoryServiceDao.getBasic(null) ;
        List<CourseView> flists = courseServiceDao.getFour(queryParams) ;
        List<CourseView> slists = courseServiceDao.getSix(queryParams) ;
        List<Object> list = new ArrayList<>( ) ;
        list.add(clist) ;
        list.add(flists) ;
        list.add(slists) ;
        return new jsonResult(true,"查询成功",list.size(),list) ;
    }
}
