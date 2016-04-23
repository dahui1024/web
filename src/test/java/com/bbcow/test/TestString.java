package com.bbcow.test;

import java.net.URLDecoder;

public class TestString {
	public static void main(String[] args) {
		String url = URLDecoder.decode("http://live.gslb.cmvideo.cn/envivo_v/HD/zhejiang/450/index.m3u8?msisdn=3653133117118&amp;mdspid=&amp;spid=699013&amp;netType=5&amp;sid=2202214779&amp;pid=2028597139&amp;timestamp=20160326115731&amp;Channel_ID=0116_03000000-99000-100300010010001&amp;ProgramID=608776093&amp;ParentNodeID=-99&amp;client_ip=60.194.194.20&amp;assertID=2202214779&amp;SecurityKey=20160326115731&amp;encrypt=64a15bfeefb93e8d24469faddfef2495");
		System.out.println(url);
	}
}
