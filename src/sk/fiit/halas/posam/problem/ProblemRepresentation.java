package sk.fiit.halas.posam.problem;

import sk.fiit.halas.posam.model.Room;

import java.util.List;

import sk.fiit.halas.posam.model.Furniture;

public class ProblemRepresentation {

	private Room room;
	private List<Furniture> furniture;
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public List<Furniture> getFurniture() {
		return furniture;
	}
	public void setFurniture(List<Furniture> furniture) {
		this.furniture = furniture;
	}
	
	
}
