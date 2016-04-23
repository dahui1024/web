package com.bbcow.news.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbcow.news.website.AbstractVo;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class DataRemovalListener implements RemovalListener<String, List<? extends AbstractVo>> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onRemoval(RemovalNotification<String, List<? extends AbstractVo>> notification) {
		logger.info(notification.getKey()+" has removed -------- "+notification.getCause());
	}

}
