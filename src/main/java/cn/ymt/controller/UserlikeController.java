package cn.ymt.controller;
import cn.ymt.pojo.User;
import cn.ymt.serviceDao.WorkServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.UserlikeView;
import cn.ymt.serviceDao.UserlikeServiceDao;
import cn.ymt.query.UserlikeQueryParams;
import cn.ymt.view.WorkView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@CrossOrigin
@RestController
@RequestMapping("/UserlikeAction")
public class UserlikeController  {
@Autowired
    private UserlikeServiceDao userlikeServiceDao ;
@Autowired
private WorkServiceDao workServiceDao ;
//用户点赞 传workId
@RequestMapping("/like")
public jsonResult like(UserlikeView userlikeView,HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("user");
        userlikeView.setUserId(u.getId());
    try {
        userlikeServiceDao.insert(userlikeView) ;
        WorkView workView = workServiceDao.getBasicById(userlikeView.getWorkId());
        workView.setCount(workView.getCount() + 1);
        workServiceDao.updateNotNullField(workView) ;
        return new jsonResult(true,userlikeView.getId()+"") ;
    } catch (Exception e) {
        e.printStackTrace();
        return new jsonResult(false,"点赞失败") ;
    }
}

//传来userlike 的 id
@RequestMapping("/nolike")
public jsonResult nolike(Integer id){
    try {
        UserlikeView userlikeView = userlikeServiceDao.getBasicById(id);
        Integer workId = userlikeView.getWorkId();
        WorkView workView = workServiceDao.getBasicById(workId);
        workView.setCount(workView.getCount() - 1);
        workServiceDao.updateNotNullField(workView) ;
        int i = userlikeServiceDao.deleteById(id);
        return new jsonResult(true,"取消点赞成功") ;
    } catch (Exception e) {
        e.printStackTrace();
        return new jsonResult(false,"取消点赞失败") ;
    }
}
}