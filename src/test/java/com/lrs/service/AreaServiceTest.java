package com.lrs.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lrs.pojo.Area;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class AreaServiceTest extends AbstractJUnit4SpringContextTests {
	@Resource
	private AreaService areaService;
	@Test
	public void testQueryArea() {
		Area area=areaService.queryArea(2342334);
		System.out.println(area);
	}

	@Test
	public void testQueryAreas() {
		List<Area> areas =areaService.queryAreas(0);
		for (Area area : areas) {
			System.out.println(area);
		}
	}

	@Test
	public void testSaveArea() {
		Area area1=new Area();
		area1.setId(2342334);
		area1.setName("英国");
		area1.setShortName("英");
		area1.setParentId(0);
		area1.setLongitude(22334.2F);
		area1.setLatitude(1112.2F);
		area1.setLevel(0);
		area1.setSort(0);
		area1.setStatus(1);
		areaService.saveArea(area1);
		
	}

	@Test
	public void testUpdate() {
		Area area1=new Area();
		area1.setId(2342334);
		area1.setName("英国22222");
		area1.setShortName("英1");
		area1.setParentId(2);
		area1.setLongitude(1111.0F);
		area1.setLatitude(122222.2F);
		area1.setLevel(2);
		area1.setSort(4);
		area1.setStatus(2);
		areaService.update(area1);
	}

	@Test
	public void testDelete() {
		areaService.delete(2342334);
	}

}
