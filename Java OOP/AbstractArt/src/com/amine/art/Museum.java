package com.amine.art;

public class Museum {

	public static void main(String[] args) {
		Painting Amine = new Painting("Monalisa", "Benzima", "armando", "Maradona");
		Painting Med = new Painting("aaaaa", "bbbbbb", "ccccccccc", "ddddddd");
		Painting Salah = new Painting("eeeeee", "ffffffff", "gggggggg", "hhhhhhhh");
		Sculpture Rami = new Sculpture("iiiiiiii", "jjjjjjjj", "kkkkkkk", "rrrr");
		Sculpture Eya = new Sculpture("llllll", "mmmmmmmm", "nnnnnnnnn", "ffffff");

		Amine.viewArt();
		Med.viewArt();
		Salah.viewArt();
		Rami.viewArt();
		Eya.viewArt();

	}

}
