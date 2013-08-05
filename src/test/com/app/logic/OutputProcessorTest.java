package test.com.app.logic;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OutputProcessorTest extends TestCase{

	protected String query, inputQuery;
	protected ArrayList<String> output = new ArrayList<String>();

	@Before
	public void setUp() throws Exception {
		inputQuery = query = "how much wood could a woodchuck chuck if a woodchuck could chuck= wood ?";
		output.add("glob");output.add("is");output.add("1");
	}

	@Test
	/**
	 * Test if the regex pattern is able to catch bad input.
	 */
	public void testIsValidinput(){
		Pattern regex = Pattern.compile("[$&+,:;=@#|]");
		Matcher matcher = regex.matcher(query);
		Assert.assertTrue(matcher.find());

	}

	@Test
	/**
	 * Test the outputFormatter method which neatly displays the response to any query
	 */
	public void testOutputFormatter(){
		String finalOutput = output.toString().replace(",", "").replace("[", "").replace("]", "");
		Assert.assertEquals("glob is 1", finalOutput);
	}
}
