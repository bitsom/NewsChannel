package com.mynews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.json.JSONObject;

import redis.clients.jedis.Jedis;


public class InMemoryCache {

	
	public static ConcurrentMap<String, TreeSet<News>> cache = new ConcurrentHashMap<String, TreeSet<News>>();
	
	
	public static void addFeed(String key, News news){
		//System.out.println("key " + news.getTitle());
		String _key = key.toLowerCase();
		if(cache.containsKey(_key)){
			TreeSet<News> t = cache.get(_key);
			t.add(news);
		}else{
			TreeSet<News> t = new TreeSet<News>();
			t.add(news);
			cache.put(_key, t);
		}
			
	}
	public static  List<News> getFeed(String _query){
		String query = _query.toLowerCase();
		
		if(InMemoryCache.cache.size() == 0)
				RSSSchedular.task();
		
		List<News> result = new ArrayList<News>(10);
		int i =0;
		
		if(query == null || query.isEmpty())
			return null;
		
		TreeSet<News> t = null;
		String[] sub = query.split(" ");
		for(String s : sub){
			t = cache.get(s);
			if(t == null)
				continue;
			Iterator iterator = t.iterator();
			while (iterator.hasNext()){
				News n = (News)iterator.next();
				   result.add(n);
				  // System.out.println("n.title" +  n.getTitle());
				   i++;
				   if(i ==10)
					   break;
		   }
		}
		
		List<News> output = new ArrayList<News>(10);
		Collections.sort(result,new ResultData());
		int j = 0;
		for(News _news: result)
		{
			output.add(_news);
			j++;
			if(j ==10)
				break;
			Collections.reverse(output);
			
		}
		
		
		return result;
	}
	
	public static List<JSONObject> getFromCache(String key) {
        String[] sub = key.split(" ");
        Jedis jedis = new Jedis("localhost");
        List<JSONObject> t = new ArrayList<JSONObject>();
        String result = "";
        int i = 0;
        
        for(String s : sub){
            String temp = jedis.get(s);
            if(temp == null)
                continue;
            String[] tmpList = temp.split(";");
            for (String each: tmpList) {
                   //result.add(each.replace('\"', '"'));
            		JSONObject jsonObj = new JSONObject(each);
            		t.add(jsonObj);
                   //result += each.replace('\"', '"') + ';';
                   i++;
                   if(i == 10)
                       break;
           }
        }
        
        return t;
    }
	
}

