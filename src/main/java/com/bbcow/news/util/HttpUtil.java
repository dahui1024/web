package com.bbcow.news.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class HttpUtil {
	
	public static byte[] getImage(String imgUrl) throws IOException{
		try {
			URL url = new URL(imgUrl);
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(url)
					.addHeader("host", url.getHost())
					.addHeader("Cache-control", "max-age=300")
					.addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1")
					.build();
			Response response = client.newCall(request).execute();
			ResponseBody body = response.body();
			return body.bytes();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static byte[] get(String url){
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url)
				.addHeader("host", "easyread.ph.126.net")
				.addHeader("Cache-control", "max-age=300")
				.addHeader("User-Agent", "NewsApp/5.5.4 iOS/9.3 (iPhone7,2)")
				.build();
		Response response;
		try {
			response = client.newCall(request).execute();
			ResponseBody body = response.body();
			return body.bytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
