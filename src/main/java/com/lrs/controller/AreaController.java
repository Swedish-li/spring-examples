package com.lrs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lrs.pojo.Area;
import com.lrs.service.AreaService;

@Controller
@RequestMapping("area")
public class AreaController {
	@Resource
	private AreaService areaService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	//@Cache(expire=600, autoload=true, key="'area.getId'+#hash(#args[0])")
	public ResponseEntity<Area> getArea(@PathVariable("id") Integer id) {
		Area area = areaService.queryArea(id);
		return new ResponseEntity<Area>(area, HttpStatus.OK);
	}

	@RequestMapping(value = "list/{parentId}", method = RequestMethod.GET)
	//@Cache(expire=600, autoload=true, key="'areas'+#hash(#args[0])")
	public ResponseEntity<List<Area>> getAreas(
			@PathVariable("parentId") Integer parentId) {
		List<Area> areas = areaService.queryAreas(parentId);
		return new ResponseEntity<List<Area>>(areas, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(Area area) {
		areaService.saveArea(area);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(Area area) {
		areaService.update(area);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(Integer id){
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
