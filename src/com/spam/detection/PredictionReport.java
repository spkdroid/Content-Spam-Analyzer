package com.spam.detection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class PredictionReport {

	private static int count;
	static ArrayList<String> in=new ArrayList<String>();
	
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

	        
	     
	        PrintStream out;
		 	try {
				out = new PrintStream(new FileOutputStream("test1.txt"));
				System.setOut(out);
			} 
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
	     
	     
	     
		
		ProbabilityCalc p=new ProbabilityCalc();
		
		count=0;

	    for (File file : listOfFiles) {
	    	if (file.isFile()) {
	    	  
	    		File np=new File(file.getAbsolutePath());
		        StringBuilder sb = new StringBuilder();
		        br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
		              while ( (line=br.readLine()) != null) {
		           sb.append(line);
		           }
		             count++; 
		           //System.out.print("File "+count++);
		           System.out.print(p.AnchorTag(sb.toString()));
		           System.out.print(" ");
		           System.out.print(p.avgWordLength(sb.toString()));
		           System.out.print(" ");
		           System.out.print(p.wordcount(sb.toString()));
		           System.out.print(" ");
		           System.out.print(p.Title(sb.toString()));
		           System.out.print(" ");
		           System.out.print(p.visibility(sb.toString()));
		           System.out.print(" ");
		           System.out.print(p.popularRatio(in,sb.toString()));
		           System.out.print(" ");
		           System.out.print("SPAM");
		           System.out.println();
		        
		           
		        
		           if(count==100)
		           {
		        	   System.exit(0);
		           }
	    	}	
	    }
		
	}
}
