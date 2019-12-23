package cn.ymt.query;
import cn.ymt.view.OrdersView;
public class OrdersQueryParams extends QueryParams<OrdersView> {
    private Integer userId ;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}