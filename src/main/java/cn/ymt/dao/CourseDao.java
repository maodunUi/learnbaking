package cn.ymt.dao;
import cn.ymt.view.CourseView;
import cn.ymt.query.CourseQueryParams;

import java.util.List;

public interface CourseDao extends DaoTemplate<CourseView,CourseQueryParams>{

    List<CourseView> getSix(CourseQueryParams queryParams) throws Exception;

    List<CourseView> getFour(CourseQueryParams queryParams) throws Exception;
}