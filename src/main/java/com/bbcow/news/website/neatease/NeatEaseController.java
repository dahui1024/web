package com.bbcow.news.website.neatease;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.website.neatease.spider.AbstractNeatEaseSpider;

@Controller
@RequestMapping(value="/netease")
public class NeatEaseController {
	@RequestMapping(value = "/{channel}")
	public String index(@PathVariable String channel,Model model){
		model.addAttribute("news", AbstractNeatEaseSpider.getInstance(channel).list());
		model.addAttribute("page",1);
		model.addAttribute("channel",channel);
		return "news_index";
	}
	@RequestMapping(value = "/page/{page}")
	public String page(HttpServletRequest request,@PathVariable int page,Model model){
		String channel = request.getParameter("channel");
		
		model.addAttribute("news", AbstractNeatEaseSpider.getInstance(channel).page(page));
		model.addAttribute("page",page+1);
		model.addAttribute("channel",channel);
		return "news_index";
	}
	@RequestMapping(value = "/post/{postId}{(.html)*}")
	public String detail(@PathVariable String postId,Model model){
		Map<String, String> detail = AbstractNeatEaseSpider.detail(postId.substring(0, postId.lastIndexOf(".html")));
		model.addAttribute("detail", detail);
		return "netease/detail";
	}
	@RequestMapping(value = "/photo/{photoId}{(.html)*}")
	public String photo(@PathVariable String photoId,Model model){
		String[] content = new String[2];
		List<String[]> detail = AbstractNeatEaseSpider.photo(photoId.substring(0, photoId.lastIndexOf(".html")),content);
		model.addAttribute("photo_title", content[0]);
		model.addAttribute("dkeys", content[1]);
		model.addAttribute("detail", detail);
		return "netease/photo";
	}
}
