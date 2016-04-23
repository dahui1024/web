package com.bbcow.news.website;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class BasicSpider {
	
	public static Document denoiseForDoc(Document document) {
		document.getElementsByTag("script").remove();
		document.getElementsByTag("style").remove();
		document.getElementsByTag("select").remove();
		document.getElementsByTag("link").remove();
		document.getElementsByTag("input").remove();
		document.getElementsByTag("object").remove();
		document.getElementsByTag("textarea").remove();
		document.getElementsByTag("a").attr("href", "javascript:void(0)").remove();
		document.getElementsByAttributeValue("display", "none").remove();
		document.getElementsByAttributeValueContaining("style", "display:none").remove();
		document.getElementsByAttributeValueContaining("style", "overflow: hidden").remove();
		return document;
	}
	
	public static Document removeImg(Document document) {
		Elements imgs = document.getElementsByTag("img");
		for(int i=0;i<imgs.size();i++){
			imgs.get(i).after("<br//>");
		}
		imgs.remove();
		return document;
	}
	
}
