package test.com.app.start;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import main.com.app.logic.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProgramTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	protected String filePath;

	@Before
	public void setUpStreams() {
		filePath = null;
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	/**
	 * Method tests a positive scenario of the application. Input file by default picked up by the input.
	 */
	public void testProgram() throws IOException{
		InputProcessor.ProcessFile(filePath);
		InputProcessor.MapTokentoIntegerValue();
		OutputProcessor.processReplyForQuestion();
		Assert.assertEquals("how much is pish tegj glob glob ? pish tegj glob glob is 42.0\n" +
				"how many Credits is glob prok Iron ? glob prok Iron is 782.0 Credits\n" +
				"how many Credits is glob prok Gold ? glob prok Gold is 57800.0 Credits\n" +
				"how many Credits is glob prok Silver ? glob prok Silver is 68.0 Credits\n"
				, outContent.toString());
	}

}
