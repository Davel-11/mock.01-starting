package com.nc_mockito.unitTesting.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.nc_mockito.unitTesting.unittesting.data.SomeDataService;

public class SomeBusinessMockTest {
	
	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);
	
	@Before
	public void before() {
		business.setSomeDataService(dataServiceMock);
	}

	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		when( dataServiceMock.retrieveAllData() ).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		when( dataServiceMock.retrieveAllData() ).thenReturn(new int[] {3});
		assertEquals(3, business.calculateSumUsingDataService());
	}
}
