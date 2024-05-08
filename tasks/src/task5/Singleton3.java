package task5;

public class Singleton3 { // Bill Pugh singleton
	private Singleton3() {}

	private static class SingletonHelper {
		private static final Singleton3 instance = new Singleton3();
	}

	public static Singleton3 getInstance() {
		return SingletonHelper.instance;
	}
}
