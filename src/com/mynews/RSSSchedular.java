package com.mynews;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Date;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;


public class RSSSchedular implements Runnable{
	
	private boolean running = false;
	private int l;
	private int c;
	private List<String> list;
	
	public RSSSchedular (int last, int current)
	{
		Thread thread = new Thread(this);
		this.l = last;
		this.c = current;
		thread.start();
	}
	
	/*public static  void execute(){
		
		List<String> rssList = ListOfRss.getRssList();
		
		if(rssList != null){
			for(String channel : rssList){
				List<News> rssObj = RssFeedHandler.parseRss(channel);
				if(rssObj != null && rssObj.size() > 0){
					for(News n : rssObj){
						List<String> keys = breakIntoKeys(n.getTitle());
						if(keys == null)
							continue;
						for(String key : keys){
							InMemoryCache.addFeed(key, n);
						}
						
					}
					
				}
			}
		}
		
	//	TreeSet<News> t = InMemoryCache.getFeed();
		
	}*/
	
	public static void execute(int startPos, int stopPos){

		List<RSS> rssList = ListOfRss.getRssList();
		Jedis jedis = new Jedis("localhost");

		if(rssList != null){
			for (int i = startPos; i<stopPos; i++) {
				RSS channel = rssList.get(i);
				List<News> rssObj = RssFeedHandler.parseRss(channel);
				if(rssObj != null && rssObj.size() > 0){
					for(News n : rssObj){
						List<String> keys = breakIntoKeys(n.getTitle());
						if(keys == null)
							continue;
						for(String key : keys){
							InMemoryCache.addFeed(key, n);
							System.out.println("Keyname: " + key);
							key = key.replaceAll("[^\\w\\s]","");
							String listString = new Gson().toJson(n);
							String val = jedis.get(key);
							if (val != null) {
								val += ';' + listString;
							}
							val = listString;
		                    //System.out.println(listString);
		                    jedis.set(key, val);
						}
					}
				}
			}
		}

		//	TreeSet<News> t = InMemoryCache.getFeed();

	}
	
	@Override
	public void run() 
	{
		this.running = true;
		/* System.out.println("This is currently running on a separate thread, " +
				"the id is: " + Thread.currentThread().getId()); */

		execute(l, c);
		int len = InMemoryCache.cache.size();
		System.out.println("Size:" + len);
		try 
		{

			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			Thread.currentThread().interrupt();
		}
		this.running = false;
	}


	public static synchronized List<String> breakIntoKeys(String title){
		if(title == null)
			return null;
		String[] keys = title.split(" ");
		List<String> keyList = new ArrayList<String>();
		for(int i=0; i<keys.length; i++){
			if(keys[i].length() >= 3)
				//System.out.println("Keys === >> " +keys[i] );
				keyList.add(keys[i]);
		}
		return keyList;
		
		
	}
	
	public static void task(){
			//String urlAdd = "http://feeds.bbci.co.uk/news/world/rss.xml";
			//parseRss(urlAdd);
			
			//execute();
			
			//String urlAdd = "http://feeds.bbci.co.uk/news/world/rss.xml";
					//parseRss(urlAdd);
					while (true) {
						List<RSSSchedular> workers = new ArrayList<RSSSchedular>();
						List<RSS> rssList = ListOfRss.getRssList();

						int count = rssList.size();
						
						int start = 0;

						/* System.out.println("This is currently running on the main thread, " +
								"the id is: " + Thread.currentThread().getId()); */

						// start 5 workers
						for (int i=0; i<5; i++)
						{
							int end = 0;
			                if (count >= 10) {
			                    end = start + count / 10;
			                } else {
			                    end = start + count % 10;
			                }
							workers.add(new RSSSchedular(start, end));
							start = end;
						}
						try {
							Thread.sleep(100000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			
	}
	
	/* public static void main(String[] args) {
		//String urlAdd = "http://feeds.bbci.co.uk/news/world/rss.xml";
		//parseRss(urlAdd);
		
		//execute();
		
		//String urlAdd = "http://feeds.bbci.co.uk/news/world/rss.xml";
				//parseRss(urlAdd);
				while (true) {
					List<RSSSchedular> workers = new ArrayList<RSSSchedular>();
					List<RSS> rssList = ListOfRss.getRssList();

					int count = rssList.size();
					System.out.println("" + count);
					int start = 0;

					System.out.println("This is currently running on the main thread, " +
							"the id is: " + Thread.currentThread().getId());

					// start 5 workers
					for (int i=0; i<1; i++)
					{
						int end = start + count / 2;
						workers.add(new RSSSchedular(start, end));
						start = end;
					}
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
	}*/

}
