package task5;

public class Singleton1 { // Lazy loaded singleton
	private static Singleton1 instance;

	private Singleton1() {}

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
