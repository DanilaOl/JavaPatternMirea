package task4;

import java.util.concurrent.Callable;

//@SuppressWarnings("ClassCanBeRecord")
public class FirstTask implements Callable<String> {
	final String input;

	public FirstTask(String input) {
		this.input = input;
	}

	@Override
	public String call() {
		StringBuilder builder = new StringBuilder(input);
		builder.reverse();
		return builder.toString();
	}
}
