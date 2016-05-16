package sk.fiit.halas.posam.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sk.fiit.halas.posam.model.Furniture;
import sk.fiit.halas.posam.model.Room;
import sk.fiit.halas.posam.problem.ProblemRepresentation;

public class DataInputFromBuffer implements IDataInput {

	@Override
	public ProblemRepresentation getProblemRepresentation(BufferedReader bufferedReader) throws IOException {
		ProblemRepresentation problemRep = new ProblemRepresentation();
		Room room = new Room();
		List<Furniture> furnitureList;
        String line = "";
        try {
        	line = bufferedReader.readLine();
        	String[] numbers = line.split(",");
        	if (numbers.length != 2) {
        		throw new IllegalArgumentException("Missing length or width of room.");
        	}
        	int length = Integer.parseInt(numbers[0]);
        	int width = Integer.parseInt(numbers[1]);
        	room.setLength(length);
        	room.setWidth(width);   	
        	room.setSpaceMatrix(getSpaceMatrixOfRoom(length, width, bufferedReader));
        	line = bufferedReader.readLine();
			furnitureList = parseFurnitureInfo(bufferedReader);
		} catch (IOException e) {
			throw e;
		}  
        problemRep.setFurniture(furnitureList);
		problemRep.setRoom(room);
		return problemRep;
	}
	
	private List<Furniture> parseFurnitureInfo(BufferedReader bufferedReader) throws IOException {
		String line = "";
		List<Furniture> furnitureList = new ArrayList<>();
		while ((line = bufferedReader.readLine()) != null && !line.equals("")){
			Furniture furniture = new Furniture();
			furniture.setType(line.charAt(0));
			int width = Integer.parseInt(line.substring(1, 2));
			furniture.setWidth(width);
			String space = line.substring(2, line.length());
			int length = space.length() / width;
			furniture.setLength(length);
			boolean[][] spaceMatrix = new boolean[length][width];
			int index = 0;
			for (int i = 0; i < length; i++) {
	    		line = space.substring(index, index + width);
	    		index = index + width;
	    		for (int j = 0; j < line.length(); j++){
	    		    char c = line.charAt(j);        
	    		    if (c == '.') {
	    		    	spaceMatrix[i][j] = false;
	    		    } else {
	    		    	spaceMatrix[i][j] = true;
	    		    }
	    		}
	    	}
			furniture.setSpaceMatrix(spaceMatrix);
			furnitureList.add(furniture);
		}
		return furnitureList;
	}

	private boolean[][] getSpaceMatrixOfRoom(int length, int width, BufferedReader bufferedReader) throws IOException {
		boolean[][] spaceMatrix = new boolean[length][width];
		String line = "";
    	for (int i = 0; i < length; i++) {
    		line = bufferedReader.readLine();
    		for (int j = 0; j < line.length(); j++){
    		    char c = line.charAt(j);        
    		    if (c == '.') {
    		    	spaceMatrix[i][j] = false;
    		    } else {
    		    	spaceMatrix[i][j] = true;
    		    }
    		}
    	}
    	return spaceMatrix;
	}

}
