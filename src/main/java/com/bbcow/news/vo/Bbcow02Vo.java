package com.bbcow.news.vo;

import java.util.List;

import com.bbcow.news.website.miaopai.vo.MiaopaiVo;
import com.bbcow.news.website.neatease.vo.NeatEaseVo;

public class Bbcow02Vo {
	private String id;
	private String name;
	private List<MiaopaiVo> videos;
	public Bbcow02Vo(String id,String name,List<MiaopaiVo> videos){
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
	public List<MiaopaiVo> getVideos() {
		return videos;
	}
	public void setVideos(List<MiaopaiVo> videos) {
		this.videos = videos;
	}
	
}
