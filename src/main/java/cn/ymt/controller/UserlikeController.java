package cn.ymt.controller;
import cn.ymt.pojo.User;
import cn.ymt.util.jsonResult;
import cn.ymt.view.UserlikeView;
import cn.ymt.serviceDao.UserlikeServiceDao;
import cn.ymt.query.UserlikeQueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/UserlikeAction")
public class UserlikeController  {
@Autowired
    private UserlikeServiceDao userlikeServiceDao ;
//用户点赞 传workId
@RequestMapping("/like")
public jsonResult like(UserlikeView userlikeView,HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("user");
        userlikeView.setUserId(u.getId());
    try {
        userlikeServiceDao.insert(userlikeView) ;
        return new jsonResult(true,userlikeView.getId()+"") ;
    } catch (Exception e) {
        e.printStackTrace();
        return new jsonResult(false,"点赞失败") ;
    }
}
}