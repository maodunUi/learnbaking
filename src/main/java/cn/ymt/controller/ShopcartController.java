package cn.ymt.controller;
import cn.ymt.pojo.Shopcart;
import cn.ymt.pojo.User;
import cn.ymt.query.ShopcartQueryParams;
import cn.ymt.serviceDao.ShopcartServiceDao;
import cn.ymt.util.jsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/ShopcartAction")
public class ShopcartController {
    @Autowired
    private ShopcartServiceDao shopcartServiceDao ;

    //得到某个人的购物车列表
    @RequestMapping("/getCart")
    public jsonResult getCart(ShopcartQueryParams queryParams, HttpServletRequest request)throws Exception{
        User user = (User) request.getSession().getAttribute("user");
        queryParams.setUserId(user.getId());
        List<Shopcart> shopcartList = shopcartServiceDao.getCart(queryParams) ;
        return new jsonResult(true,"查询成功",shopcartList.size(),shopcartList) ;
    }
}