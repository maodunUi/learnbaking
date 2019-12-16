package cn.ymt.dao;
import cn.ymt.view.WorkView;
import cn.ymt.query.WorkQueryParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkDao extends DaoTemplate<WorkView,WorkQueryParams>{

    List<WorkView> get(WorkQueryParams queryParams) throws Exception;

    List<WorkView> getMyself(@Param("id") Integer id) throws Exception ;

    WorkView getById(@Param("id") int id) throws Exception;
}