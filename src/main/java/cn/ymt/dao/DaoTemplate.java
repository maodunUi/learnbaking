package cn.ymt.dao;
import java.util.List;
import cn.ymt.pojo.BasicModel;
import cn.ymt.query.QueryParams;
public interface DaoTemplate <T extends BasicModel,Query extends QueryParams>{
    int deleteById(Integer id) throws Exception;
    int deleteByIds(List<Integer> ids)throws Exception;
    int deleteObjects(List<T> objs)throws Exception;
    int deleteByParams(Query query)throws Exception;
    int saveNoNull(T record)throws Exception;
    int save(T record)throws Exception;
    int saves(List<T> objs)throws Exception;
    T getBasicById(Integer id)throws Exception;
    T getDetailById(Integer id)throws Exception;
    int updateAll(T record)throws Exception;
    int updateNoNull(T record)throws Exception;
  List<BasicModel> getSimple(Query query)throws Exception;
   List<T> getBasic(Query query)throws Exception;
    List<T> getDetail(Query query)throws Exception;
    long count(Query query)throws Exception;
    List<Integer> getDistinctIds(Query query)throws Exception;
}