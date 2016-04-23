package com.bbcow.news.cache;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.bbcow.news.website.AbstractVo;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

public class DataCache {
	
	private static LoadingCache<String, List<? extends AbstractVo>> dataCache = CacheBuilder
			.newBuilder().maximumSize(10000)
			.expireAfterWrite(3, TimeUnit.HOURS)
			.recordStats()
			.removalListener(new DataRemovalListener())
			.build(new DataCacheLoader());
	
	
	public static List<? extends AbstractVo> get(String key){
		try {
			return dataCache.get(key);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
}
