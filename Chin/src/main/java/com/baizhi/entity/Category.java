package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	private String id;
	private String name;
	private String parentId;
	private int levels;
	
	private Category category;
	private List<Category> seconds;
	public Category() {
		super();
	}
	public Category(String id, String name, String parentId, int levels,
			Category category, List<Category> seconds) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.levels = levels;
		this.category = category;
		this.seconds = seconds;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getSeconds() {
		return seconds;
	}
	public void setSeconds(List<Category> seconds) {
		this.seconds = seconds;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", levels=" + levels + ", category=" + category
				+ ", seconds=" + seconds + "]";
	}

	
}
