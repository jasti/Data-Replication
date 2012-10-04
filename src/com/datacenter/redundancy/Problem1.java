package com.datacenter.redundancy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem1 {

			
	/*
	 * Analysis:
	 * m=number of data centers
	 * Mi = datacenter
	 * Ni = number of missing data sets in Mi
	 * 
	 *  Minimum number of move operations = Summation(Ni) where i = 1 to m  
	 */
	
		 public static void main (String[] args) {

		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      HashMap<Integer,ArrayList<Integer>> dataSetIdMap = new HashMap<Integer,ArrayList<Integer>>();
		      Integer dataCenterCount = 0;
		      try {
		      
		    	  dataCenterCount = new Integer(br.readLine()); // Read number of data centers. Assume input is a valid integer
		      
		      for(Integer dataCenterId=1;dataCenterId<=dataCenterCount;dataCenterId++) {
		    	 String line = br.readLine();              // Read data set id's line by line
		    	 String[] dataSetIds = line.split(" ");    
		    	 ArrayList<String> strDataSetIdList = new ArrayList<String>(Arrays.asList(dataSetIds));
		    	 
		    	 //Construct map of the datacenters in which each dataSetid is present. Key="DataSetId", Value="Array List of Data Center Ids"
		    	 for(String strDataSet:strDataSetIdList) {
		    		 Integer dataSet = new Integer(strDataSet);
		    		 if(dataSetIdMap.containsKey(dataSet)) {
		    			 dataSetIdMap.get(dataSet).add(dataCenterId);
		    		 }
		    		 else {
		    			 dataSetIdMap.put(dataSet, new ArrayList<Integer>());
		    			 dataSetIdMap.get(dataSet).add(dataCenterId);
		    		 }
		    	 }
		      }
		      } catch (IOException ioe) {
			         System.out.println("IO error!!");
			         System.exit(1);
			      }
		      
		      for(Integer dataSet:dataSetIdMap.keySet()) {
		    	  	Integer from = dataSetIdMap.get(dataSet).get(0);   // "from" can be any data center in which the data set id is present
		    	  	ArrayList<Integer> dataCenterList = dataSetIdMap.get(dataSet); //dataCenterList is already pre-sorted while reading.
		    	  	
		    	  	for(Integer to =1;to<=dataCenterCount;to++) {
		    	  		if(dataCenterList.contains(to)) continue; // skip if data set id is already available in a datacenter
		    	  		System.out.println(dataSet + " " + from + " " + to);
		    	  		
		    	  	}
		    	  
		      }
		         
		      System.out.println("done");

		   }

	}

