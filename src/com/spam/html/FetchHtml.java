package com.spam.html;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.spam.test.SpamDetectionTest;

public class FetchHtml {
	
	static ArrayList<String> in=new ArrayList<String>();
	
	static int filecount;
	
	public static void main(String args[]) throws IOException
	{
		
		
		 File folder = new File("A:\\spambank\\Cluster1");
		 File[] listOfFiles = folder.listFiles();
	     System.out.println(listOfFiles.length);
	     
	     
    	    File fp=new File("500pop.txt");
	        BufferedReader br = new BufferedReader(new FileReader(fp.getAbsoluteFile()));
	        String line;
	        while ( (line=br.readLine()) != null) {
	        in.add(line.trim());
	        }   
	        System.out.println(in.size());

	    	
	    
	    for (File file : listOfFiles) {
		
	    	File np=new File(file.getAbsolutePath());
	           StringBuilder sb = new StringBuilder();
	           br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
	           
	           while ( (line=br.readLine()) != null) {
	           sb.append(line);
	           }   
	           System.out.println(filecount++);
	           SpamDetectionTest sp=new SpamDetectionTest();
	     //      System.out.println(sp.popularRation(in,sb.toString()));
               System.out.println(sp.redunt(sb.toString()));
	    }
	}
}
