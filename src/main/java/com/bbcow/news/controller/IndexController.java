package com.bbcow.news.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbcow.news.cache.DataCache;
import com.bbcow.news.website.miaopai.vo.MiaopaiVo;
import com.bbcow.news.website.neatease.vo.NeatEaseVo;

@Controller
@RequestMapping(value="")
public class IndexController {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@RequestMapping(value = "")
	public String index(Model model){
		model.addAttribute("news", DataCache.get("T1348647909107"));

		//model.addAttribute("readTop", DataCache.get("T1387970173334").get(0));
		
		List<MiaopaiVo> videoList = new LinkedList<MiaopaiVo>();
		videoList.addAll((List<MiaopaiVo>) DataCache.get("MP_feidie").subList(0, 4));
		videoList.addAll((List<MiaopaiVo>) DataCache.get("MP_chenxiang").subList(0, 4));
		videoList.addAll((List<MiaopaiVo>) DataCache.get("MP_nima").subList(0, 4));
		videoList.addAll((List<MiaopaiVo>) DataCache.get("MP_papi").subList(0, 4));
		videoList.addAll((List<MiaopaiVo>) DataCache.get("MP_baisi").subList(0, 4));
		Collections.sort(videoList, new Comparator<MiaopaiVo>() {
			@Override
			public int compare(MiaopaiVo o1, MiaopaiVo o2) {
				return (int) (o2.getCreateTime()-o1.getCreateTime());
			}
		});
		model.addAttribute("videoList", videoList);
		
		
		List<NeatEaseVo> readList = new LinkedList<NeatEaseVo>();
		readList.addAll((List<NeatEaseVo>) DataCache.get("T1387970173334").subList(0, 5));
		readList.addAll((List<NeatEaseVo>) DataCache.get("T1387350092857").subList(0, 5));
		readList.addAll((List<NeatEaseVo>) DataCache.get("T1374542231526").subList(0, 5));
		readList.addAll((List<NeatEaseVo>) DataCache.get("T1383729011070").subList(0, 5));
		readList.addAll((List<NeatEaseVo>) DataCache.get("T1413268231428").subList(0, 6));
		Collections.sort(readList, new Comparator<NeatEaseVo>() {
			@Override
			public int compare(NeatEaseVo o1, NeatEaseVo o2) {
				try {
					return (int)(sdf.parse(o2.getPtime()).getTime()-sdf.parse(o1.getPtime()).getTime());
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return 1;
			}
		});
		model.addAttribute("readList",readList);
		
		return "index";
	}
}
