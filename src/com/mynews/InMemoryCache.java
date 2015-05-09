package com.mynews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class InMemoryCache {

	
	public static Map<String, TreeSet<News>> cache = new HashMap<String, TreeSet<News>>();
	
	
	public static void addFeed(String key, News news){
		System.out.println(" addFeed methods : key " + news.getDescription());
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
		RSSSchedular.execute();
		System.out.println("query "  + query);
		List<News> result = new ArrayList<News>(2);
		int i =0;
		
		
		TreeSet<News> t = cache.get(query);
		
		Iterator iterator;
		   iterator = t.iterator();
		   while (iterator.hasNext()){
			   //System.out.println(iterator.next().toString() + " ");
			   result.add((News)iterator.next());
			   i++;
			   if(i ==2)
				   break;
			  }
		   
		return result;
	}
	
}

