/***
 * This class represents a blank square--it can be used as a smart null type to avoid
 * null errors by hitting a truly empty object in an Ecosystem map.
 */
package ecosim;

public class NullEntity extends Entity {
	public NullEntity(int x, int y) {
		super(x, y);		
	}

	@Override
	public void live() {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		return;
	}
	
	@Override
	public String toString() {
		return String.format("%6s%3s", "-", "-");
	}

}
