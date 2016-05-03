package com.bbcow.news.website.migu.spider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.bbcow.news.website.migu.vo.MiguVo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class AbstractMiguSpider {
	protected String url = "http://migu.cmvideo.cn/clt50/publish/clt/resource/miguvideo2/livelist/tvData.jsp?nodeId=70001838&isSupContSet=1&sdkVersion=22.00.01.09&playerType=4&res=HDPI&clientId=3653133117118&filterType=1&token=d004c60ae600cd24527ce313c54e3dbd&cid=0&imei=";
	private static String detail_url = "http://migu.cmvideo.cn/clt50/publish/clt/resource/miguvideo2/player/playerData.jsp?$1&deviceId=9A2B04E5-31DB-4B6D-8661-3AF37B70C1BE&nt=5&sdkVersion=22.00.01.09&playerType=4&res=HDPI&clientId=3653133117118&filterType=1&token=d004c60ae600cd24527ce313c54e3dbd&cid=0&imei=";
	private static Gson gson = new Gson();
	
	protected static Map<String, AbstractMiguSpider> spiders = new HashMap<String, AbstractMiguSpider>();
	
	static{
		new ProvinceSpider();
		new CountrySpider();
	}
	public static AbstractMiguSpider getInstance(String key){
		return spiders.get(key);
	}
	protected AbstractMiguSpider(String url){
		this.url = url;
	}
	
	public List<MiguVo> list() {
		List<MiguVo> list = new LinkedList<MiguVo>();
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder().url(url)
				.addHeader("host", "migu.cmvideo.cn")
				.addHeader("Cache-control", "max-age=3600")
				.addHeader("User-Agent", "iPhone7,2_375.000000*667.000000")
				.addHeader("x-up-bear-type", "WLAN")
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.build();
		
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			String originTxt = new String(body.bytes(),"utf-8");
			originTxt = originTxt.replaceAll("[\n\t]", "").replaceAll("\",[\\s]*}", "\"}").replaceAll("},[\\s]*]", "}]").replaceAll("],[\\s]*}", "]}");
			
			JsonElement originNode = gson.toJsonTree(originTxt);
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(originNode.getAsString());
			
			Iterator<JsonNode> contents = node.get("contList").iterator();
			while(contents.hasNext()){
				JsonNode content = contents.next();
				System.out.println(content.get("param").asText());
				MiguVo vo = new MiguVo();
				vo.setImg(content.get("img").asText());
				vo.setName(content.get("name").asText());
				vo.setParam(content.get("param").asText());
				vo.setProp(content.get("prop").asText());
				if(content.get("vip").asInt()<=0)
					list.add(vo);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static MiguVo detail(String param) {
		MiguVo vo = new MiguVo();
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder().url(detail_url.replace("$1", param+"&nodeId=&objType=videolive"))
				.addHeader("host", "migu.cmvideo.cn")
				.addHeader("Cache-control", "max-age=3600")
				.addHeader("User-Agent", "iPhone7,2_375.000000*667.000000")
				.addHeader("x-up-bear-type", "WLAN")
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("X_UP_CLIENT_CHANNEL_ID", "22040108-99000-200300020100001")
				.build();
		
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			String originTxt = new String(body.bytes(),"utf-8");
			originTxt = originTxt.replaceAll("[\n\t]", "").replaceAll("\",[\\s]+}", "\"}").replaceAll("},[\\s]+]", "}]").replaceAll("],[\\s]+}", "]}");
			JsonElement originNode = gson.toJsonTree(originTxt);
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(originNode.getAsString());
			
			vo.setPlayUrl(node.get("playUrl").asText());
			vo.setName(node.get("nodeName").asText());
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return vo;
	}
}
