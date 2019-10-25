package cn.ymt.dao;
import cn.ymt.pojo.Shopcart;
import cn.ymt.view.ShopcartView;
import cn.ymt.query.ShopcartQueryParams;

import java.util.List;

public interface ShopcartDao extends DaoTemplate<ShopcartView,ShopcartQueryParams>{

    List<Shopcart> getCart(ShopcartQueryParams queryParams) throws Exception;
}