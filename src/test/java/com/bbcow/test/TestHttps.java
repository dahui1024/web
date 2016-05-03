package com.bbcow.test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.bbcow.news.website.kuaikan.vo.KuaiKanVO;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class TestHttps {
	public static void main(String[] args) {
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(5000, TimeUnit.MILLISECONDS);
		Request request = new Request.Builder()
				.url("http://s2.sosohaha.com/s3.html?_act=cate&func=1&param=12022&index=4&name=已完结&_uid=0&_delay=0&_devid=E2928314F0200DBAD827F146B889E37ASM&_model=SM-N7508V&_plt=android&_cv=17301810")
				.addHeader("Cache-control", "max-age=300")
				.addHeader("host", "s2.sosohaha.com").build();
		Response response;
		try {
			response = client.newCall(request).execute();
			ResponseBody body = response.body();
			System.out.println(new String(body.bytes(),"utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
