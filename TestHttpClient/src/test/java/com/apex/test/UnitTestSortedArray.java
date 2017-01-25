package com.apex.test;
import org.junit.Test;
import java.util.Arrays;
import org.junit.Assert;


public class UnitTestSortedArray {


@Test
public void testSort() {
  int[] arr = {1,2,3};
  int[] expected = {1,2,3};
  Arrays.sort(arr);
  Assert.assertArrayEquals(expected, arr);
}	
	
}
