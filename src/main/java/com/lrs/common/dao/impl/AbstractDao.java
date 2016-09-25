package com.lrs.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.lrs.common.dao.IBaseDao;
import com.lrs.common.pojo.PageParam;
import com.lrs.common.pojo.PageResult;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<T, ID extends Serializable> {
	@Resource
	protected SqlSession sqlSession;

	/** 子类实现接口名 */
	private Class<?> subClassInterfaceClass = null;

	public AbstractDao() {
		subClassInterfaceClass = (Class<?>) super.getClass()
				.getGenericInterfaces()[0];
	}

	public T queryById(ID id) {
		return (T) ((IBaseDao<T, Serializable>) sqlSession
				.getMapper(subClassInterfaceClass)).queryById(id);
	}

	public List<T> query4Page(PageParam<T> param) {
		return (List<T>) (((IBaseDao<T, Serializable>) sqlSession
				.getMapper(subClassInterfaceClass)).query4Page(param));
	}

	public void insert(T t) {
		((IBaseDao<T, Serializable>) sqlSession
				.getMapper(subClassInterfaceClass)).insert(t);
	}

	public void delete(ID... ids) {
		((IBaseDao<T, Serializable>) sqlSession
				.getMapper(subClassInterfaceClass)).delete(ids);
	}

	public void update(T t) {
		((IBaseDao<T, Serializable>) sqlSession
				.getMapper(subClassInterfaceClass)).update(t);
	}

	public int count(PageParam<T> param) {
		return ((IBaseDao<T, Serializable>) sqlSession
				.getMapper(subClassInterfaceClass)).count(param);
	}
}
