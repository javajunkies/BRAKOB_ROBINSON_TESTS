package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {

	private NewTelephoneCompany sample;
	
	@Before
	public void setUp() throws Exception 
	{
		sample = new NewTelephoneCompany();
	}

	@Test (expected=UnsupportedOperationException.class)
	public void testComputeChargeInvalidStartTime()
	{
		sample.setStartTime(-5);
		sample.setDuration(10);
		sample.computeCharge();
	}
	
	@Test (expected=UnsupportedOperationException.class)
	public void testComputeChargeInvalidLength()
	{
		sample.setStartTime(1800);
		sample.setDuration(0);
		sample.computeCharge();
	}
	
	@Test
	public void testComputeChargeDiscountedStartTimeAndDiscountedDuration()
	{
		double expectedResult = 1078.48;
		sample.setStartTime(759);
		sample.setDuration(61);
		double result = sample.computeCharge();
		assertTrue("Charge is " + expectedResult, expectedResult == result );
	}
	
	@Test
	public void testComputeChargeDiscountedStartTimeOnly()
	{
		double expectedResult = 208.0;
		sample.setStartTime(2359);
		sample.setDuration(10);
		double result = sample.computeCharge();
		assertTrue("Charge is " + expectedResult, expectedResult == result );
	}
	
	@Test
	public void testComputeChargeDiscountedDurationOnly()
	{
		double expectedResult = 2156.96;
		sample.setStartTime(900);
		sample.setDuration(61);
		double result = sample.computeCharge();
		assertTrue("Charge is " + expectedResult, expectedResult == result );
	}
	
	@Test
	public void testComputeChargeNoDiscounts()
	{
		double expectedResult = 41.6;
		sample.setStartTime(800);
		sample.setDuration(1);
		double result = sample.computeCharge();
		assertTrue("Charge is " + expectedResult, expectedResult == result );
	}
	
	
	
	
}
