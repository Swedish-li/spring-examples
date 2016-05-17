package com.lrs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lrs.dao.AreaDao;
import com.lrs.pojo.Area;

@Service
public class AreaService {
	@Resource
	private AreaDao areaDao;
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Area queryArea(Integer id) {
		return this.areaDao.queryById(id);
	}
	/**
	 * 更加parentId查询
	 * @param parentId
	 * @return
	 */
	public List<Area> queryAreas(Integer parentId) {
		return this.areaDao.queryByParentId(parentId);
	}
	/**
	 * 保存
	 * @param area
	 */
	public void saveArea(Area area) {
		areaDao.insert(area);
	}
	/**
	 * 更新
	 * @param area
	 */
	public void update(Area area) {
		areaDao.update(area);
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer...ids){
		areaDao.delete(ids);
	}
	
}
