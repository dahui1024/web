package com.bbcow.news.website.kuaikan;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbcow.news.website.kuaikan.spider.KuaiKanSpider;
import com.bbcow.news.website.kuaikan.vo.KuaiKanVO;

@Controller
@RequestMapping(value="comic")
public class KuaiKanController {
	@RequestMapping(value = "")
	public String index(Model model){
		KuaiKanSpider akk = new KuaiKanSpider(); 
		model.addAttribute("cList", akk.list());
		model.addAttribute("page", 0);
		return "comic_index";
	}
	@RequestMapping(value = "/page/{page}")
	public String page(@PathVariable int page,Model model){
		KuaiKanSpider akk = new KuaiKanSpider(); 
		model.addAttribute("cList", akk.page(page+1));
		model.addAttribute("page", page+1);
		return "comic_index";
	}
	@RequestMapping(value = "/catalog/{id}")
	public String catalog(@PathVariable String id,Model model){
		KuaiKanSpider akk = new KuaiKanSpider(); 
		List<KuaiKanVO> list = akk.catalog(id);
		model.addAttribute("cList", list);
		if(list.size()>0){
			model.addAttribute("desc", list.get(0).getDesc());
		}
		return "comic_index";
	}
	@RequestMapping(value = "/detail/{id}")
	public String page(@PathVariable String id,@RequestParam String cid,Model model){
		KuaiKanSpider akk = new KuaiKanSpider(); 
		model.addAttribute("cList", akk.detail(id));
		model.addAttribute("cid", cid);
		
		List<KuaiKanVO> list = akk.catalog(cid);
		model.addAttribute("cMoreList", list);
		if(list.size()>0){
			model.addAttribute("desc", list.get(0).getDesc());
			model.addAttribute("cTitle", list.get(0).getTitle());
		}
		
		return "comic/comic_detail";
	}
}
