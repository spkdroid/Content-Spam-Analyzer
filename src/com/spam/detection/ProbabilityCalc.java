package com.spam.detection;

import java.io.File;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.spam.htmltoplain.HtmlToPlainText;


public class ProbabilityCalc {

	private static int anchortext;
	private static int wordtext;
	private static float percentage;
	
	private static String result;
	
	
	HtmlToPlainText pp=new HtmlToPlainText();
	
	
	String AnchorTag(String s)
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
      
      if(percentage>0.60)
      {
    	  result="HIGH";
      }
      else if(percentage<0.60 && percentage>0.30)
      {
    	  result="MEDIUM";
      }
      else if(percentage>0.10 && percentage<0.30)
      {
    	  result="NORMAL";
      }
      else
      {
    	  result="LOW";
      }
		return result;
	}
	
	
	
	String avgWordLength(String s)
	{
		
		float wordcount=0;
		float avgword=0;
		float b;
		String q;
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
          
          if(b>10)
          {
        	  q="HIGH";
          }
          else if(b<10 && b>6)
          {
        	  q="MEDIUM";
          }
          else if(b<6 && b>3)
          {
        	  q="NORMAL";
          }
          else
          {
        	  q="LOW";
          }
		return q;
	}
	
	
	String wordcount(String s)
	{
		String b;
        Document doc=Jsoup.parse(s);
        String plainText = pp.getPlainText(doc);
        String[] words=plainText.split("[\\s']");
        
        int len=words.length;
        
        if(len>3000)
        {
        	b="HIGH";
        }
        else if(len>1000 && len<3000)
        {
        	b="MEDIUM";
        }
        else if(len>500 && len<1000)
        {
        	b="NORMAL";
        }
        else
        {
        	b="LOW";
        }
	return b;
	}	
	
	String Title(String s)
	{
		String b;
		Document doc=Jsoup.parse(s);
        String title=doc.title(); 
        int title_len=title.length();
        
        if(title_len>70)
        {
        	b="HIGH";
        }
        else if(title_len>50 && title_len<70)
        {
        	b="MEDIUM";
        }
        else if(title_len>25 && title_len<50)
        {
        	b="NORMAL";
        }
        else
        {
        	b="LOW";
        }
		return b;
	}
	
	String visibility(String s)
	{
		float a,b,c;
		String r;
		a=s.length();
	     Document doc=Jsoup.parse(s);
         String plainText = pp.getPlainText(doc);
        b=plainText.length();
		
        if(a>0 && b>0)
        {
        c=a/b;
        }
        else
        {
        	c=0;
        }
        
        if(c<0.10)
        {
        	r="HIGH";
        }
        else if(c<0.40 && c>0.10)
        {
        	r="MEDIUM";
        }
        else if(c<0.60 && c<0.40)
        {
        	r="NORMAL";
        }
        else
        {
        	r="LOW";
        }
		return r;
	}
	
	
	String popularRatio(ArrayList<String> ar,String s)
	{
		
		Document doc=Jsoup.parse(s);
        String plainText = pp.getPlainText(doc);
        String[] words=plainText.split("[\\s']");

    String a;
    int count=0;
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
 	   val=count/500;
    }
    else
    {
 	   val=0;
    }
     
    if(val<0.10)
    {
    	a="HIGH";
    }
    else if(val>0.10 && val<0.20)
    {
    	a="MEDIUM";
    }
    else if(val>0.20 && val<0.30)
    {
    	a="NORMAL";
    }
    else
    {
    	a="LOW";
    }
		return a;
	}
}