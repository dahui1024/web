package com.bbcow.news.cache;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbcow.news.website.AbstractVo;
import com.bbcow.news.website.miaopai.spider.AbstractMiaopaiSpider;
import com.bbcow.news.website.migu.spider.AbstractMiguSpider;
import com.bbcow.news.website.migu.vo.MiguVo;
import com.bbcow.news.website.neatease.spider.AbstractNeatEaseSpider;
import com.google.common.cache.CacheLoader;

public class DataCacheLoader extends CacheLoader<String, List<? extends AbstractVo>> {
	private Logger logger = LoggerFactory.getLogger(DataCacheLoader.class);
	@Override
	public List<? extends AbstractVo> load(String key) throws Exception {
		if(key.matches("T[\\w]+")){
			return AbstractNeatEaseSpider.getInstance(key).list();
		}
		if(key.matches("MP_[\\w]+")){
			return AbstractMiaopaiSpider.getInstance(key).list();
		}
		if(key.matches("(province|country)")){
			List<MiguVo> list = new LinkedList<MiguVo>();
			boolean flag = true;
				for(int i=0;i<3 && flag ;i++){
					list = AbstractMiguSpider.getInstance(key).list();
					if(list.size()>0){
						flag = false;
						logger.error("not load migu videos");
					}
				}
			return list;
		}
		return null;
	}

}
