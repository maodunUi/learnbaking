package cn.ymt.controller;
import cn.ymt.pojo.User;
import cn.ymt.util.jsonResult;
import cn.ymt.view.DetailView;
import cn.ymt.view.UserView;
import cn.ymt.serviceDao.UserServiceDao;
import cn.ymt.query.UserQueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/UserAction")
public class UserController {
    @Autowired
    private UserServiceDao userServiceDao ;
    //得到当前的用户
    @RequestMapping("/get")
    public jsonResult get(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        jsonResult jsonResult = new jsonResult() ;
        jsonResult.add(user);
        jsonResult.setSuccess(true);
        return jsonResult ;
    }

    //修改个人信息
    @RequestMapping("/update")
    public jsonResult update(UserView detailView, HttpServletRequest request){
        try {
            userServiceDao.updateNotNullField(detailView) ;
            User user = (User) request.getSession().getAttribute("user");
            UserView userView = userServiceDao.getBasicById(user.getId());
            request.getSession().setAttribute("user",userView) ;
            return new jsonResult(true,"更新成功") ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(true,"更新失败") ;
        }
    }

    //得到所有的用户列表
    @RequestMapping("/list")
    public jsonResult list(UserQueryParams queryParams){
        try {
            List<UserView> basic = userServiceDao.getBasic(queryParams);
            long count = userServiceDao.count(queryParams);
            return new jsonResult(true,"查询成功",count,basic) ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"查询失败") ;
        }
    }
    //得到用户的登录状态
    @RequestMapping("/getUserStatus")
    public jsonResult getUserStatus(HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("user");
        if (u == null){
            return new jsonResult(false,"未登录") ;
        }else {
            return new jsonResult(true,"已经登录") ;
        }
    }

}