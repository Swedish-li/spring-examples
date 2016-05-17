package com.lrs.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jarvis.cache.annotation.Cache;
import com.lrs.common.dao.impl.AbstractDao;
import com.lrs.dao.AreaDao;
import com.lrs.pojo.Area;

@Repository
public class AreaDaoImpl  extends AbstractDao<Area, Integer> implements AreaDao {
	
	@Override
	@Cache(expire=600, autoload=true, key="'area-list-'+#hash(#args)")
	public List<Area> queryByParentId(Integer parentId) {
		return this.getSqlSession().getMapper(AreaDao.class).queryByParentId(parentId);
	}
	@Cache(expire=600, autoload=true, key="'area-id-'+#hash(#args[0])")
	public Area queryById(Integer id){
		return this.getSqlSession().getMapper(AreaDao.class).queryById(id);
	}


}
