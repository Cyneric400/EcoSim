package ecosim;

public abstract class Entity {
	protected Point coords;
	private static int counter = 0;
	protected int id;
	protected boolean living;
	
	public Entity(int x, int y) {
		this.living = true;
		this.coords = new Point(x, y);
		this.id = counter;
		counter++;
	}

	public Point getCoords() {
		return this.coords;
	}
	

	@Override
	// Put this as a superclass method of Entity
	public String toString() {
		return String.format("%6s%3d", this.getClass().getSimpleName(), this.id);
	}
	
	public abstract void live();
	public abstract void die();
	
	
	public boolean isAlive() {
		return living;
	}
}
