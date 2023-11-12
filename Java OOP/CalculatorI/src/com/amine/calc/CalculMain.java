package com.amine.calc;

public class CalculMain {

	public static void main(String[] args) {
		calcul Casio = new calcul();
		Casio.setNum1(22.5);
		Casio.setOperator('+');
		Casio.setNum2(17.3);
		Casio.performOperation();
		Casio.getResults();

	}

}
