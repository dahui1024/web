package com.bbcow.news.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;

public class CDNUtil {
	private static Logger logger = LoggerFactory.getLogger(CDNUtil.class);
	
	private static String ACCESS_KEY = "QZYtTsqkeWpMzkJ3T33o3IybYbkiWFphMLJ40DUc";
	private static String SECRET_KEY = "emLguAHwV5ugqSW-DUfC86YUXIOXHaBUf3OayO82";
	private static String bucketname = "file";
	private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	private UploadManager uploadManager = new UploadManager();
	
	BucketManager bucketManager = new BucketManager(auth);
	
	public static List<String> files = null;

	private String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	public synchronized void getList(){
		try {
			files = new ArrayList<String>();
			FileListing fl = bucketManager.listFiles(bucketname, null, null, 1000, null);
			for(FileInfo info : fl.items){
				files.add(MD5Util.digest(info.key));
			}
			logger.error("image list load again!!!");
		} catch (QiniuException e) {
			e.printStackTrace();
		}
	}
	
	public void uploadBatch(List<String> keys) throws IOException {
		for(String key : keys){
			upload(key);
		}
	}
	public void upload(String key) throws IOException {
		try {
			if(StringUtils.isNotBlank(key)){
				if(files == null){
					getList();
				}
				for(String file : files){
					if(file.equals(MD5Util.digest(key)))
						return;
				}
				uploadManager.put(HttpUtil.getImage(key), key, getUpToken());
				files.add(MD5Util.digest(key));
				logger.info("upload image : " + key);
			}
		} catch (QiniuException e) {
			logger.error(e.response.bodyString());
		}
	}

	public static void main(String args[]) throws IOException {
		//new CDNUtil().upload("http://easyread.ph.126.net/fXQn25tm-RnGnFUkz0rK9Q==/7916579377502106860.jpg");
		new CDNUtil().getList();
		/*OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url("http://easyread.ph.126.net/fXQn25tm-RnGnFUkz0rK9Q==/7916579377502106860.jpg")
				.addHeader("host", "easyread.ph.126.net")
				.addHeader("Cache-control", "max-age=300")
				.addHeader("User-Agent", "NewsApp/5.5.4 iOS/9.3 (iPhone7,2)")
				.build();
		com.squareup.okhttp.Response response = client.newCall(request).execute();
		ResponseBody body = response.body();
		byte[] bs = body.bytes();
		System.out.println(bs.length);*/
	}
}
