package task8.mediator;

public class Colleague1 extends Colleague {
	public Colleague1(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void notify(String message) {
		System.out.println(message + ". Received by Colleague1");
	}

}
