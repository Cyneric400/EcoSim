package ecosim;

public class EcosysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[] creatures = {new Deer(0, 0), new Deer(5, 0), new Deer(9, 9), new Cougar(5, 5)};
		Ecosystem ecosys = new Ecosystem(10, creatures);
		ecosys.printMap();
		ecosys.year();
		ecosys.year();
		ecosys.year();
		ecosys.printMap();
	}

}
