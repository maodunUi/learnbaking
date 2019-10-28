package cn.ymt.dao;
import cn.ymt.view.WorkView;
import cn.ymt.query.WorkQueryParams;

import java.util.List;

public interface WorkDao extends DaoTemplate<WorkView,WorkQueryParams>{

    List<WorkView> get(WorkQueryParams queryParams) throws Exception;
}