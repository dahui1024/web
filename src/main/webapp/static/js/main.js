function viewVideo(id,title,length){
	location.href="/miaopai/video/"+id+".html?title="+encodeURIComponent(title)+"&length="+length;
}
function view(param,title){
	location.href="/migu/video.html/"+param+"";
}
function nextPage(page,type){
	location.href="/miaopai/page/"+page+"?type="+type;
}
function nextNEPage(page,channel){
	location.href="/netease/page/"+page+"?channel="+channel;
}
function nextUrl(url){
	location.href=url;
}