package cn.ymt.controller;
import cn.ymt.pojo.User;
import cn.ymt.query.DetailQueryParams;
import cn.ymt.serviceDao.DetailServiceDao;
import cn.ymt.serviceDao.DetailimgServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.DetailView;
import cn.ymt.view.DetailimgView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/DetailAction")
public class DetailController {
    @Autowired
    private DetailServiceDao detailServiceDao ;
    @Autowired
    private DetailimgServiceDao detailimgServiceDao ;
    @RequestMapping("/getBasic")
    public jsonResult getBasic(DetailQueryParams queryParam) {
        try {
            List<DetailView> datas = detailServiceDao.getBasic(queryParam);
            jsonResult json = new jsonResult("查询成功");
            if (datas != null && datas.size() > 0)
                json.add(datas);
            if (queryParam.getRecordIndex() != null) {
                json.setTotal(detailServiceDao.count(queryParam));
            }
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false, "异常：" + e.getMessage());
        }
    }

    @RequestMapping("/getById")
    public jsonResult getById(Integer id)throws Exception{
        DetailView detailView = detailServiceDao.getBasicById(id);
        jsonResult jsonResult = new jsonResult(true,"查询成功") ;
        jsonResult.add(detailView);
        return jsonResult ;
    }

    @RequestMapping("/getDetailById")
    public jsonResult getDetailById(Integer id)throws Exception{
        DetailView detailView = detailServiceDao.getDetailById(id);
        jsonResult jsonResult = new jsonResult(true,"查询成功") ;
        jsonResult.add(detailView);
        return jsonResult ;
    }
    //得到自己的食谱
    @RequestMapping("/getMySelf")
    public jsonResult getMySelf(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        try {
            List<DetailView> lists = detailServiceDao.getMySelf(user.getId()) ;
            return new jsonResult(true,"查询成功",lists.size(),lists) ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"查询失败") ;
        }
    }
    //上传食谱 传递json过来 post方法
    @PostMapping("/insert")
    public jsonResult update(@RequestBody DetailView detailView, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        detailView.setAddTime(new Date());
        detailView.setState((byte)1);
        detailView.setUserId(user.getId());
        try {
            detailServiceDao.insert(detailView) ;
            List<DetailimgView> detailimgViews = detailView.getDetailimgViews();
            for (DetailimgView detailimgView:detailimgViews) {
                detailimgView.setDetailId(detailView.getId());
            }
            detailimgServiceDao.inserts(detailimgViews) ;
            return new jsonResult(true,"上传成功") ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"上传失败") ;
        }
    }
}