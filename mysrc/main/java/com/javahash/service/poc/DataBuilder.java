package com.javahash.service.poc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataBuilder {
	
	private List <Stock> stockList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBuilder db = new DataBuilder();
		db.buildData();
	}
	
	
	public void buildData()
	{
		long startTime = System.currentTimeMillis();
		System.out.println(" Start Time --> "+startTime);
		
		stockList = new ArrayList<Stock>(1000000);
		
		System.out.println(" ArrayList Created --> "+System.currentTimeMillis());
		
		for(int i=0;i<4000000; i++)
		{
			stockList.add(buildStock(i));
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(" End Time --> "+endTime);
		
		long totalTime = endTime- startTime;
		
		System.out.println(" Total Time in Seconds --> "+totalTime/1000);
		System.out.println(" Stock List --> "+stockList.size());
		
		System.out.println(" Stock 1000000 --> "+stockList.get(stockList.size()-1).getStockName());
		
	}
	
	private void buildStockData()
	{
		
		int start =0;
		int end = 1000000-1;
		
		for(int i=0;i<4; i++)
		{
			
			Stockbuilder sb = new Stockbuilder(start, end);
			
			Thread t = new Thread(sb);
			
			start= end+1;
			end = end+1000000;
		}
		
	}

}
