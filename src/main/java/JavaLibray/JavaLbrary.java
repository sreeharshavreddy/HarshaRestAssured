package JavaLibray;

import java.util.Random;

public class JavaLbrary {

	/*
	 * This class contains generic methods related to java
	 * 
	 */
	public int getRandomNumber()
	{
		/*
		 * This method generates random number
		 */
		Random ran=new Random();
		int random = ran.nextInt(500);
		return random;
	}
}
