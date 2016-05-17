package com.lrs.common.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jarvis.cache.annotation.Cache;
import com.lrs.common.dao.IBaseDao;
import com.lrs.common.pojo.PageParam;
import com.lrs.common.pojo.PageResult;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<T, ID extends Serializable> {
	@Resource
	protected SqlSessionFactory sqlSessionFactory;

	protected SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

	/** 子类实现接口名 */
	private Class<?> subClassInterfaceClass = null;

	public AbstractDao() {
		subClassInterfaceClass = (Class<?>) super.getClass()
				.getGenericInterfaces()[0];
	}
	public T queryById(ID id) {
		return (T) ((IBaseDao<T, Serializable>) getSqlSession().getMapper(
				subClassInterfaceClass)).queryById(id);
	}

	public PageResult<T> query4Page(PageParam<T> param) {
		return (PageResult<T>) (((IBaseDao<T, Serializable>) getSqlSession()
				.getMapper(subClassInterfaceClass)).query4Page(param));
	}

	public void insert(T... tArr) {
		((IBaseDao<T, Serializable>) getSqlSession().getMapper(
				subClassInterfaceClass)).insert(tArr);
	}

	public void delete(ID... ids) {
		((IBaseDao<T, Serializable>) getSqlSession().getMapper(
				subClassInterfaceClass)).delete(ids);
	}

	public void update(T t) {
		((IBaseDao<T, Serializable>) getSqlSession().getMapper(
				subClassInterfaceClass)).update(t);
	}
}
