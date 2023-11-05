package com.amine;

public class Drive extends Car {

	public void Driving() {
		System.out.println("you are now Driving, Enjoy !");
		gas--;
		status();
	}

	public void Boosting() {
		if (gas >=3) {
		System.out.println("you are now Boosting, Enjoy !");
		gas = gas - 3;
		status();}
		else {System.out.println("You can't boosting" );
		status();}
	}

	public void Refueling () {
		if (gas <=8) {
		System.out.println("you are now Refueling , Enjoy !");
		gas = gas +2;
		status();}
		else {
			System.out.println("you can't refuel !");
			status();
		}
		
	}
}
