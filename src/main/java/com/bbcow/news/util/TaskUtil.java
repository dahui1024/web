package com.bbcow.news.util;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskUtil {
	private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
	
	public static String excute(String key){
		if(key.contains("easyread.ph.126.net")){
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						new CDNUtil().upload(key);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			return  "http://file.bbcow.com/"+key;
		}
		return key;
	}
	
}
