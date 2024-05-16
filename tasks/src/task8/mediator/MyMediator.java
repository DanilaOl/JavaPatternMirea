package task8.mediator;

public class MyMediator implements Mediator{
	private Colleague1 colleague1;
	private Colleague2 colleague2;
	private Colleague3 colleague3;

	public void setFirstColleague(Colleague1 colleague1) {
		this.colleague1 = colleague1;
	}

	public void setSecondColleague(Colleague2 colleague2) {
		this.colleague2 = colleague2;
	}

	public void setThirdColleague(Colleague3 colleague3) {
		this.colleague3 = colleague3;
	}

	@Override
	public void send(String message, Colleague sender) throws Exception {
		if (sender.equals(colleague1)) {
			colleague2.notify(message);
		}
		else if (sender.equals(colleague2)){
			colleague3.notify(message);
		}
		else if (sender.equals(colleague3)) {
			colleague1.notify(message);
		}
		else {
			throw new Exception("No such sender");
		}
	}
}
