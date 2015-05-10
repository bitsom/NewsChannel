package com.mynews;

import java.util.ArrayList;
import java.util.List;

public class ListOfRss {

	static List<RSS> rssList = new ArrayList<RSS>();
	
	public static void ListOfRss(){
		
		rssList.add(new RSS("http://www.findyourfate.com/rss/horoscope-astrology-feed.asp?mode=view&todate=5/10/2015","findYourFate",0l));
		rssList.add(new RSS("http://www.espncricinfo.com/rss/content/story/feeds/791129.xml","espncricinfo",0l));
		rssList.add(new RSS("http://feeds.bbci.co.uk/news/world/rss.xml", "bbc", 0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533916/index.rss", "timesofindia", 0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533920/index.rss","timesofindia", 0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533919/index.rss","timesofindia",0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533921/index.rss", "timesofindia", 0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533928/index.rss","timesofindia", 0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533922/index.rss", "timesofindia",0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533977/index.rss","timesofindia",0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533975/index.rss","timesofindia",0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533972/index.rss","timesofindia",0l));
		rssList.add(new RSS("http://timesofindia.feedsportal.com/c/33039/f/533965/index.rss","timesofindia",0l));
		rssList.add(new RSS("http://www.thehindu.com/news/international/south-asia/?service=rss","thehindu",0l));
	    rssList.add(new RSS("http://www.thehindu.com/news/national/andhra-pradesh/?service=rss","thehindu",0l));
	    rssList.add(new RSS("http://www.thehindu.com/news/national/karnataka/?service=rss","thehindu",0l));
	    rssList.add(new RSS("http://www.thehindu.com/news/national/kerala/?service=rss","thehindu",0l));
	    rssList.add(new RSS("http://www.thehindu.com/news/national/tamil-nadu/?service=rss","thehindu",0l));
	    rssList.add(new RSS("http://indianexpress.com/section/sports/feed/#sthash.wAVhlTlk.dpuf","indianexpress",0l));
	    rssList.add(new RSS("http://indianexpress.com/section/india/feed/#sthash.wAVhlTlk.dpuf","indianexpress",0l));
	    rssList.add(new RSS("http://indianexpress.com/section/entertainment/regional/feed/#sthash.wAVhlTlk.dpuf","indianexpress",0l));
	    rssList.add(new RSS("http://indianexpress.com/section/entertainment/bollywood/feed/#sthash.wAVhlTlk.dpuf","indianexpress",0l));
	    
	    rssList.add(new RSS("http://in.reuters.com/tools/rss", "reuters",0l));
	    rssList.add(new RSS("http://www.cnet.com/rss","CNET", 0l));
	    rssList.add(new RSS("http://www.nytimes.com/services/xml/rss/index.html","Newyorktimes",0l));
	    rssList.add(new RSS("http://www.forbes.com/fdc/rss.html","Forbes",0l));
	    rssList.add(new RSS("http://www.wsj.com/public/page/0_0813.html","wallstreetjournals",0l));
	    rssList.add(new RSS("http://techcrunch.com/rssfeeds", "TechCrunch",0l));
	    rssList.add(new RSS("http://www.indiatvnews.com/rssfeed/sports_cricket_news.xml","indiatvnews",0l));
	    rssList.add(new RSS("https://news.google.com/news?pz=1&cf=all&ned=us&hl=en&output=rss","googlenews",0l));
	    
	    rssList.add(new RSS("http://www.indiatvnews.com/rssfeed/masala_bollywood_news.xml","indiatvnews",0l));
	    rssList.add(new RSS("http://economictimes.indiatimes.com/rss.cms","economictimes", 0l));
	    rssList.add(new RSS("http://www.businesstimes.com.sg/rss-feeds","businesstimes",0l));
	    
	    
	    
	    
	    //http://feeds.feedburner.com/dayhoroscope
	}

	public static List<RSS> getRssList() {
		ListOfRss();
		return rssList;
	}

	public void setRssList(List<RSS> rssList) {
		this.rssList = rssList;
	}

	
}
