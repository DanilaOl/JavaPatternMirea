package task8.mediator;

public interface Mediator {
	void send(String message, Colleague sender) throws Exception;
}
