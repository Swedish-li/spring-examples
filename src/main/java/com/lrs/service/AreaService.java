package com.lrs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lrs.mapper.AreaMapper;
import com.lrs.pojo.Area;

@Service
public class AreaService {
	@Resource
	private AreaMapper mapper;

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Area queryArea(Integer id) {
		return mapper.queryById(id);
	}

	/**
	 * 更加parentId查询
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Area> queryAreas(Integer parentId) {
		return mapper.queryByParentId(parentId);
	}

	/**
	 * 保存
	 * 
	 * @param area
	 */
	public void saveArea(Area area) {
		mapper.insert(area);
	}

	/**
	 * 更新
	 * 
	 * @param area
	 */
	public void update(Area area) {
		mapper.update(area);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void delete(Integer... ids) {
		mapper.delete(ids);
	}

}
