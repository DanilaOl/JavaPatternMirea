package task8.mediator;

public class Colleague2 extends Colleague{
	public Colleague2(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void notify(String message) {
		System.out.println(message + ". Received by Colleague2");
	}
}
