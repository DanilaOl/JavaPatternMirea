package task5;

public class Main {
	public static void main(String[] args) {
		Singleton1 singleton11 = Singleton1.getInstance();
		Singleton1 singleton12 = Singleton1.getInstance();

		Singleton2 singleton21 = Singleton2.getInstance();
		Singleton2 singleton22 = Singleton2.getInstance();

		Singleton3 singleton31 = Singleton3.getInstance();
		Singleton3 singleton32 = Singleton3.getInstance();

		System.out.println("singleton11: " + singleton11.hashCode());
		System.out.println("singleton12: " + singleton12.hashCode());
		System.out.println("---");

		System.out.println("singleton21: " + singleton21.hashCode());
		System.out.println("singleton22: " + singleton22.hashCode());
		System.out.println("---");

		System.out.println("singleton31: " + singleton31.hashCode());
		System.out.println("singleton32: " + singleton32.hashCode());
	}
}
