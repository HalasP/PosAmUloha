package sk.fiit.halas.posam.problem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import sk.fiit.halas.posam.data.DataInputFromBuffer;
import sk.fiit.halas.posam.data.InputProperties;

public class ProblemSolution {

	public static void main(String[] args) {
		DataInputFromBuffer dataFromBuffer = new DataInputFromBuffer();
		ProblemRepresentation problem = null;
		String fileName = "";
		if(args.length == 0)
	    {
			problem = getProblemFromConsole(dataFromBuffer);
	    } else if ("-file".equals(args[0]) && args.length == 1){
	    	fileName = InputProperties.getInstance().getValue("FILE_PATH");
	    	problem = getProblemFromFile(fileName, dataFromBuffer);
	    } else if (args.length == 2) {
	    	fileName = args[1];
	    	problem = getProblemFromFile(fileName, dataFromBuffer);
	    }
	    //solve the problem
	}

	private static ProblemRepresentation getProblemFromConsole(DataInputFromBuffer dataFromBuffer) {
		ProblemRepresentation problem = null;
		InputStreamReader inputReader = new InputStreamReader(System.in);
		try {
			problem = dataFromBuffer.getProblemRepresentation(new BufferedReader(inputReader));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			inputReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return problem;
	}

	private static ProblemRepresentation getProblemFromFile(String fileName, DataInputFromBuffer dataFromBuffer) {
		ProblemRepresentation problem = null;
		FileInputStream inputStream = null;
		InputStreamReader inputReader = null;
		try {
			inputStream  = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		inputReader = new InputStreamReader(inputStream);
		try {
			problem = dataFromBuffer.getProblemRepresentation(new BufferedReader(inputReader));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return problem;
	}

}
