package task4;

import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		MyExecutorService executorService = new MyExecutorService(2);

		Future<String> task1 = executorService.submit(new FirstTask("Danila"));
		Future<String> task2 = executorService.submit(new SecondTask("Olyanin"));

		while (!(task1.isDone() && task1.isDone())) {
			Thread.sleep(1);
		}

		try {
			System.out.println("Task1: " + task1.get());
			System.out.println("Task2: " + task2.get());
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}

		executorService.shutdown();
	}
}
