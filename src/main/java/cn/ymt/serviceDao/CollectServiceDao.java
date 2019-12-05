package cn.ymt.serviceDao;
import cn.ymt.view.CollectView;
import cn.ymt.dao.CollectDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceDao extends serviceDaoTemplate<CollectView,CollectDao> {

    public List<CollectView> getMyCollectCourse(Integer id) throws Exception{
        return dao.getMyCollectCourse(id);
    }

    public List<CollectView> getMyCollectDetail(Integer id) throws Exception{
        return dao.getMyCollectDetail(id) ;
    }
}