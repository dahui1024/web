package com.bbcow.news.website.miaopai.spider;



public class Spider_Papi extends AbstractMiaopaiSpider{
	
	public Spider_Papi(){
		super("http://api.miaopai.com/m/shot_channel.json?f_type=v2&likeStat=0&live=1&os=ios&page=$1&per=20&suid=ZPWwDeYSvPUb23SL&unique_id=79d273867a9c357b6f978203addcb0b71234284759&version=6.3.1");
		spiders.put("MP_papi", this);
	}
}
