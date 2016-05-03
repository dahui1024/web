package com.bbcow.news.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.cache.DataCache;
import com.bbcow.news.vo.Bvcow01Vo;

/**
 * 代码：02 
 * 板块：门牙阅读
 * */

@Controller
@RequestMapping(value="/02")
public class Bbcow_02Controller {
	@RequestMapping(value = "")
	public String index(Model model){
		
		List<Bvcow01Vo> list = new LinkedList<Bvcow01Vo>();
		list.add(new Bvcow01Vo("T1387970173334","网易看客",DataCache.get("T1387970173334")));
		list.add(new Bvcow01Vo("T1387350092857","大国小民",DataCache.get("T1387350092857")));
		list.add(new Bvcow01Vo("T1374542231526","微语录",DataCache.get("T1374542231526")));
		list.add(new Bvcow01Vo("T1383729011070","历史",DataCache.get("T1383729011070")));
		list.add(new Bvcow01Vo("T1413268231428","日报",DataCache.get("T1413268231428")));
		list.add(new Bvcow01Vo("T1374655641708","读写客",DataCache.get("T1374655641708")));
		list.add(new Bvcow01Vo("T1374539968172","果壳科技",DataCache.get("T1374539968172")));
		list.add(new Bvcow01Vo("T1348654756909","网易回声",DataCache.get("T1348654756909")));
		
		model.addAttribute("list", list);
		return "bbcow_02/index";
	}
}
