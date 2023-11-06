package com.amine.zoo;

public class Bat extends Mammal {

	public void fly() {
		batEnergyLevel -= 50;
		System.out.println("the sound of a bat taking off" + batEnergyLevel);
	}

	public void eatHumans() {
		batEnergyLevel += 25;
		System.out.println("so- well, never mind" + batEnergyLevel);
	}

	public void attackTown() {
		batEnergyLevel -= 100;
		System.out.println("the sound of a town on fire" + batEnergyLevel);
	}
}
