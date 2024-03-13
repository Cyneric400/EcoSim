package ecosim;

public class Cougar extends Animal {
	
	private String foodSource = "Deer";

	public Cougar(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void live() {
		this.age++;
		// Code for dying
	}
	
	@Override
	public void eat() {
		// TODO: Expand
	}
	
	@Override
	public void die() {
		// TODO: Expand
		// Or should this be outside of the Animal class?
		// Yeah, probably outside of the animal class. Or this.die should call an external kill method.
	}
	
	@Override
	public void move() {
		
	}
}
