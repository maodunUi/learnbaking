package cn.ymt.dao;
import cn.ymt.view.CollectView;
import cn.ymt.query.CollectQueryParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectDao extends DaoTemplate<CollectView,CollectQueryParams>{
   List<CollectView> getMyCollectDetail(@Param("id") Integer id) throws Exception;
   List<CollectView> getMyCollectCourse(@Param("id") Integer id) throws Exception;
}