package com.amine.zoo;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("The gorilla has thrown something !");
		energyLevel -= 5;
		displayEnergy();
	}

	public void eatBanas() {
		System.out.println("The gorilla's Satisfaction !");
		energyLevel += 10;
		displayEnergy();

	}

	public void climb() {
		System.out.println("the gorilla has climbed a tree !");
		energyLevel -= 10;
		displayEnergy();
	}
}
