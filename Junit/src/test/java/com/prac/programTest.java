package com.prac;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class programTest {

	@Test
	void test() {
		program p = new program();
		assertEquals(5,p.add(3, 2));
	}
	
	@Test
	void test2() {
		program p = new program();
		assertEquals(false,p.isPalindrome("Java"));
	}

	@Test
	void Test3(){
		int arr[] = {1,2,3,4};
		int num[] = {1,2,3,4};
		
		assertArrayEquals(arr,num);
		
		
	}
}
