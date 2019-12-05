package cn.ymt.controller;

import cn.ymt.pojo.Img;
import cn.ymt.pojo.User;
import cn.ymt.query.WorkQueryParams;
import cn.ymt.serviceDao.ImgServiceDao;
import cn.ymt.serviceDao.WorkServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.ImgView;
import cn.ymt.view.WorkView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/WorkAction")
public class WorkController  {
    @Autowired
    private WorkServiceDao workServiceDao ;
    @Autowired
    private ImgServiceDao imgServiceDao ;
    //上传食谱 不需要categoryId  传json对象 post
    @PostMapping("/add")
    public jsonResult  add(@RequestBody WorkView workView, HttpServletRequest request) throws Exception{
        User user = (User) request.getSession().getAttribute("user");
        workView.setAddTime(new Date());
        workView.setState((byte)1);
        workView.setUserId(user.getId());
        int id = workServiceDao.insert(workView) ;
        WorkView workView1 = workServiceDao.getBasicById(workView.getId());
        List<ImgView> imgs = workView.getImgs();
        for (ImgView img:imgs) {
            img.setWorkId(workView1.getId());
        }
        imgServiceDao.inserts(imgs) ; //插入到图片表
        jsonResult jsonResult = new jsonResult(true,"查询成功") ;
        jsonResult.add(workView1);
        return  jsonResult ;
    }
    //查询所有烘培
    @RequestMapping("/get")
    public jsonResult get(WorkQueryParams queryParams,HttpServletRequest request) throws Exception{
      /*  User user = (User) request.getSession().getAttribute("user");
        queryParams.setId(user.getId());*/
        List<WorkView> lists = workServiceDao.get(queryParams) ;
        long l = workServiceDao.count(queryParams) ;
        return new jsonResult(true,"查询成功",l,lists) ;
    }
}