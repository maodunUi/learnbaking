package cn.ymt.serviceDao;
import cn.ymt.pojo.Order;
import cn.ymt.view.OrderView;
import cn.ymt.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderServiceDao extends serviceDaoTemplate<OrderView,OrderDao> {
@Autowired
    private OrderDao orderDao ;
    public OrderView getByNumber(String out_trade_no) throws Exception{
        return orderDao.getByNumber(out_trade_no);
    }
}