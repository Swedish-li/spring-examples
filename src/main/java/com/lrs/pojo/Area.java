package com.lrs.pojo;

import java.io.Serializable;

public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String shortName;

	private Integer parentId;

	private Float longitude;

	private Float latitude;

	private Integer level;

	private Integer sort;

	private Integer status;

	public Area() {
	}

	public Area(Integer parentId2) {
		this.parentId = parentId2;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", shortName=" + shortName
				+ ", parentId=" + parentId + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", level=" + level + ", sort="
				+ sort + ", status=" + status + "]";
	}

}
