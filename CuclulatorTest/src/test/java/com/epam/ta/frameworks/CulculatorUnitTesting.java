package com.epam.ta.frameworks;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.epam.tat.module4.Calculator;

@Execution(ExecutionMode.SAME_THREAD)
public class CulculatorUnitTesting {
	private static Calculator calculator;

	@BeforeAll
	public static void setCuclulatorInstanse() {
		calculator = new Calculator();
	}
	
	@ParameterizedTest
	@CsvSource({"5.0, 5.0, 10.0",
				"-5.0, 5.0, 0.0",
				"5.5, 0.0, 5.5"})
	public void sumDoubleTest(double number1, double number2, double result) {
		double actualResult = calculator.sum(number1, number2);
		assertEquals(result, actualResult);
	}

	@ParameterizedTest
	@CsvSource({"500000000, 500000000, 1000000000",
				"1, 50000000, 50000001",
				"500000000, 0, 500000000"})
	public void sumLongTest(long number1, long number2, long result) {
		long actualResult = calculator.sum(number1, number2);
		assertEquals(result, actualResult);
	}
	
	@ParameterizedTest
	@CsvSource({"90, 0",
				"0, 1",
				"45, 0.7071"})
				
	public void cosTest(double number1, double result) {
		double actualResult = calculator.cos(number1);
		assertEquals(result, actualResult, 0.0001);
	}
	

	@Test
	public void divDoubleTest() {
		double actualResult = calculator.div(5,5);
		assertEquals(1, actualResult);
	}
	@Test
	public void divLongTest() {
		long actualResult = calculator.div(50000000000l,50000000000l);
		assertEquals(1, actualResult);
	}
	@Test
	public void isNegativeTest() {
		boolean actualResult = calculator.isNegative(-5);
		assertEquals(true, actualResult);
		actualResult = calculator.isNegative(5);
		assertEquals(false, actualResult);
	}
	@Test
	public void isPositiveTest() {
		boolean actualResult = calculator.isPositive(5);
		assertEquals(true, actualResult);
		actualResult = calculator.isPositive(-5);
		assertEquals(actualResult, false);
	}
	@Test
	public void multDoubleTest() {
		double actualResult = calculator.mult(5,5);
		assertEquals(25, actualResult);
	}
	@Test
	public void multLongTest() {
		long actualResult = calculator.mult(50000000000l,5);
		assertEquals(250000000000l, actualResult);
	}
	
	@Test
	public void powTest() {
		double actualResult = calculator.pow(5,2);
		assertEquals(25, actualResult);
	}
	@Test
	public void sinTest() {
		double actualResult = calculator.sin(90);
		assertEquals(1, actualResult);
	}
	@Test
	public void sgrtTest() {
		double actualResult = calculator.sqrt(25);
		assertEquals(5, actualResult);
	}
	@Test
	public void subDoubleTest() {
		double actualResult = calculator.sub(5,5);
		assertEquals(0, actualResult);
	}
	@Test
	public void subLongTest() {
		long actualResult = calculator.div(50000000000l,50000000000l);
		assertEquals(0, actualResult);
	}
	@Test
	public void tgTest() {
		double actualResult = calculator.tg(45);
		assertEquals(1, actualResult);
	}
	
	@Test
	public void ctgTest() {
		double actualResult = calculator.ctg(45);
		assertEquals(1, actualResult);
	}
	
	
	
	
	
	
	
	
}
