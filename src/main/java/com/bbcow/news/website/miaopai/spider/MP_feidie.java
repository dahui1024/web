package com.bbcow.news.website.miaopai.spider;



public class MP_feidie extends AbstractMiaopaiSpider{
	
	public MP_feidie(){
		super("http://api.miaopai.com/m/shot_channel.json?f_type=v2&likeStat=0&live=1&os=ios&page=$1&per=20&suid=n6fLvy263DA4XOzV&unique_id=79d273867a9c357b6f978203addcb0b71234284759&version=6.3.1");
		spiders.put(key, this);
		keys.add(key);
	}
}
