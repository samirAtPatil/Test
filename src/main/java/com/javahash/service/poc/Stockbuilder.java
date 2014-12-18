package com.javahash.service.poc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Stockbuilder implements Callable<Object>{

	
	int start;
	int end;
	
	List interMediateList;
	
	Stockbuilder(int start, int end)
	{
	this.start=start;
	this.end=end;
	}
	
	

	public Object call() throws Exception {
		// TODO Auto-generated method stub
		
		interMediateList = new ArrayList();
		while(this.start<=this.end)
		{
			interMediateList.add(buildStock(this.start));
			this.start=this.start+1;
		}
		return interMediateList;
	}
	
	private Stock buildStock(int i)
	{
		
		Stock s = new Stock();
		s.setId(i);
		s.setStockName("Stock-ABCD-"+i);
		s.setStockPrice(" Rs - "+i);
		return s;
	}

}
