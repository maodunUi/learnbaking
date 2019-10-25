package cn.ymt.query;
import cn.ymt.view.ShopcartView;
public class ShopcartQueryParams extends QueryParams<ShopcartView> {
    private Integer userId ;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}