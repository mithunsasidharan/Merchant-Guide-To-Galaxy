package main.com.app.start;

import main.com.app.logic.InputProcessor;
import main.com.app.logic.OutputProcessor;

public class Program{

	/**
	 * If no argument is provided then the input file present inside main.com.app.logic package is
	 * picked up as input file by default.
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = null;
		if (args.length != 0)
			filePath = args[0];
		try{
			InputProcessor.ProcessFile(filePath);
			InputProcessor.MapTokentoIntegerValue();
			OutputProcessor.processReplyForQuestion();
		}
		catch(Exception e){
			System.out.println("Oops !! File Not Found ");
		}
	}

}
