package com.lrs.mapper;

import java.util.List;

import com.lrs.common.mapper.BaseMapper;
import com.lrs.pojo.Area;

public interface AreaMapper extends BaseMapper<Area, Integer> {

	/**
	 * 根据地址父id，查询地址信息列表
	 * 
	 * @param parentId
	 * @return
	 */
    List<Area> queryByParentId(Integer parentId);
	
}
