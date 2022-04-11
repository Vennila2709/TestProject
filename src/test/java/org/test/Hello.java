package org.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hello {
	@Test(groups="Sanity")
	public void test1() {
		Assert.assertTrue(true,"Assert pass");
	}
	
	@Test(groups="Sanity", retryAnalyzer=ExecuteFailedTCs.class)
	public void test2() {
		Assert.assertTrue(false,"Assert fail");
		System.out.println("Fail");
	}
	
	@Test(groups="Retesting")
	public void test3() {
		Assert.assertTrue(true,"Assert pass");
	}
	
	@Test(groups="Retesting")
	public void test4() {
		Assert.assertTrue(true,"Assert pass");
	}
	
	@Test
	public void test5() {
		Assert.assertTrue(false,"Assert fail");
		System.out.println("Fail");
	}
	
	@Test
	public void test6() {
		Assert.assertTrue(true,"Assert pass");
	}


}
