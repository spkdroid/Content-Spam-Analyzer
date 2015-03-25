package com.spam.html;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FetchHtml {
	
	public static void main(String args[]) throws IOException
	{
		File folder = new File("C:\\Users\\Ramkumar Velmurugan\\Desktop\\webkb\\course\\cornell");
	    File[] listOfFiles = folder.listFiles();
	    System.out.println(listOfFiles.length);
	
	    
	    for (File file : listOfFiles) {
		
	    	File np=new File(file.getAbsolutePath());
	           StringBuilder sb = new StringBuilder();
	           BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
	           String line;
	           
	           while ( (line=br.readLine()) != null) {
	           }   
	    }
	    
	    
	    
	}

}
