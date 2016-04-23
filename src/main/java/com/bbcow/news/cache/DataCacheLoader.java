package com.bbcow.news.cache;

import java.util.List;

import com.bbcow.news.website.AbstractVo;
import com.bbcow.news.website.miaopai.spider.AbstractMiaopaiSpider;
import com.bbcow.news.website.migu.spider.AbstractMiguSpider;
import com.bbcow.news.website.neatease.spider.AbstractNeatEaseSpider;
import com.google.common.cache.CacheLoader;

public class DataCacheLoader extends CacheLoader<String, List<? extends AbstractVo>> {
	@Override
	public List<? extends AbstractVo> load(String key) throws Exception {
		if(key.matches("T[\\w]+")){
			return AbstractNeatEaseSpider.getInstance(key).list();
		}
		if(key.matches("MP_[\\w]+")){
			return AbstractMiaopaiSpider.getInstance(key).list();
		}
		if(key.equals("kuaikan")){
			
		}
		if(key.matches("(province|country)")){
			return AbstractMiguSpider.getInstance(key).list();
		}
		return null;
	}

}
