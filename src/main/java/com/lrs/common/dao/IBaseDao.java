package com.lrs.common.dao;

import java.io.Serializable;

import com.lrs.common.pojo.PageParam;
import com.lrs.common.pojo.PageResult;

public interface IBaseDao<T, ID extends Serializable> {
	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public T queryById(ID id);

	/**
	 * 分页查询
	 * @param param
	 * @return
	 */
	public PageResult<T> query4Page(PageParam<T> param);
	/**
	 * 新增
	 * @param tArr
	 */
	@SuppressWarnings("unchecked")
	public void insert(T...tArr);
	/**
	 * 删除
	 * @param ids
	 */
	@SuppressWarnings("unchecked")
	public void delete(ID...ids);
	/**
	 * 更新
	 * @param t
	 */
	public void update(T t);

}
