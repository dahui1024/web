package com.bbcow.news.website.neatease.spider;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.bbcow.news.util.TaskUtil;
import com.bbcow.news.website.neatease.vo.NeatEaseVo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public abstract class AbstractNeatEaseSpider {
	protected String url = "http://c.3g.163.com/nc/article/list/$1/0-20.html";
	private static String detail_url = "http://c.m.163.com/nc/article/$1/full.html";
	private static String photo_url = "http://c.m.163.com/photo/api/set/$1/$2.json";
	protected static Map<String, AbstractNeatEaseSpider> spiders = new HashMap<String, AbstractNeatEaseSpider>();
	protected String key = this.getClass().getSimpleName();
	
	private final Gson gson = new Gson();
	
	static{
		/*new T1374539968172();
		new T1429173762551();
		new T1348654756909();
		new T1387970173334();
		new T1374539990324();
		new T1374655641708();
		new T1387350092857();*/
	}
	
	public AbstractNeatEaseSpider(String url){
		this.url = url;
	}
	public static AbstractNeatEaseSpider getInstance(String key){
		if(spiders.get(key) == null){
			try {
				AbstractNeatEaseSpider nes = (AbstractNeatEaseSpider) Class.forName(AbstractNeatEaseSpider.class.getPackage().getName()+"."+key).newInstance();
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
	/**
	 * 获取列表
	 * */
	public List<NeatEaseVo> list() {
		return page(0);
	}
	public List<NeatEaseVo> page(int page) {
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder().url(url.replace("$1", (page*20)+""))
				.addHeader("Cache-control", "max-age=300")
				.addHeader("User-Agent", "NewsApp/5.5.4 iOS/9.3 (iPhone7,2)")
				.addHeader("host", "c.3g.163.com")
				.build();
		NeatEaseVo[] ns = null;
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			String text = new String(body.bytes(),"utf-8");
			text = text.replaceFirst("T[\\w]+", "vos");
			ns = gson.fromJson(text, NeatEaseBean.class).vos;
			
			for(NeatEaseVo n : ns){
				n.setImgsrc(TaskUtil.excute(n.getImgsrc()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Arrays.asList(ns);
	}
	/**
	 * 图卦
	 * */
	public static List<String[]> photo(String id,String[] content) {
		OkHttpClient client = new OkHttpClient();
		String real_photo_url = photo_url.replace("$1", id.substring(4,id.lastIndexOf("|")));
		real_photo_url = real_photo_url.replace("$2", id.substring(id.lastIndexOf("|")+1));
		
		Request request = new Request.Builder().url(real_photo_url).build();
		List<String[]> detail = new LinkedList<String[]>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			content[0] = node.get("setname").asText();
			content[1] = node.get("settag").asText();
			JsonNode node2 = node.path("photos");
			Iterator<JsonNode> nodes = node2.elements();
			while(nodes.hasNext()){
				JsonNode n = nodes.next();
				detail.add(new String[]{n.get("imgurl").asText(),n.get("note").asText()});
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return detail;
	}
	/**
	 * 详情
	 * */
	public static Map<String,String> detail(String id) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(detail_url.replace("$1", id)).build();
		Map<String, String> detail = new HashMap<String, String>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			JsonNode node2 = node.path(id);
			String dkeys = node2.get("dkeys").asText();
			if(StringUtils.isNotBlank(dkeys) && !dkeys.contains("null")){
				detail.put("dkeys", dkeys);
			}
			String bodyNode = node2.get("body").asText();
			
			Iterator<JsonNode> imgNodes = node2.get("img").elements();
			while(imgNodes.hasNext()){
				JsonNode imgNode = imgNodes.next();
				bodyNode = bodyNode.replace(imgNode.get("ref").asText(), "<img src=\""+TaskUtil.excute(imgNode.get("src").asText())+"\" class=\"img-responsive\" alt=\""+imgNode.get("alt").asText()+"\">");
				detail.put("type", "0");
			}
			Iterator<JsonNode> linkNodes = node2.get("link").elements();
			while(linkNodes.hasNext()){
				JsonNode linkNode = linkNodes.next();
				/*bodyNode = "<div class=\"embed-responsive embed-responsive-16by9\"><iframe class=\"embed-responsive-item\" src=\""+linkNode.get("href").asText()+"\"></iframe></div>";*/
				bodyNode = "<h1 style='color:red'>暂不提供转码，点击前往原网页阅读！</h1>";
				
				bodyNode = bodyNode +"<a href='javascript:history.go(-1)' style='color:green'>返回</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				bodyNode = bodyNode +"<a href=\""+linkNode.get("href").asText()+"\" target='_blank'>原网页阅读</a><br/>";
				detail.put("type", "1");
				break;
			}
			detail.put("body", bodyNode);
			detail.put("title", node2.get("title").asText());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return detail;
	}
	
	class NeatEaseBean{
		NeatEaseVo[] vos;
	}
	public static void main(String[] args) {
		//NeatEaseSpider ns = new NeatEaseSpider();
		//ns.detail("BJFBQC5L00014JHT");
		//System.out.println(ns.list().size());
		
	}
}
