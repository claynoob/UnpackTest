package com.panerabread.auit.webdriverutils;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CSVReader {
		
	public static Collection<Object[]> getData(String location) throws IOException {
		Reader in = new FileReader(location);
		BufferedReader br = new BufferedReader(new FileReader(location));
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
		List<Object[]> userInfo = new ArrayList<>();
		while ((br.readLine()) !=null) {
			for (final CSVRecord record : records) {
				if (record.get(0).equalsIgnoreCase("")) {
					userInfo.add(new Object[]{record});
				}
			}	
		}
		System.out.println("User Info: " + userInfo);
		br.close();
		return userInfo;
	}
	
	public static Collection<Object[]> getSoupDayData(ArrayList<String> scheduleDates) throws IOException {
		String location = "C://Users//Onshore//Desktop//Data-Driven//SoupItemData.csv";
		Reader in = new FileReader(location);
		BufferedReader br = new BufferedReader(new FileReader(location));
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
		List<Object[]> userInfo = new ArrayList<>();
		while ((br.readLine()) !=null) {
			for (final CSVRecord record : records) {
				//System.out.println(record.get(record.size() - 1));
				//System.out.println(scheduleDates.get(0));
				//System.out.println(scheduleDates.get(1));
				if (record.get(record.size() - 1).equalsIgnoreCase(scheduleDates.get(0))) {
					userInfo.add(new Object[]{record});
				}
				try {
					if (record.get(record.size() - 1).equalsIgnoreCase(scheduleDates.get(1))) {
						userInfo.add(new Object[]{record});
					}
				}
				catch (Exception e) {
				}
				if (record.get(record.size() - 1).equalsIgnoreCase("Every day")) {
					userInfo.add(new Object[]{record});
				}
			}	
		}
		System.out.println("User Info: " + userInfo);
		br.close();
		return userInfo;
	}
   
}