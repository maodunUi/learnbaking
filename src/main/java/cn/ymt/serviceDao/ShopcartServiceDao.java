package cn.ymt.serviceDao;
import cn.ymt.pojo.Shopcart;
import cn.ymt.query.ShopcartQueryParams;
import cn.ymt.view.ShopcartView;
import cn.ymt.dao.ShopcartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopcartServiceDao extends serviceDaoTemplate<ShopcartView,ShopcartDao> {
    @Autowired
    private ShopcartDao shopcartDao ;
    public List<Shopcart> getCart(ShopcartQueryParams queryParams) throws Exception{
        return  shopcartDao.getCart(queryParams) ;
    }
}