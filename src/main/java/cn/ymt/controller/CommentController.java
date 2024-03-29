package cn.ymt.controller;
import cn.ymt.pojo.User;
import cn.ymt.serviceDao.UserServiceDao;
import cn.ymt.serviceDao.WorkServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.CommentView;
import cn.ymt.serviceDao.CommentServiceDao;
import cn.ymt.query.CommentQueryParams;
import cn.ymt.view.UserView;
import cn.ymt.view.WorkView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/CommentAction")
public class CommentController  {

    @Autowired
    private CommentServiceDao commentServiceDao ;
    @Autowired
    private WorkServiceDao workServiceDao ;
    @Autowired
    private UserServiceDao userServiceDao ;
    //添加评论
    @RequestMapping("/addComment")
    public jsonResult addComment(CommentView commentView , HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
jsonResult jsonResult = new jsonResult( );
        UserView userView = null;
        try {
          //  WorkView work = workServiceDao.getBasicById(commentView.getWorkId());
            if (commentView.getId() != null){
                CommentView comm = commentServiceDao.getBasicById(commentView.getId()); // 通过传过来的评论id 找到 评论的用户id userid
                userView = userServiceDao.getBasicById(comm.getUserId());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"添加评论失败" + e.getMessage()) ;
        }
        commentView.setUserId(user.getId());
        commentView.setCommentTime(new Date());
        CommentView comment ;
        try {
            commentView.setId(null);
            commentServiceDao.insert(commentView) ;
             comment = commentServiceDao.getBasicById(commentView.getId());
           // return new jsonResult(true,"添加评论成功") ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,"添加评论失败" + e.getMessage()) ;
        }
        jsonResult.setSuccess(true);
        if (commentView.getParentId()==null){ //对work评论
            jsonResult.setMsg(user.getNickName());
            jsonResult.add(comment);
            jsonResult.add(user);
               // return new jsonResult(true,"" + user.getName()) ;
            return  jsonResult ;
        }else {
            jsonResult.setMsg(user.getNickName());
            jsonResult.add(comment);
            jsonResult.add(user);
            return jsonResult ;

                //return new jsonResult(true,user.getName() + "：" + userView.getName());
        }
    }


}