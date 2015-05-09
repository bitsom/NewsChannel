package com.mynews;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class RssFeedHandler {

	public static List<News> parseRss(String urlAdd){
		
		try{
		Document doc = Jsoup.connect(urlAdd).get();
		
		if (doc != null)
        {
           // ToldotItem item = null;
			List<News> list = new ArrayList<News>();
			
            String cssPath = "item";
            Elements links = doc.select("item");

            for (org.jsoup.nodes.Element link : links) {
            	News news = new News();
                org.jsoup.nodes.Document docInner = Jsoup.parse(link.outerHtml());
               // item = new ToldotItem();
                
                	Elements linksInner = docInner.select("pubDate");
                	String pubDate  = linksInner.text();
                	news.setPubDate(pubDate);
                
                    linksInner = docInner.select("title");
                    String title =    linksInner.text();
                    news.setTitle(title);
                    

                    long timestamp = convertToEpoch(pubDate);
                    news.setTimeStamp(timestamp);
                    
                    linksInner = docInner.select("link");
                    String _link  = linksInner.text();
                    news.setLink(_link);

                    linksInner = docInner.select("description");
                    String description  = linksInner.text();
                    news.setDescription(description);
                    
                    linksInner = docInner.select("guid");
                    String guid  = linksInner.text();
                    news.setGuid(guid);
                    
                    linksInner = docInner.select("author");
                    String author  = linksInner.text();
                    news.setAuthor(author);
                    
                    
                    linksInner = docInner.select("media|thumbnail ");
                    String thumbnail  = linksInner.attr("url");
                    news.setImage(thumbnail);
                    
                    
                    linksInner = docInner.select("media|content");
                
                    if (linksInner.size()>0)
                    {
                    	//Log.d(Helpers.TAG, "links: "+linksInner.size());
                    	String video  = linksInner.attr("url");
                    	String videoFileSize  = linksInner.attr("fileSize");
                    	String videoDuration  = linksInner.attr("duration");
                    }
                    linksInner = docInner.select("media|content");
                    if (linksInner.size()>0)
                    {
                    	String audio  = linksInner.attr("url");
                    	String audioFileSize  = linksInner.attr("fileSize");
                        String audioDuration  = linksInner.attr("duration");
                    }
               list.add(news);
               

            }
            return list;
        }
		}catch(Exception e){
			System.out.println("Exception e");
		}
		return null;
	}
	
	public static long convertToEpoch(String date){
		//String str = "Fri, 08 May 2015 20:24:55 GMT";
		date = date.split(",")[1];
	    SimpleDateFormat df = new SimpleDateFormat(
	        "dd MMM yyyy HH:mm:ss zzz");
	    Date _date = null;
		try {
			_date = df.parse(date);
			long epoch = _date.getTime();
			return epoch;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return -1l;
	   
	}
	
	public static void main(String[] args) {
		String urlAdd = "http://feeds.bbci.co.uk/news/world/rss.xml";
		parseRss(urlAdd);
	}

}

