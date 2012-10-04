package com.datacenter.redundancy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataCopier {

	public static void main(String[] args) throws IOException {

		Map<Integer, Set<Integer>> megaDataCenter = new HashMap<Integer, Set<Integer>>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer dataCenterCount = 0;

		try {
			dataCenterCount = new Integer(br.readLine());
		} catch (NumberFormatException e) {

		} catch (IOException e) {

		} // Read number of data centers. Assume input is a valid integer

		for (int i = 0; i < dataCenterCount; i++) {

			String data = br.readLine();
			List<String> strings = Arrays.asList(data.split(" "));

			Set<Integer> integers = new HashSet<Integer>();
			for (String s : strings) {
				integers.add(Integer.parseInt(s));
			}
			megaDataCenter.put(new Integer(i + 1), integers);
		}

		for (Map.Entry<Integer, Set<Integer>> entry1 : megaDataCenter
				.entrySet()) {
			Integer key1 = entry1.getKey();
			Set<Integer> dataSet1 = entry1.getValue();

			for (Map.Entry<Integer, Set<Integer>> entry2 : megaDataCenter
					.entrySet()) {
				Integer key2 = entry2.getKey();
				Set<Integer> dataSet2 = entry2.getValue();
				
				if (entry1.getKey() != entry2.getKey()) {
					
					for(Integer i1 :dataSet1){
						boolean exists =dataSet2.add(i1);
						
						if(exists){
							System.out.println(i1 +" "+ key1+" "+ key2);
						}
					}

				}
			}

		}
		System.out.println("Done");
	}

}  
