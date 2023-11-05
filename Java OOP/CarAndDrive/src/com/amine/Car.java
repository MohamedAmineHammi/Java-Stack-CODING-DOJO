package com.amine;

public class Car {
	public int gas = 10;

	public void status() {
		if (gas >0) {
		System.out.println("Gas remaining: " + gas + "/10");}
		else {
			System.out.println("Game Over !");
		}

	}

}
