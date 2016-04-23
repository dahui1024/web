package com.bbcow.news.website.migu.spider;


public class ProvinceSpider extends AbstractMiguSpider{
	public ProvinceSpider(){
		super("http://migu.cmvideo.cn/clt50/publish/clt/resource/miguvideo2/livelist/tvData.jsp?contentId=70002090&isSupContSet=1&sdkVersion=22.00.01.09&playerType=4&res=HDPI&clientId=3653133117118&filterType=1&token=d004c60ae600cd24527ce313c54e3dbd&cid=0&imei=");
		spiders.put("province", this);
	}
	
	public static void main(String[] args) {
		ProvinceSpider ms = new ProvinceSpider();
		ms.list();
	}
}
