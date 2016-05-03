package com.bbcow.news.vo;

import java.util.List;

import com.bbcow.news.website.AbstractVo;

public class Bvcow01Vo {
	private String id;
	private String name;
	private List<? extends AbstractVo> articles;
	public Bvcow01Vo(String id,String name,List<? extends AbstractVo> articles){
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
	public List<? extends AbstractVo> getArticles() {
		return articles;
	}
	public void setArticles(List<? extends AbstractVo> articles) {
		this.articles = articles;
	}
}
