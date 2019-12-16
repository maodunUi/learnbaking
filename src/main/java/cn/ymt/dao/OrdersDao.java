package cn.ymt.dao;
import cn.ymt.view.OrdersView;
import cn.ymt.query.OrdersQueryParams;
import org.apache.ibatis.annotations.Param;

public interface OrdersDao extends DaoTemplate<OrdersView,OrdersQueryParams>{
  //通过订单号找到订单
    OrdersView getByNumber(@Param("number") String number) throws Exception;
}