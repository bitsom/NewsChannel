package com.mynews;

import java.util.List;
import java.util.TreeSet;

public class RSSSchedular {
	
	public static void execute(){
		
		List<String> rssList = ListOfRss.getRssList();
		
		if(rssList != null){
			for(String channel : rssList){
				List<News> rssObj = RssFeedHandler.parseRss(channel);
				if(rssObj != null && rssObj.size() > 0){
					for(News n : rssObj){
						System.out.println("News :: " + n.getTitle());
						InMemoryCache.addFeed("india", n);
					}
					
				}
			}
		}
		
	//	TreeSet<News> t = InMemoryCache.getFeed();
		
	}
	
	public static void main(String[] args) {
		//String urlAdd = "http://feeds.bbci.co.uk/news/world/rss.xml";
		//parseRss(urlAdd);
		
		execute();
	}

}
