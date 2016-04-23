package com.bbcow.news.website.kuaikan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.cache.DataCache;
import com.bbcow.news.website.kuaikan.spider.AbstractKuaiKanSpider;

@Controller
@RequestMapping(value="comic")
public class KuaiKanController {
	@RequestMapping(value = "/1")
	public String index(@PathVariable String channel,Model model){
		AbstractKuaiKanSpider akk = new AbstractKuaiKanSpider(); 
		model.addAttribute("cList", akk.list());
		return "comic_index";
	}
}
