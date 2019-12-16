package cn.ymt.serviceDao;
import cn.ymt.view.OrdersView;
import cn.ymt.dao.OrdersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrdersServiceDao extends serviceDaoTemplate<OrdersView,OrdersDao> {
@Autowired
    private OrdersDao ordersDao ;
    public OrdersView getByNumber(String out_trade_no) throws Exception{
        return ordersDao.getByNumber(out_trade_no);
    }
}