package com.spam.detection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import com.spam.test.SpamDetectionTest;

public class SpamTestCalc {

	
	private static int anchortag[]=new int[100];
	private static int averagewordlen[]=new int[100];
	private static int wordcount[]=new int[100];
	private static int title[]=new int[100];
	private static int visibility[]=new int[100];
	private static int popratio[]=new int[100];
	private static int redundant[]=new int[100];
    	
	
	public static void main(String args[]) throws IOException
	{
		SpamDetectionTest test=new SpamDetectionTest();
		 File folder = new File("A:\\spambank\\Cluster1");
		 File[] listOfFiles = folder.listFiles();
	     System.out.println(listOfFiles.length);
	     int b;
	     float res;
	     String line;
	     ArrayList<String> in=new ArrayList<String>();
	     
	     File fr=new File("500pop.txt");
	        BufferedReader br1 = new BufferedReader(new FileReader(fr.getAbsoluteFile()));
	        ;
	        while ( (line=br1.readLine()) != null) {
	        in.add(line.trim());
	        }   
	        System.out.println(in.size());
	     
	        PrintStream out;
		 	try {
				out = new PrintStream(new FileOutputStream("SPAM.txt"));
				System.setOut(out);
			} 
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
	        
	        
	     for (File file : listOfFiles) {
		    	if (file.isFile()) {
		    		File fp=new File(file.getAbsolutePath());
		    	      BufferedReader br = new BufferedReader(new FileReader(fp.getAbsoluteFile()));
			        StringBuilder sb = new StringBuilder();
			        br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
			              while ( (line=br.readLine()) != null) {
			           sb.append(line);
			           }
			              
			              
			        /*
			         * 
			         * Anchor Tag Ratio Calculation Starts here
			         * 
			         */   
		//	        System.out.println("File: "+filecounter++);      
			        
			        
		//	        System.out.println("Anchor Tag Ratio:");
			        res=test.anchorTagRatioTest(sb.toString());
		 //   	    System.out.println(res);
		    	    b=(int)(res*100);
		    //	    System.out.println(b);
		    	    anchortag[b]++;
		    	    b=b/10;
		    	    b=Math.round(b);
		    	    System.out.print((b+1)+" ");
		    	  /*
		    	   * Average Word Length Calculation
		    	   * 
		    	   */
		 //   	    System.out.println("Average Word Length:");
		    	    res=test.AverageWordLength(sb.toString());
		  //  	    System.out.println(res);
		    	    b=(int) res;
		    //	    System.out.println(b);
		    	    averagewordlen[b]++;
		    	    b=b/10;
		    	    b=Math.round(b);
		    	    System.out.print((b+1)+" ");
		    	  
		    	    
		    	    /*
		    	     * 
		    	     * Word Count Calculation
		    	     * 
		    	     */
		   // 	    System.out.println("Word Count");
		    	    res=test.wordCount(sb.toString());
		    //	    System.out.println(res);
		    	    b=(int)res;
		    //	    System.out.println(b);
		    	    wordcount[b]++;
		    	  
		    	    b=b/10;
		    	    b=Math.round(b);
		    	    System.out.print((b+1)+" ");
		    	    
		    	    /*
		    	     * 
		    	     * Title Length
		    	     * 
		    	     */
		    //	    System.out.println("Title Length");
		    	    res=test.wordCount(sb.toString());
		    //	    System.out.println(res);
		    	    b=(int)res;
		    	    title[b]++;
		    	    
		    	    b=b/10;
		    	    b=Math.round(b);
		    	    System.out.print((b+1)+" ");
		    	  
		    	    
		    	    /*
		    	     * 
		    	     * Visibility Ratio
		    	     * 
		    	     */
		    	    
		  //  	    System.out.println("Visibility Ratio");
		    	    res=test.visibilityRation(sb.toString());
		   // 	    System.out.println(res);
		    	    b=(int)res;
		    	    if(b>=99)
		    	    {
		    	    	b=99;
		    	    }
		    	    visibility[b]++;
		    	    b=b/10;
		    	    b=Math.round(b);
		    	    b=9-b;
		    	    System.out.print((b+1)+" ");
		    	  
		    	    
		   // 	    System.out.println("Popular key word ratio");
		    	    res=test.popularRation(in,sb.toString());
		   // 	    System.out.println(res);
		    	    b=(int)res;
		    	   
		    	    if(b>=99)
		    	    {
		    	    	b=99;
		    	    } 
		    	    
		    	    popratio[b]++;
		    	    b=b/10;
		    	    b=Math.round(b);
		    	    System.out.print((b+1)+" ");
		    	    
		    	    res=test.redunt(sb.toString());
		    	    b=(int)(res*100);
		    	    if(b>=99)
		    	    {
		    	    b=99;	
		    	    }
		    	    redundant[b]++;
		    	    b=b/10;
		    	    b=Math.round(b);
		    	    b=9-b;
		    	    System.out.print((b+1)+" ");
		    	    
		    	    System.out.print("S");
		    	    System.out.println("");
		    	}
	}
	     
	     
	     
	     
	        try {
				out = new PrintStream(new FileOutputStream("SPAMCLASSIFIED.txt"));
				System.setOut(out);
			} 
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
	     
	     
	     System.out.println("Final Result for the Anchor Tag Variation");    
	     for(int i=0;i<100;i++)
	     {
	    	 System.out.println(i+" "+anchortag[i]);
	     }
	     
	     System.out.println("Final Result for the Average Word Length");
	     for (int i = 0; i < 100; i++) {
			System.out.println(i+" "+averagewordlen[i]);
		}
	     
	     
	     System.out.println("Final Result for the Word Count");
	    
	     for (int i = 0; i < 100; i++) {
				System.out.println(i+" "+wordcount[i]);
	     }
	     
	     System.out.println("Final Result for Title Length");
	     for (int i = 0; i < 100; i++) {
				System.out.println(i+" "+title[i]);
			}
	     
		 System.out.println("Final Result for Visibility Ratio");   
		 {
			 for(int i=0;i<100;i++)
			 {
				 System.out.println(i+" "+visibility[i]);
			 } 
		 }
		 
		 System.out.println("Final Result for Popular Ratio");   
		 {
			 for(int i=0;i<100;i++)
			 {
				 System.out.println(i+" "+popratio[i]);
			 } 
		 }
		
		 System.out.println("Final Result for Redundant");   
		 {
			 for(int i=0;i<100;i++)
			 {
				 System.out.println(i+" "+redundant[i]);
			 } 
		 }
	}
}
