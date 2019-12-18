package cn.ymt.controller;
import cn.ymt.query.OrdersQueryParams;
import cn.ymt.serviceDao.OrdersServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.OrdersView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequestMapping("/OrderAction")
public class OrderController {
    @Autowired
    private OrdersServiceDao ordersServiceDao ;
    //展示所有订单
    @RequestMapping("/list")
    public jsonResult list(OrdersQueryParams queryParams){
        try {
            List<OrdersView> detail = ordersServiceDao.getDetail(queryParams);
            long count = ordersServiceDao.count(queryParams);
            return new jsonResult(true,"查询成功",count,detail) ;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false,e.getMessage()) ;
        }
    }

}