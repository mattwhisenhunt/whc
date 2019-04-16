package com.example.demo;

import org.junit.Test;

public class WindTests {

	@Test
	public void instantiate() {
		Wind w = new Wind(3.1, 70.0);
		assert w.getSpeed() == 3.1;
		assert w.getDirection() == 70.0;
	}

	@Test
	public void setters() {
		Wind w = new Wind();
		w.setSpeed(3.1);
		w.setDirection(70.0);
		assert w.getSpeed() == 3.1;
		assert w.getDirection() == 70.0;
	}
}
