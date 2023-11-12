package com.amine.calc;

public class calcul {
	// Member Variables:
	private double results;
	private double num1;
	private double num2;
	private char operator;

	// Constructor:
	public calcul() {
	}

	// Methods:
	public void setNum1(double input) {
		this.num1 = input;
	}

	public void setNum2(double input) {
		this.num2 = input;
	}

	public void setOperator(char input) {
		this.operator = input;
	}

	public void performOperation() {
		if (this.operator == '+') {
			results = num1 + num2;
		}
		if (this.operator == '-') {
			results = num1 - num2;
		}
	}

	public void getResults() {
		System.out.println(results);

	}

}
