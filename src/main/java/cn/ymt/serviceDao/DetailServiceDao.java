package cn.ymt.serviceDao;
import cn.ymt.view.DetailView;
import cn.ymt.dao.DetailDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceDao extends serviceDaoTemplate<DetailView,DetailDao> {

    public List<DetailView> getFour() throws Exception{
        return dao.getFour() ;
    }

    public List<DetailView> getSix() throws Exception{
        return dao.getSix() ;
    }
}