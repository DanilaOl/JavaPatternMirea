package task4;

import java.util.concurrent.Callable;

public class SecondTask implements Callable<String> {
	final String input;

	public SecondTask(String input) {
		this.input = input;
	}

	@Override
	public String call() throws Exception {
		return input + " " + input;
	}
}
