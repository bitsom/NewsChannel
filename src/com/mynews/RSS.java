package com.mynews;

public class RSS {
	
	public String url;
	public String source;
	public long curTime;
	
	public RSS(String url, String src, long cTime){
		this.url = url;
		this.source = src;
		this.curTime = cTime;
		
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public long getCurTime() {
		return curTime;
	}
	public void setCurTime(long curTime) {
		this.curTime = curTime;
	}
	
	

}
