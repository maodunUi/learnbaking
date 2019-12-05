package cn.ymt.dao;
import cn.ymt.view.DetailView;
import cn.ymt.query.DetailQueryParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DetailDao extends DaoTemplate<DetailView,DetailQueryParams>{

    List<DetailView> getFour() throws Exception;

    List<DetailView> getSix() throws Exception;

    List<DetailView> getMySelf(@Param("id") Integer id) throws Exception ;

}