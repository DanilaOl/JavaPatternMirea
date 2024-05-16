package task8.mediator;

public abstract class Colleague {
	protected final Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

	public void send(String message) throws Exception {
		mediator.send(message, this);
	}

	public abstract void notify(String message);
}
