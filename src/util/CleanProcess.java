package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CleanProcess {
	public static void main(String[]args){
	    try{
	        String []cmd = {"tasklist"};
		    Process proc = Runtime.getRuntime().exec(cmd);
		    BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		    String temp = in.readLine();
		    while(temp!=null){
		    	//System.out.println(temp);
		    	if(temp.indexOf("phantomjs.exe")!=-1){
		    		Runtime.getRuntime().exec("Taskkill /IM  phantomjs.exe /f");
		    		System.out.println("finished");
		    	}
		    	temp = in.readLine();
		    }
	    }
	    catch (Exception e){
		    e.printStackTrace();
	    }
	}

}
