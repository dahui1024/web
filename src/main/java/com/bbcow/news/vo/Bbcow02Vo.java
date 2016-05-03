package com.bbcow.news.vo;

import java.util.List;

import com.bbcow.news.website.AbstractVo;

public class Bbcow02Vo {
	private String id;
	private String name;
	private List<? extends AbstractVo> videos;
	public Bbcow02Vo(String id,String name,List<? extends AbstractVo> videos){
		this.id = id;
		this.name = name;
		this.videos = videos;
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
	public List<? extends AbstractVo> getVideos() {
		return videos;
	}
	public void setVideos(List<? extends AbstractVo> videos) {
		this.videos = videos;
	}
	
}
