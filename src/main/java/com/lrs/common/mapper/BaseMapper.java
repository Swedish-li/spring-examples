package com.lrs.common.mapper;

import java.io.Serializable;
import java.util.List;

import com.lrs.common.pojo.PageParam;

public interface BaseMapper<T, ID extends Serializable> {
	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	T queryById(ID id);

	/**
	 * 分页查询
	 * 
	 * @param param
	 * @return
	 */
	List<T> query4Page(PageParam<T> param);

	/**
	 * 新增
	 * 
	 * @param tArr
	 */
	void insert(T t);

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	@SuppressWarnings("unchecked")
	void delete(ID... ids);

	/**
	 * 更新
	 * 
	 * @param t
	 */
	void update(T t);

	/**
	 * 
	 * @param param
	 * @return
	 */
	int count(PageParam<T> param);

}
