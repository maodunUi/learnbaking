package cn.ymt.serviceDao;
import cn.ymt.view.OrdersView;
import cn.ymt.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderServiceDao extends serviceDaoTemplate<OrdersView,OrderDao> {
@Autowired
    private OrderDao orderDao ;
    public OrdersView getByNumber(String out_trade_no) throws Exception{
        return orderDao.getByNumber(out_trade_no);
    }
}