package com.amine.art;

public class Sculpture extends Art {
	private String material;

	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
		// TODO Auto-generated constructor stub
	}

	@Override
		public void viewArt() {
		System.out.println("Display Informations:"  +  "Title: " + this.getTitle() +" Author: " + this.getAuthor() + "Description: " + this.getDescription()  + "Material: " + material);

				

	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
