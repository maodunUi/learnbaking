package cn.ymt.serviceDao;
import cn.ymt.query.CourseQueryParams;
import cn.ymt.view.CourseView;
import cn.ymt.dao.CourseDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceDao extends serviceDaoTemplate<CourseView,CourseDao> {

    public List<CourseView> getSix(CourseQueryParams queryParams) throws Exception{
        return  dao.getSix(queryParams) ;
    }

    public List<CourseView> getFour(CourseQueryParams queryParams) throws Exception{
        return dao.getFour(queryParams) ;
    }
}