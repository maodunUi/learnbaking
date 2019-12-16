package cn.ymt.dao;
import cn.ymt.pojo.Order;
import cn.ymt.view.OrderView;
import cn.ymt.query.OrderQueryParams;
import org.apache.ibatis.annotations.Param;

public interface OrderDao extends DaoTemplate<OrderView,OrderQueryParams>{

    //通过订单号找到订单
    OrderView getByNumber(@Param("number") String number) throws Exception;
}