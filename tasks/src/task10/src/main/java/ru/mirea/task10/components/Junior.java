package ru.mirea.task10.components;

import ru.mirea.task10.interfaces.Programmer;

public class Junior implements Programmer {

	@Override
	public void doCoding() {
		System.out.println("I'm a junior programmer");
	}
}
