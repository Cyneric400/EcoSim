package ecosim;

import java.util.Arrays;

public class Ecosystem {
	private int size;
	private Entity[][] map;
	
	private Entity[][] buildMap(int size, Entity[] creatures) {
		boolean addedCreature = false;
		Point currentCoords = new Point(0, 0);
		Entity[][] mapObj = new Entity[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				currentCoords.setCoords(i, j);
				for (int k = 0; k < creatures.length; k++) {
					if (creatures[k].getCoords().equals(currentCoords)) {
						mapObj[i][j] = creatures[k];
						addedCreature = true;
						break;
					}
				}
				if (!addedCreature) {
					mapObj[i][j] = new Grass(i, j);					
				}
				addedCreature = false;
			}
		}
		return mapObj;
	}
	
	public Ecosystem(int size, Entity[] creatures) {
		this.size = size;
		this.map = buildMap(size, creatures);
	}
	
	public void printMap() {
		for (int i = 0; i < this.size; i++) {
			System.out.println(Arrays.toString(this.map[i]));
		}
	}
	
	public void year() {
		// Make each animal live for a year
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				// What about plants? Fix this later in Plant class
				if (this.map[i][j] instanceof Animal) {
					this.map[i][j].live();
				}
			}
		}
		Point currentCoords;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j<this.size; j++) {
				currentCoords = new Point(i, j);
				if ((this.map[i][j] instanceof Animal) && !(this.map[i][j].getCoords().equals(currentCoords))) {
					// This is terrible - once an observer pattern is set up, get it to recognize the
					// bounds of the ecosystem as an obstacle
					try {
						int newX = this.map[i][j].getCoords().getX();
						int newY = this.map[i][j].getCoords().getY();
						this.map[newX][newY] = this.map[i][j];
						this.map[i][j] = new NullEntity(i, j);
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Error - fix this once observer is set up");
					}
				}
			}
		}
		
		// Now that each animal has lived out a year, remove dead ones
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (!(this.map[i][j].isAlive())) {
					this.map[i][j] = new Grass(i, j);
				}
			}
		}
		
	}
}
