package com.bbcow.test;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class TestHttps {
	public static void main(String[] args) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("http://www.baidu.com").build();
		
		try {
			Response response = client.newCall(request).execute();
			
			System.out.println(new String(response.body().bytes(),"utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
