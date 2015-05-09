package com.mynews;

public class News implements Comparable<News>{
	
	public String description ;
	public String title;
	public String image;
	public String link;
	public String guid;
	public String pubDate;
	public long timeStamp;
	public String author;
	public VideoMedia vm;
	public AudioMedia am;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public VideoMedia getVm() {
		return vm;
	}
	public void setVm(VideoMedia vm) {
		this.vm = vm;
	}
	public AudioMedia getAm() {
		return am;
	}
	public void setAm(AudioMedia am) {
		this.am = am;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int compareTo(News obj) {
		
		return (int) (obj.getTimeStamp() - timeStamp);
	}

}

