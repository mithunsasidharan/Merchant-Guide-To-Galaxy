package test.com.app.logic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.com.app.logic.RomanToDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RomanToDecimalTest{

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	protected String romanNumeral, anotherRomanNumeral;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Before
	public void setUp() throws Exception {
		romanNumeral = "MCMXLIV";
		anotherRomanNumeral = "MMMM";
	}

	@Test
	/**
	 * Test the scenario of Roman to Numeric Conversion.
	 */
	public void testRomanToDecimal(){
		RomanToDecimal romanToDecimal = new RomanToDecimal();
		float numericValue = romanToDecimal.romanToDecimal(romanNumeral);
		Assert.assertEquals(1944.00, numericValue, 00.00);
	}

	@Test
	/**
	 * Test the scenario where Non repeatable Roman Numeral repeats 4 times successively thereby throwing error.
	 */
	public void testRomanToDecimalFailing(){
		RomanToDecimal romanToDecimal1 = new RomanToDecimal();
		float value = romanToDecimal1.romanToDecimal(anotherRomanNumeral);
		Assert.assertEquals("Error : Roman Numeral M cannot repeat 4 times successively", errContent.toString());
	}

}
