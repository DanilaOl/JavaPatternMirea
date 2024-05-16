package task8.mediator;

public class Colleague3 extends Colleague{
	public Colleague3(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void notify(String message) {
		System.out.println(message + ". Received by Colleague3");
	}
}
