package ru.mirea.task10.components;

import ru.mirea.task10.interfaces.Programmer;

public class Senior implements Programmer {

	@Override
	public void doCoding() {
		System.out.println("I'm a senior programmer");
	}
}
