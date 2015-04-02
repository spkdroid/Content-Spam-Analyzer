package com.spam.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.spam.test.SpamDetectionTestUpdated;

public class SpamDetection {
	
	
	static Document doc;
	static String url;
	static String document_String;
	
	static float wordcount;
	static float averagewordlength;
	static float anchortext;
	static float title;
	static float visibility;
	static float compression;
	static float pratio;
	
	public static void main(String args[]) throws IOException
	{
		
		 String line;
	     ArrayList<String> in=new ArrayList<String>();
	     
	     File fr=new File("500pop.txt");
	        BufferedReader br1 = new BufferedReader(new FileReader(fr.getAbsoluteFile()));
	        while ( (line=br1.readLine()) != null) {
	        in.add(line.trim());
	        }   
	//        System.out.println(in.size());
	    
		
		
		
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the URL of the Site that you need to perform the test");
	
	SpamDetectionTestUpdated sp=new SpamDetectionTestUpdated();
	
	url=sc.next();
	System.out.println("The Application is Performing the Test");
	System.out.println("The URL is :"+url);
	
	try {
		doc=Jsoup.connect(url).get();
		document_String=doc.toString();
		
		wordcount=sp.wordCount(document_String);
		averagewordlength=sp.wordCount(document_String);
		anchortext=sp.anchorTagRatioTest(document_String);
		title=sp.titleLength(document_String);
		visibility=sp.visibilityRation(document_String);
		compression=sp.redunt(document_String);
		pratio=sp.popularRation(in, document_String);
		
		
           System.out.println("Word Count Rating:"+(wordcount+1));
		   System.out.println("Average Word Length Rating:"+(averagewordlength+1));
		   System.out.println("Anchor Text Rating:"+(anchortext+1));
		   System.out.println("Title Rating:"+(title+1));
		   System.out.println("Visibility Rating:"+(visibility+1));
		   System.out.println("Compression Rating:"+(compression+1));
		   System.out.println("Popular Key Word Rating:"+(pratio+1));
		   
		   
		   
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
