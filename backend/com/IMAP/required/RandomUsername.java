package com.IMAP.required;

import java.util.Random;

public class RandomUsername {
	private final char[] NUMERIC = ("1234567890").toCharArray();
	
	public String generateUsername(int length)
	{
		StringBuffer result=new StringBuffer();
		for(int i=0;i<length;i++)
		{
			result.append(NUMERIC[new Random().nextInt(NUMERIC.length)]);
			
		}
		return result.toString();
	}
}
