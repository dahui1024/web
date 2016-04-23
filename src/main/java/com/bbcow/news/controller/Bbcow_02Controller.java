package com.bbcow.news.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.cache.DataCache;
import com.bbcow.news.vo.Simple01Vo;
import com.bbcow.news.website.neatease.vo.NeatEaseVo;

/**
 * 代码：02 
 * 板块：门牙阅读
 * */

@Controller
@RequestMapping(value="/02")
public class Bbcow_02Controller {
	@RequestMapping(value = "")
	public String index(Model model){
		
		List<Simple01Vo> list = new LinkedList<Simple01Vo>();
		list.add(new Simple01Vo("T1374655641708","读写客",(List<NeatEaseVo>) DataCache.get("T1374655641708")));
		list.add(new Simple01Vo("T1387970173334","网易看客",(List<NeatEaseVo>) DataCache.get("T1387970173334")));
		list.add(new Simple01Vo("T1374539968172","果壳科技",(List<NeatEaseVo>) DataCache.get("T1374539968172")));
		list.add(new Simple01Vo("T1374539990324","知乎每日精选",(List<NeatEaseVo>) DataCache.get("T1374539990324")));
		list.add(new Simple01Vo("T1348654756909","网易回声",(List<NeatEaseVo>) DataCache.get("T1348654756909")));
		
		model.addAttribute("list", list);
		return "bbcow_02/index";
	}
}
