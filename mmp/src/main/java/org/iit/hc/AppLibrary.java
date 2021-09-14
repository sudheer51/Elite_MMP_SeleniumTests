package org.iit.hc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class AppLibrary {
	
	static Random rand;
	
	public static String selectDate(int days,String pattern)
	{

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		return sdf.format(d);
	}
	
	public static String generateRandom(int n,int range)
	{
		rand = new Random();
		String str = "";
		for(int j=0; j<n; j++)
		{
				str = str+ 9;	 
		}
		System.out.println(str);
			
		return str+rand.nextInt(range);
	}
	
	/**
	 * This will choose a random state
	 * @return - state 
	 */

	public static String getRandomState(){

		String state = "";

		String[] sArray = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
				"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine","Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
				"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
				"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };

		int num = rand.nextInt(49);
		state = sArray[num];
		System.out.println(state);		
		return state;
	}
	
   public static int getRandomNoOfDigits(int noOfDigits){
		
		rand = new Random();
		int addend1=0;
		int addend2=0; 
		String zero ="";
		String bound = "";
		int result=0;
		for(int i=1;i<=(noOfDigits-1); i++){
			zero = zero+0;
		}
		zero = 1+zero;
		addend1 = Integer.parseInt(zero);
		for (int j=1; j<=(noOfDigits-1); j++){
			bound = bound+9;
		}
		bound = 8+bound;
		addend2 = Integer.parseInt(bound);
		result = addend1+ rand.nextInt(addend2);
		System.out.println("Random "+noOfDigits+ " digit number is : "+result);
		return result;
		
	}
   /**
	 * This is to generate a random string for input data
	 * @param -int value of total no. of characters need to be in the input data
	 * @return - a random String
	 */
	public static String getRandomString(int noOfChars){

		rand = new Random();
		String s = "";
		int bound = noOfChars;
		for(int i=0; i<bound; i++){
			char c = (char) ('a'+rand.nextInt(26));
			s = s+c;
		}
		System.out.println("getRandomString Method returning "+s);
		return s;
	}
	


}
