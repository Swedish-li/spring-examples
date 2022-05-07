package com.lrs.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.lrs.pojo.Area;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 根据方法名的字典顺序
public class AreaServiceTest extends AbstractJUnit4SpringContextTests {
    @Resource
    private AreaService areaService;

    private final Integer testId;

    private final Integer testParentId;

    {
        testId = 2342;
        testParentId = 1234;
    }

    private void createArea() {
        final Area area = new Area(testParentId);
        area.setId(888);
        area.setLatitude(11F);
        area.setLongitude(22F);
        areaService.saveArea(area);
    }

    @Test
    public void test0QueryAreas() {
        createArea();
        List<Area> areas = areaService.queryAreas(testParentId);
        Area area = areas.get(0);

        assertThat(areas.size(), is(1));
        assertThat(area.getId(), is(888));
        assertThat(area.getParentId(), is(testParentId));

        areaService.delete(888);

    }

    @Test
    public void test1SaveArea() {
        Area area1 = new Area();
        area1.setId(testId);
        area1.setName("英国");
        area1.setShortName("英");
        area1.setParentId(12);
        area1.setLongitude(100.2F);
        area1.setLatitude(12.2F);
        area1.setLevel(0);
        area1.setSort(0);
        area1.setStatus(1);
        areaService.saveArea(area1);

    }

    @Test
    public void test2QueryArea() {
        Area area = areaService.queryArea(testId);

        assertNotNull(area);
        assertThat(area.getId(), is(testId));
        assertThat(area.getName(), equalTo("英国"));
        assertThat(area.getShortName(), equalTo("英"));
        assertThat(area.getParentId(), is(12));
    }

    @Test
    public void test3Update() {
        Area area1 = new Area();
        area1.setId(testId);
        area1.setName("英国22222");
        area1.setShortName("英1");
        area1.setParentId(2);
        // (-180.000000, 180.000000].
        area1.setLongitude(111.0F);
//        within [-90.000000, 90.000000].
        area1.setLatitude(80.2F);
        area1.setLevel(2);
        area1.setSort(4);
        area1.setStatus(2);
        areaService.update(area1);

        // 查询断言
        Area area = areaService.queryArea(testId);

        assertTrue(area1.equals(area));
    }

    @Test
    public void test4Delete() {
        areaService.delete(testId);

        // 查询断言
        Area area = areaService.queryArea(testId);

        assertNull(area);
    }

}
