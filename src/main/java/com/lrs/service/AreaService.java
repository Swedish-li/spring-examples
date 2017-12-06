package com.lrs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lrs.mapper.AreaMapper;
import com.lrs.pojo.Area;

@Service
@CacheConfig(cacheNames = "area")
public class AreaService {

    @Resource
    private AreaMapper mapper;

    /**
     * 根据id查询
     *
     * @param id 区域id
     * @return id 所对应的区域详情
     */
    @Cacheable(key = "'queryArea_' + #id", condition = "null != #id")
    public Area queryArea(Integer id) {
        return mapper.queryById(id);
    }

    /**
     * 更加parentId查询
     *
     * @param parentId 区域父id
     * @return 子区域列表
     */
    @Cacheable(key = "'queryAreas_' + #parentId")
    public List<Area> queryAreas(Integer parentId) {
        return mapper.queryByParentId(parentId);
    }

    /**
     * 保存
     *
     * @param area 区域信息
     */
    public void saveArea(Area area) {
        mapper.insert(area);
    }

    /**
     * 更新
     *
     * @param area 更新区域
     */
    @CacheEvict(allEntries = true)
    public void update(Area area) {
        mapper.update(area);
    }

    /**
     * 批量删除
     *
     * @param ids 所要删除的区域id
     */
    @CacheEvict(allEntries = true)
    public void delete(Integer... ids) {
        mapper.delete(ids);
    }

}
