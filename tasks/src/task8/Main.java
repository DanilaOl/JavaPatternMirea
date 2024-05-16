package task8;

import task8.iterator.ItemList;
import task8.mediator.Colleague1;
import task8.mediator.Colleague2;
import task8.mediator.Colleague3;
import task8.mediator.MyMediator;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("-----Iterator-----");
		ItemList itemList = new ItemList(10);
		var itemIterator = itemList.createIterator();

		while (itemIterator.hasMore()) {
			System.out.println(itemIterator.getNext());
		}

		System.out.println(itemIterator.hasMore());
		System.out.println(itemIterator.getNext());

		itemIterator.reset();

		while (itemIterator.hasMore()) {
			System.out.println(itemIterator.getNext());
		}

		System.out.println("\n-----Mediator-----");

		MyMediator mediator = new MyMediator();

		Colleague1 colleague1 = new Colleague1(mediator);
		Colleague2 colleague2 = new Colleague2(mediator);
		Colleague3 colleague3 = new Colleague3(mediator);

		mediator.setFirstColleague(colleague1);
		mediator.setSecondColleague(colleague2);
		mediator.setThirdColleague(colleague3);

		colleague1.send("From Colleague1");
		colleague2.send("From Colleague2");
		colleague3.send("From Colleague3");
	}
}
