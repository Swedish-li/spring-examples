package com.lrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lrs.pojo.Area;

public interface AreaDao {
	/**
	 * 根据id查询地址信息
	 * @param id 地址id
	 * @return 地址信息
	 */
	public Area queryById(Integer id);
	/**
	 * 根据地址父id，查询地址信息列表
	 * @param parnetId
	 * @return
	 */
	public List<Area> queryByParentId(Integer parentId);
	/**
	 * 新增地址信息
	 * @param area
	 */
	public void insert(Area area);
	/**
	 * 更新地址信息
	 * @param area
	 */
	public void update(Area area);
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(@Param("ids")Integer...id);

}
