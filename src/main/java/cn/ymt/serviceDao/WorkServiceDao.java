package cn.ymt.serviceDao;
import cn.ymt.query.WorkQueryParams;
import cn.ymt.view.WorkView;
import cn.ymt.dao.WorkDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceDao extends serviceDaoTemplate<WorkView,WorkDao> {

    public List<WorkView> get(WorkQueryParams queryParams) throws Exception{
        return  dao.get(queryParams) ;
    }

    public List<WorkView> getMyself(Integer id) throws Exception{
        return dao.getMyself(id) ;
    }

    public WorkView getById(int id) throws Exception{
        return dao.getById(id) ;
    }
}