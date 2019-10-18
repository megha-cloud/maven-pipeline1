package com.devops.practice.test;

import org.junit.Test;

import com.devops.practice.DevopsPracticeHelper;

public class DevopsPracticeHelperTest{
	
	DevopsPracticeHelper helper = new DevopsPracticeHelper();
	
	@Test
	public void addTest(){
		
		helper.add();	
	}
	
	@Test
	public void subtractTest(){
		
		helper.subtract();	
	}
	
	@Test
	public void multiplyTest(){
		
		helper.multiply();	
	}
	
	@Test
	public void divideTest(){
		
		helper.divide();	
	}

}
