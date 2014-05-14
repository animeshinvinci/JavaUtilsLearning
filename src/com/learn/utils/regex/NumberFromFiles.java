package com.learn.utils.regex;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberFromFiles {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "";
		boolean isLessThanMedian=true;
		int k=0;
		int median = 0;
		
		if(args.length < 4){
			path = args[0];
			isLessThanMedian = Boolean.parseBoolean(args[1]);
			k = Integer.parseInt(args[2]);
			median = Integer.parseInt(args[3]);
		}
		else
			System.out.println("Please Enter Path & Boolen if number is less than Median then true other false , then k size of list and then median value");
		    System.exit(0);
		
		File[] fileList = getListOfFiles(path);
		for(File file:fileList){
		Scanner scan = new Scanner(file);
		List<Integer> kList = new ArrayList<Integer>();
		
		
		while(scan.hasNext()){
			String dataStr = scan.next();
			String[] dataList = dataStr.split(",");
			for(String data:dataList){
				int intdata = Integer.parseInt(data);
			
				if ((!isLessThanMedian) && ((kList.size() < k) && (median < intdata)) ){
				kList.add(intdata);
				}
				
			    if ((isLessThanMedian)&& ((kList.size() < k) && (median > intdata))){
						kList.add(intdata);
					}
				else 
				addDataList(isLessThanMedian,median,intdata,kList);
					
				}
			}
		}
	}

	private static File[] getListOfFiles(String path) {
		// TODO Auto-generated method stub
		  File folder = new File(path);
		  File[] listOfFiles = folder.listFiles(); 
		  return listOfFiles;
	}


	private static void addDataList(boolean isLessThanMedian,int median,int intdata,List<Integer> kList) {
		Collections.sort(kList);
		int firstdata = kList.get(0);
		
		int lastdata = kList.get(kList.size()-1);
		
		 if ((isLessThanMedian)&& ((median < intdata) && ((intdata < firstdata) || ((intdata > firstdata) && (intdata < lastdata))))){
			 kList.remove(kList.size()-1);
			 kList.add(intdata);
		 }
		 if ((isLessThanMedian)&& ((median > intdata) && ((intdata > lastdata) || ((intdata < lastdata) && (intdata > firstdata))))){
			 kList.remove(0);
			 kList.add(intdata);
		 }
	}

	
	
}
