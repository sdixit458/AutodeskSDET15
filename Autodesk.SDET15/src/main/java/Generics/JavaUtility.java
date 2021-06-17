package Generics;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;
/**
 * This class has all the java related generics methods like random Number
 * @author Saurabh
 *
 */
public class JavaUtility {
	 Date dateobj = new  Date();
	/**
	 * This method will return a random number
	 * @author Saurabh
	 * @return
	 */

	public int getRandomNumber() {
		Random random=new Random();
		int ran = random.nextInt(1000);
		return ran;
	}
	public String getCurrentDate() 
	{
		String todaysdate= dateobj.toString().replaceAll(" ", "_").replace(":", "_");
		return todaysdate;
	}

	public String getCurrentYear() 
	{
		String todaysdate= dateobj.toString();
		String[] arr = todaysdate.split(" ");
		return arr[5];
	}

}
