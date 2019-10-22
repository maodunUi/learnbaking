package cn.ymt.serviceDao;

import java.util.ArrayList;
import java.util.List;


import cn.ymt.pojo.User;
import cn.ymt.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ymt.dao.DaoTemplate;
import cn.ymt.pojo.BasicModel;
import cn.ymt.query.QueryParams;

public abstract class serviceDaoTemplate<P extends BasicModel, DAO extends DaoTemplate> {
	@Autowired
	DAO dao;

	public int insert(P pojo) throws Exception {
		return dao.save(pojo);
	}

	public int inserts(List<P> pojos) throws Exception {
		int size = 0;
		size=dao.saves(pojos);
		return size;
	}

	public int deleteById(Integer id) throws Exception {
		return dao.deleteById(id);
	}

	public P getBasicById(Integer id) throws Exception {
		return (P) dao.getBasicById(id);
	}

	public P getDetailById(Integer id) throws Exception {
		return (P) dao.getDetailById(id);
	}
	
	public int updateAllField(P record) throws Exception {
		if (record.getId() == null)
			throw new Exception("对象的id为null");
		return dao.updateAll(record);
	};

	public int updateNotNullField(P record) throws Exception {
		if (record.getId() == null)
			throw new Exception("对象的id为null");
		return dao.updateNoNull(record);
	}

	// 更新集合中的所有对象的所有字段含null值字段
	public int updatesHasNull(List<P> pojos) throws Exception {
		int count = 0;
		if (ListUtil.isNotEmpty(pojos)) {
			for (int i = 0; i < pojos.size(); i++) {
				count = count + this.updateAllField(pojos.get(i));
			}
		}
		return count;
	};

	// 更新集合中的所有对象的非null字段
	public int updatesNotNull(List<P> pojos) throws Exception {
		int count = 0;
		if (ListUtil.isNotEmpty(pojos)) {
			for (int i = 0; i < pojos.size(); i++) {
				count = count + this.updateNotNullField(pojos.get(i));
			}
		}
		return count;
	}

	public List<P> getBasic(QueryParams queryParam) throws Exception {
		return dao.getBasic(queryParam);
	}
	

	
	public List<P> getDetail(QueryParams queryParam) throws Exception {
		return dao.getDetail(queryParam);
	}

	public int deleteByIds(List<Integer> ids) throws Exception {
		return dao.deleteByIds(ids);
	}

	public int deleteObjects(List<P> objs) throws Exception {
		return dao.deleteObjects(objs);
	}

	public long count(QueryParams queryParam) throws Exception {
		return dao.count(queryParam);
	}
	public List<Integer> getDistinctIds(QueryParams queryParam)throws Exception{
		return dao.getDistinctIds(queryParam);
	}
	
	public int deleteByParams(QueryParams query)throws Exception{
		return dao.deleteByParams(query);
	}



}
