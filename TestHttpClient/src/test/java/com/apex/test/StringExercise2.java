package com.apex.test;
import org.junit.Test;

import junit.framework.Assert;;


public class StringExercise2 {

@SuppressWarnings("deprecation")
@Test	
public void UnitTestString()
{
	boolean test;
	String A = "Test";
	String B = "Test2";
	//test = A.equalsIgnoreCase(B);
	//System.out.println(test);
	Assert.assertEquals(A, B);

}
	
	
	
}
