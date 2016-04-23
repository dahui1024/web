package com.bbcow.news.vo;

import java.util.List;

import com.bbcow.news.website.neatease.vo.NeatEaseVo;

public class Simple01Vo {
	private String id;
	private String name;
	private List<NeatEaseVo> articles;
	public Simple01Vo(String id,String name,List<NeatEaseVo> articles){
		this.id = id;
		this.name = name;
		this.articles = articles;
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
	public List<NeatEaseVo> getArticles() {
		return articles;
	}
	public void setArticles(List<NeatEaseVo> articles) {
		this.articles = articles;
	}
}
