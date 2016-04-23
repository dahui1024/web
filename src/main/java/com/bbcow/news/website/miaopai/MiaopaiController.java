package com.bbcow.news.website.miaopai;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbcow.news.cache.DataCache;
import com.bbcow.news.website.miaopai.spider.AbstractMiaopaiSpider;

@Controller
@RequestMapping(value="miaopai")
public class MiaopaiController {
	@RequestMapping(value = "/{channle}")
	public String index(@PathVariable String channel,Model model){
		model.addAttribute("vList", DataCache.get(channel));
		model.addAttribute("page",1);
		model.addAttribute("type",channel);
		return "video_index";
	}
	@RequestMapping(value = "/page/{page}")
	public String page(HttpServletRequest request,@PathVariable int page,Model model){
		String key = request.getParameter("type");
		
		model.addAttribute("vList", AbstractMiaopaiSpider.getInstance(key).page((page+1)+""));
		model.addAttribute("page",page+1);
		model.addAttribute("type",key);
		return "video_index";
	}
	@RequestMapping(value = "/video/{id}{(.html)*}")
	public String detail(@PathVariable String id, @RequestParam String title, @RequestParam String length, Model model){
		model.addAttribute("video_url", AbstractMiaopaiSpider.detail(id));
		model.addAttribute("video_title", title);
		model.addAttribute("length", length);
		
		Random r = new Random();
		int i = r.nextInt(AbstractMiaopaiSpider.video_keys.length);
		
		model.addAttribute("videoList", DataCache.get(AbstractMiaopaiSpider.video_keys[i]));	
		
		return "miaopai/miaopai_detail";
	}
}
