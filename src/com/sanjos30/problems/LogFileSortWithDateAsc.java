package com.sanjos30.problems;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LogFileSortWithDateAsc {

	
	//Given a log file containing text in the following format  
	//customerName:productID:timeStamp find the number of customers seeing the same product again with 24 hours

	public static void main(String[] args) {
		
		//Problem 1 - Find products with highest view from last 24 hours
		findHighestProductViewLast24Hours(prepareTestDataWithOutColon());
		
	}
	
	/**
		PRODUCTS WITH MOST VIEW	
	*/
	
	private static void findHighestProductViewLast24Hours(List<String> logFile) {
		if(logFile!=null){
			// Custom date format
	        SimpleDateFormat myFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss.sss"); 
			int size=logFile.size();
			
			//Map<ProductName, Map<UserName,VisitCount>>
			HashMap<String,Map<String,Integer>> prdVisitMap=new HashMap<String,Map<String,Integer>>();
			int max_visit_count=0;
			List<String> topCustomer=new LinkedList<String>();
			String topCustomerStr="";
			for(int i=0;i<size;i++){
				String logLine=logFile.get(i);
				String[] logLineArr=logLine.split(",");
				
				//This field contains the datetime from the log file
				String userName=logLineArr[0];
				String product=logLineArr[1];
				String logDateTime=logLineArr[2];
				Map<String,Integer> usrMap=new HashMap<String,Integer>();
				if(differenceFromCurrentDateTimeStrFormat(logDateTime,myFormat)<24){
					if(!prdVisitMap.containsKey(product)){
						usrMap.put(userName, 1);
						prdVisitMap.put(product, usrMap);
						if(max_visit_count<1){
							max_visit_count=1;
							}
					}else{
						int existingCount=prdVisitMap.get(product).get(userName);
						usrMap.put(userName,++existingCount);
						prdVisitMap.put(product, usrMap);
						if(max_visit_count<existingCount){
							max_visit_count=existingCount;
							topCustomerStr=userName;
						}
					}
				}else{
					//Do nothing
				}
			}
			
			
			//Browse on the Map to print the product where count is highest
			
			for (String parKey:prdVisitMap.keySet()){

				Map<String,Integer> childMap = prdVisitMap.get(parKey);
				for(Map.Entry<String, Integer> childEntry:childMap.entrySet()){
					if(childEntry.getValue()==max_visit_count){
						System.out.println("Product with Max Visit: "+parKey + " with visits: "+childEntry.getValue() + ", customer: "+ childEntry.getKey());
					}
				}
			}
			
		}
	}

	
	
	private static long differenceFromCurrentDateTimeStrFormat(String inputDateTime, SimpleDateFormat format){

		String currentDateTime=getCurrentTimeStampStringFormat();

        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(inputDateTime);
            d2=format.parse(currentDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }    

        long hours=hoursDifference(d2,d1);
        
		return hours;		
	}

	public static void printTimeDiffInHours(long diff){
	
		long days = diff/(1000 * 60 * 60 * 24);
        long hours = diff/(1000 * 60 * 60);
        long minutes = diff/(1000 * 60 );
        long seconds = diff/1000 ;

        //System.out.println("Days: " + days + ", hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds);

	}
	
	public static int hoursDifference(Date date1, Date date2) {
		long milliSecDiff=date1.getTime() - date2.getTime();
		
		//Just print the difference in days, hours, minutes
		printTimeDiffInHours(milliSecDiff);
		
		
	    final int MILLI_TO_HOUR = 1000 * 60 * 60;
	    return (int) (milliSecDiff) / MILLI_TO_HOUR;
	}
	
	public static String returnCurrentDateAsStr(String format){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(format);
        String strDate = dateFormat.format(date);
        return strDate;
	}
	
	public static SimpleDateFormat convertStrToDateTime(String inputDateTime, String dateTimeFormat){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTimeFormat);

        try
        {
            Date date = simpleDateFormat.parse(inputDateTime);

            System.out.println("date : "+simpleDateFormat.format(date));
        }
        catch (ParseException ex)
        {
            System.out.println("Exception "+ex);
        }
        
        return simpleDateFormat;
	}

	
	public static SimpleDateFormat getCurrentTimeStampDateFormat() {
		return new SimpleDateFormat("yyy-MM-dd hh:mm:ss.sss");
	}
	
	public static String getCurrentTimeStampStringFormat() {
		return new SimpleDateFormat("yyy-MM-dd hh:mm:ss.sss").format(new Date());
	}
	

	
	private static List<String> prepareTestDataWithOutColon(){
		List<String> lsStr=new LinkedList<String>();		
		lsStr.add("Sandeep,PRD01,2018-08-12 15:44:05.721");
		lsStr.add("Shweta,PRD02,2018-08-12 16:36:05.721");
		lsStr.add("Shweta,PRD02,2018-08-12 18:37:05.721");
		lsStr.add("Sandeep,PRD01,2018-08-13 15:44:05.721");
		lsStr.add("Shweta,PRD01,2018-08-11 12:38:05.721");
		lsStr.add("Dhruv,PRD01,2018-08-10 00:38:05.721");
		return lsStr;
	}

}
