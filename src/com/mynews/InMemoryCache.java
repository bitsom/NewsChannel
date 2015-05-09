package com.mynews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class InMemoryCache {

	
	public static ConcurrentMap<String, TreeSet<News>> cache = new ConcurrentHashMap<String, TreeSet<News>>();
	
	
	public static void addFeed(String key, News news){
		System.out.println("key " + news.getTitle());
		if(cache.containsKey(key)){
			TreeSet<News> t = cache.get(key);
			t.add(news);
		}else{
			TreeSet<News> t = new TreeSet<News>();
			t.add(news);
			cache.put(key, t);
		}
			
	}
	public static  List<News> getFeed(String query){
		
		if(InMemoryCache.cache.size() == 0)
				RSSSchedular.task();
		
		List<News> result = new ArrayList<News>(10);
		int i =0;
		
		
		TreeSet<News> t = cache.get(query);
		System.out.println("Query : " + query);
		
		
		if(t == null)
		{
			System.out.println("cache is empty");
			return null;
		}
		
		Iterator iterator = t.iterator();
		while (iterator.hasNext()){
			News n = (News)iterator.next();
			   result.add(n);
			   System.out.println("n.title" +  n.getTitle());
			   i++;
			   if(i ==10)
				   break;
			  }
		   
		return result;
	}
	
}

