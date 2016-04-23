package com.bbcow.news.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.cache.DataCache;
import com.bbcow.news.vo.Bbcow02Vo;
import com.bbcow.news.website.miaopai.vo.MiaopaiVo;

/**
 * 代码：01 
 * 板块：门牙娱乐视频
 * */

@Controller
@RequestMapping(value="/01")
public class Bbcow_01Controller {
	@RequestMapping(value = "")
	public String index(Model model){

		
		List<Bbcow02Vo> videoList = new LinkedList<Bbcow02Vo>();
		videoList.add(new Bbcow02Vo("MP_papi", "Papi酱", (List<MiaopaiVo>) DataCache.get("MP_papi")));
		videoList.add(new Bbcow02Vo("MP_baoman", "暴走漫画", (List<MiaopaiVo>) DataCache.get("MP_baoman")));
		videoList.add(new Bbcow02Vo("MP_baisi", "百思不得姐", (List<MiaopaiVo>) DataCache.get("MP_baisi")));
		videoList.add(new Bbcow02Vo("MP_feidie", "飞碟说", (List<MiaopaiVo>) DataCache.get("MP_feidie")));
		videoList.add(new Bbcow02Vo("MP_chenxiang", "陈翔六点半", (List<MiaopaiVo>) DataCache.get("MP_chenxiang")));
		videoList.add(new Bbcow02Vo("MP_nima", "暴走大事件", (List<MiaopaiVo>) DataCache.get("MP_nima")));
		
		model.addAttribute("videoList", videoList);
		return "bbcow_01/index";
	}
}
