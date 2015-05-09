package com.mynews;

import java.util.ArrayList;
import java.util.List;

public class ListOfRss {

	static List<String> rssList = new ArrayList<String>();
	
	public static void ListOfRss(){
		rssList.add("http://feeds.bbci.co.uk/news/world/rss.xml");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533916/index.rss");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533920/index.rss");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533919/index.rss");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533921/index.rss");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533928/index.rss");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533922/index.rss");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533977/index.rss");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533975/index.rss");
		rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533972/index.rss");
		//rssList.add("http://timesofindia.feedsportal.com/c/33039/f/533965/index.rss");
	}

	public static List<String> getRssList() {
		ListOfRss();
		return rssList;
	}

	public void setRssList(List<String> rssList) {
		this.rssList = rssList;
	}

	
}
