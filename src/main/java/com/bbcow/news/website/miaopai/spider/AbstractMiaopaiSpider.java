package com.bbcow.news.website.miaopai.spider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.bbcow.news.website.miaopai.vo.MiaopaiVo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;


public abstract class AbstractMiaopaiSpider {
	protected String url = "http://api.miaopai.com/m/shot_channel.json?f_type=v2&likeStat=0&live=1&os=ios&page=$1&per=20&suid=4NUB4nrCdVdQFbHH&unique_id=79d273867a9c357b6f978203addcb0b71234284759&version=6.3.1";
	private static String video_url = "http://gslb.miaopai.com/stream/$1.mp4?vend=miaopai&";
	protected static Map<String, AbstractMiaopaiSpider> spiders = new HashMap<String, AbstractMiaopaiSpider>();
	public static List<String> keys = new LinkedList<String>();
	protected String key = this.getClass().getSimpleName();

	public static AbstractMiaopaiSpider getInstance(String key){
		if(spiders.get(key) == null){
			try {
				AbstractMiaopaiSpider nes = (AbstractMiaopaiSpider) Class.forName(AbstractMiaopaiSpider.class.getPackage().getName()+"."+key).newInstance();
				spiders.put(key, nes);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return spiders.get(key);
	}
	
	protected AbstractMiaopaiSpider(String url){
		this.url = url;
	}
	public List<MiaopaiVo> list() {
		return page("1");
	}
	public List<MiaopaiVo> page(String page) {
		String page_url = url.replace("$1", page);
		List<MiaopaiVo> list = new LinkedList<MiaopaiVo>();
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder().url(page_url)
				.addHeader("Cache-control", "max-age=300")
				.addHeader("User-Agent", "MiaoPai//6.3.1 (iPhone; iOS 9.3; Scale//2.00)")
				.addHeader("host", "api.miaopai.com")
				.build();
		
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			
			Iterator<JsonNode> channels = node.get("result").elements();
			while(channels.hasNext()){
				JsonNode channel = channels.next();
				channel = channel.get("channel");
				MiaopaiVo vo = new MiaopaiVo();
				vo.setId(channel.get("scid").asText());
				JsonNode pic = channel.get("pic");
				vo.setImg(pic.get("base").asText()+pic.get("m").asText());
				
				JsonNode ext = channel.get("ext");
				vo.setLength(ext.get("lengthNice").asText());
				String title = ext.get("t").asText().trim();
				
				JsonNode ext2 = channel.get("ext2");
				vo.setCreateTime(ext2.get("createTime").asLong());
				
				vo.setTitle(title.replaceAll("(#(暴走漫画|每日一暴|陈翔六点半|飞碟说|飞碟一分钟|)#)", ""));
				
				vo.setW(ext.get("w").asText());
				vo.setH(ext.get("h").asText());
				list.add(vo);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static String detail(String id){
		return video_url.replace("$1", id);
	}
	
	public static void main(String[] args) {

	}
}
