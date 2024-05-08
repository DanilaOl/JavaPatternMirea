package task5;

public class Singleton2 { // Eager loaded singleton
	private static Singleton2 instance = new Singleton2();

	private Singleton2() {}

	public static Singleton2 getInstance() {
		return instance;
	}
}
