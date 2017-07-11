package com.lrs.mapper;

import java.util.List;

import com.lrs.common.dao.IBaseDao;
import com.lrs.pojo.Area;

public interface AreaMapper extends IBaseDao<Area, Integer> {

	/**
	 * 根据地址父id，查询地址信息列表
	 * 
	 * @param parnetId
	 * @return
	 */
	public List<Area> queryByParentId(Integer parentId);
	
}
