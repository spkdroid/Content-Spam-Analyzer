package com.spam.test;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.spam.htmltoplain.HtmlToPlainText;

public class SpamDetectionTestUpdated {


	private static float anchortext=0;
	private static float wordtext=0;
	
	private static float percentage;
	
	HtmlToPlainText pp=new HtmlToPlainText();
	
	
	public float anchorTagRatioTest(String s)
	{
		
		 Document doc=Jsoup.parse(s);
         Elements link=doc.select("a[href]");
      
       for (Element element : link) {
      	String r=element.text();
      	r=r.trim();
      	String trim[]=r.split(" ");
        anchortext=anchortext+trim.length;
      }   
      
      String plainText = pp.getPlainText(doc);
	  String[] words=plainText.split("[\\s']");
      
	  
      for (String element : words) {
		
      	if(element.length()>0)
      	{
          wordtext++;
      	}
      }
	  
	  
      if(anchortext!=0 && wordtext!=0)
      {
      percentage=(float)(anchortext/wordtext);
      }
      else
      {
      percentage=0;	
      }
      
      percentage=percentage*10;
      percentage=Math.round(percentage);
      
      
	  return percentage;	
	}
	
	
	public float AverageWordLength(String s)
	{
		
		float wordcount=0;
		float avgword=0;
		float b;
		String q = null;
		  Document doc=Jsoup.parse(s);
          String plainText = pp.getPlainText(doc);

          String[] words=plainText.split("[\\s']");
          
          for (String string : words) {
	    
       	   if(string.length()>0)
       	   {
       		wordcount++;   
       		avgword=avgword+string.length();   
   	        }
       	}
          if(avgword>0 && wordcount>0)
          {
          b=(avgword/wordcount);
          }
          else
          {
       	   b=0;
          }
          
          if(b>100)
          {
        	  b=99;
          }
          b=b/10;
          b=Math.round(b);
       return b;		
	}
	
	public int wordCount(String s)
	{
		    Document doc=Jsoup.parse(s);
	        String plainText = pp.getPlainText(doc);
	        String[] words=plainText.split("[\\s']");
	        int len=words.length;
	        len=len/100;
	        if(len>99)
	        {
	        	len=99;
	        }
	        
	        len=len/10;
	        len=Math.round(len);
	        
	        return len;
	}
	
	
	public int titleLength(String s)
	{
		String b;
		Document doc=Jsoup.parse(s);
        String title=doc.title(); 
        
        String[] words=title.split("[\\s']");        
        int title_len=words.length;
        
        if(title_len>=100)
        {
        	title_len=99;
        }
        title_len=title_len/10;
        title_len=Math.round(title_len);
        return title_len;
	}
	
	
	public float visibilityRation(String s)
	{
		float a,b,c;
		a=s.length();
	    
		Document doc=Jsoup.parse(s);
        String plainText = pp.getPlainText(doc);
        b=plainText.length();
		
        if(a>0 && b>0)
        {
        c=(b/a)*100;
        }
        else
        {
        	c=0;
        }
        c=c/10;
        c=Math.round(c);
      //  c=10-c;
        return c;    
	}
	
	
	public float popularRation(ArrayList<String> ar,String s)
	{
		
		Document doc=Jsoup.parse(s);
        String plainText = pp.getPlainText(doc);
        String[] words=plainText.split("[\\s']");

    String a;
    float count=0;
    int flag;
        
    for(int i=0;i<500;i++)
        {
     	String t=ar.get(i);
     	flag=1;
     	for (String string : words) {
				if(string.equals(t))
				{
			    flag=0;
				}
    	        }
     	if(flag==0)
     	{
     		count++;
     	}
        }
    float val;
    if(count>0)
    {
       val=(float)(count/500);
       val=val*100;
    }
    else
    {
 	   val=0;
    }		
    
    if(val>=100)
    {
    	val=99;
    }
    
    val=val/10;
    val=Math.round(val);
   
		return val;
	}
	
	
	
	public float redunt(String sr)
	{
		HtmlToPlainText hm=new HtmlToPlainText();
		
	//	String text = sr;
        float feq=0;
        float num=0;
        float res=0;
		Document doc=Jsoup.parse(sr);
        String plainText = hm.getPlainText(doc);

        String[] keys = plainText.split(" ");
        String[] uniqueKeys;
        int count = 0;
        uniqueKeys = getUniqueKeys(keys);

        for(String key: uniqueKeys)
        {
            if(null == key)
            {
                break;
            }           
            for(String s : keys)
            {
                if(key.equals(s))
                {
                    count++;
                }               
            }
        //    System.out.println("Count of ["+key+"] is : "+count);
            feq++;
            num=count+num;
            count=0;
        }
        res=feq/num;
	 
        res=res*10;
        res=Math.round(res);
        res=10-res;   
        return res;
	}
	
	
	
	 private static String[] getUniqueKeys(String[] keys)
	    {
	        String[] uniqueKeys = new String[keys.length];

	        uniqueKeys[0] = keys[0];
	        int uniqueKeyIndex = 1;
	        boolean keyAlreadyExists = false;

	        for(int i=1; i<keys.length ; i++)
	        {
	            for(int j=0; j<=uniqueKeyIndex; j++)
	            {
	                if(keys[i].equals(uniqueKeys[j]))
	                {
	                    keyAlreadyExists = true;
	                }
	            }           

	            if(!keyAlreadyExists)
	            {
	                uniqueKeys[uniqueKeyIndex] = keys[i];
	                uniqueKeyIndex++;               
	            }
	            keyAlreadyExists = false;
	        }       
	        return uniqueKeys;
	    }	
}