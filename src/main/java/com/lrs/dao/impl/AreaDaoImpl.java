package com.lrs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.jarvis.cache.annotation.Cache;
import com.lrs.dao.AreaDao;
import com.lrs.pojo.Area;

@Repository
public class AreaDaoImpl implements AreaDao {
	@Resource
	private SqlSessionFactory sqlSessionFactory;

	private SqlSession getSqlSession() {
		return this.sqlSessionFactory.openSession();
	}

	@Override
	@Cache(expire=600, autoload=true, key="'area.getId'+#hash(#args[0])")
	public Area queryById(Integer id) {
		return this.getSqlSession().getMapper(AreaDao.class).queryById(id);
	}

	@Override
	@Cache(expire=600, autoload=true, key="'areas.getAreas'+#hash(#args)")
	public List<Area> queryByParentId(Integer parentId) {
		return this.getSqlSession().getMapper(AreaDao.class).queryByParentId(parentId);
	}

	@Override
	public void insert(Area area) {
		this.getSqlSession().getMapper(AreaDao.class).insert(area);

	}

	@Override
	public void update(Area area) {
		this.getSqlSession().getMapper(AreaDao.class).update(area);
	}

	@Override
	public void delete(Integer... id) {
		
		this.getSqlSession().getMapper(AreaDao.class).delete(id);
	}

}
