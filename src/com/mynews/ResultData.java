package com.mynews;

import java.util.Comparator;

public class ResultData implements Comparator<News>{
 
    @Override
    public int compare(News obj1, News obj2) {
        if(obj1.getTimeStamp() > obj2.getTimeStamp()){
            return 1;
        } else {
            return -1;
        }
    }
}


