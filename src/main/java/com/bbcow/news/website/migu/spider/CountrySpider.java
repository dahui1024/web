package com.bbcow.news.website.migu.spider;


public class CountrySpider extends AbstractMiguSpider{
	public CountrySpider(){
		super("http://migu.cmvideo.cn/clt50/publish/clt/resource/miguvideo2/livelist/tvData.jsp?contentId=70002091&isSupContSet=1&sdkVersion=22.00.01.09&playerType=4&res=HDPI&clientId=3653133117118&filterType=1&token=d004c60ae600cd24527ce313c54e3dbd&cid=0&imei=");
		spiders.put("country", this);
	}
	
	public static void main(String[] args) {
		CountrySpider ms = new CountrySpider();
		ms.list();
		//ms.detail("contentId=608776093&nodeId=&objType=videolive");
		
	}
}
