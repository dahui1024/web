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

public class AbstractKuaiKanSpider {
	protected String url = "http://api.kuaikanmanhua.com/v1/daily/comic_lists/0?since=0";
	private static String detail_url = "http://c.m.163.com/nc/article/$1/full.html";
	
	/**
	 * 获取列表
	 * */
	public List<KuaiKanVO> list() {
		return page(0);
	}
	public List<KuaiKanVO> page(int page) {
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder().url(url.replace("$1", (page*20)+""))
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
				vo.setImg(comic.get("cover_image_url").asText());
				vo.setLabel(comic.get("label_text").asText());
				vo.setTitle(comic.get("title").asText());
				vo.setUrl(comic.get("url").asText());
				comicList.add(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return comicList;
	}
	public static void main(String[] args) {
		AbstractKuaiKanSpider ak = new AbstractKuaiKanSpider();
		ak.list();
	}
}
