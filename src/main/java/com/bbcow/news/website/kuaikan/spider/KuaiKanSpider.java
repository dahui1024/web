package com.bbcow.news.website.kuaikan.spider;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.bbcow.news.website.kuaikan.vo.KuaiKanVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class KuaiKanSpider {
	protected String url = "http://api.kuaikanmanhua.com/v1/daily/comic_lists/$1?since=0";
	private static String detail_url = "http://api.kuaikanmanhua.com/v1/comics/$1";
	private static String catalog_url = "http://api.kuaikanmanhua.com/v1/topics/$1";
	
	/**
	 * 获取列表
	 * */
	public List<KuaiKanVO> list() {
		return page(0);
	}
	public List<KuaiKanVO> page(int page) {
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder().url(url.replace("$1", page+""))
				.addHeader("Cache-control", "max-age=300")
				.addHeader("User-Agent", "Kuaikan/2.6.4/26400(Android;4.3;SM-N7508V;Wandoujia;WIFI;1280*720)")
				.addHeader("host", "api.kuaikanmanhua.com")
				.build();
		List<KuaiKanVO> comicList = new LinkedList<KuaiKanVO>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			Iterator<JsonNode> comics = node.get("data").get("comics").elements();
			while(comics.hasNext()){
				JsonNode comic = comics.next();
				KuaiKanVO vo = new KuaiKanVO();
				vo.setLabel(comic.get("label_text").asText());
				vo.setSubImg(comic.get("cover_image_url").asText());
				vo.setSubTitle(comic.get("title").asText());
				vo.setUrl(comic.get("url").asText());
				vo.setSubId(comic.get("id").asText());
				JsonNode topic = comic.get("topic");
				vo.setTitle(topic.get("title").asText());
				vo.setDesc(topic.get("description").asText());
				vo.setImg(topic.get("cover_image_url").asText());
				vo.setId(topic.get("id").asText());
				comicList.add(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comicList;
	}
	public List<String> detail(String id){
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder().url(detail_url.replace("$1", id))
				.addHeader("Cache-control", "max-age=300")
				.addHeader("User-Agent", "Kuaikan/2.6.4/26400(Android;4.3;SM-N7508V;Wandoujia;WIFI;1280*720)")
				.addHeader("host", "api.kuaikanmanhua.com")
				.build();
		List<String> comicList = new LinkedList<String>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			Iterator<JsonNode> comics = node.get("data").get("images").elements();
			while(comics.hasNext()){
				JsonNode comic = comics.next();
				comicList.add(comic.asText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comicList;
	}
	public List<KuaiKanVO> catalog(String id) {
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder().url(catalog_url.replace("$1", id))
				.addHeader("Cache-control", "max-age=300")
				.addHeader("User-Agent", "Kuaikan/2.6.4/26400(Android;4.3;SM-N7508V;Wandoujia;WIFI;1280*720)")
				.addHeader("host", "api.kuaikanmanhua.com")
				.build();
		List<KuaiKanVO> comicList = new LinkedList<KuaiKanVO>();
		try {
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode node = objectMapper.readTree(body.byteStream());
			
			Iterator<JsonNode> comics = node.get("data").get("comics").elements();
			while(comics.hasNext()){
				JsonNode comic = comics.next();
				KuaiKanVO vo = new KuaiKanVO();
				vo.setSubImg(comic.get("cover_image_url").asText());
				vo.setSubTitle(comic.get("title").asText());
				vo.setUrl(comic.get("url").asText());
				vo.setSubId(comic.get("id").asText());
				/*JsonNode topic = comic.get("topic");*/
				vo.setTitle(node.get("data").get("title").asText());
				vo.setDesc(node.get("data").get("description").asText());
				vo.setImg(node.get("data").get("cover_image_url").asText());
				vo.setId(node.get("data").get("id").asText());
				comicList.add(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comicList;
	}
	public static void main(String[] args) {
		KuaiKanSpider ak = new KuaiKanSpider();
		ak.list();
	}
}
