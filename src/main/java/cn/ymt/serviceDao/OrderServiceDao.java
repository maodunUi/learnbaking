package cn.ymt.serviceDao;
import cn.ymt.view.OrderView;
import cn.ymt.dao.OrderDao;
import org.springframework.stereotype.Service;
@Service
public class OrderServiceDao extends serviceDaoTemplate<OrderView,OrderDao> {

}