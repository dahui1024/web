package com.bbcow.news.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.cache.DataCache;
import com.bbcow.news.website.miaopai.vo.MiaopaiVo;

@Controller
@RequestMapping(value="")
public class IndexController {
	@RequestMapping(value = "")
	public String index(Model model){
		model.addAttribute("news", DataCache.get("T1429173762551"));

		model.addAttribute("readTop", DataCache.get("T1387970173334").get(0));
		model.addAttribute("readList", DataCache.get("T1387970173334").subList(1, 3));
		
		List<MiaopaiVo> topVideoList = new LinkedList<MiaopaiVo>();
		List<MiaopaiVo> newVideoList = new LinkedList<MiaopaiVo>();
		List<MiaopaiVo> bmvos = (List<MiaopaiVo>) DataCache.get("MP_baoman");
		List<MiaopaiVo> fdvos = (List<MiaopaiVo>) DataCache.get("MP_feidie");
		List<MiaopaiVo> cxvos = (List<MiaopaiVo>) DataCache.get("MP_chenxiang");
		List<MiaopaiVo> nmvos = (List<MiaopaiVo>) DataCache.get("MP_nima");
		
		topVideoList.add(bmvos.get(0));
		topVideoList.add(fdvos.get(0));
		topVideoList.add(nmvos.get(0));
		topVideoList.add(cxvos.get(0));
		newVideoList.addAll(nmvos.subList(1, 7));
		newVideoList.addAll(bmvos.subList(1, 7));
		newVideoList.addAll(fdvos.subList(1, 7));
		newVideoList.addAll(cxvos.subList(1, 7));

		model.addAttribute("topVideoList", topVideoList);
		model.addAttribute("newVideoList", newVideoList);
		
		return "index";
	}
}
