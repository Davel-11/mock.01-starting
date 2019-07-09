package com.nc_mockito.unitTesting.unittesting.business;

import static org.junit.Assert.*;
import org.junit.Test;

import com.nc_mockito.unitTesting.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int [] {1, 2, 3};
	}
}

class SomeDataServiceEmptyStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int [] {};
	}
}

class SomeDataServiceOneElementStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int [] {3};
	}
}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 3;
		assertEquals(actualResult, expectedResult);
	}
}
