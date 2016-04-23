package com.bbcow.news.website.migu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.cache.DataCache;
import com.bbcow.news.website.migu.spider.AbstractMiguSpider;
import com.bbcow.news.website.migu.vo.MiguVo;

@Controller
@RequestMapping(value="/migu")
public class MiguController {
	@RequestMapping(value = "/{channel}")
	public String index(@PathVariable String channel , Model model){
		model.addAttribute("vList", DataCache.get(channel));
		return "migu_index";
	}
	@RequestMapping(value = "/video{(.html)*}/{param}")
	public String detail(@PathVariable String param,Model model){
		MiguVo vo = AbstractMiguSpider.detail(param.replace(";", "&"));
		model.addAttribute("video_url", vo.getPlayUrl());
		model.addAttribute("video_title", vo.getName());
		model.addAttribute("length", "直播");
		return "migu/migu_detail";
	}
}
