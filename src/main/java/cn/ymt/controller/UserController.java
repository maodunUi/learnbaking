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

@CrossOrigin
@RestController
@RequestMapping("/UserAction")
public class UserController {
    @Autowired
    private UserServiceDao userServiceDao ;
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
            return new jsonResult(true,"更新成功") ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(true,"更新失败") ;
        }
    }


}