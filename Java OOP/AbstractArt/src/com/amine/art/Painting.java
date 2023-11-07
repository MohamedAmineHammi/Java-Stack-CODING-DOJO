package com.amine.art;

public class Painting extends Art {
	private String paintType;

	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}


	@Override
	public void viewArt() {
System.out.println("Display Informations:"  +  "Title: " + this.getTitle() +" Author: " + this.getAuthor() + "Description: " + this.getDescription()  + "Paint Type: " + paintType);

	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

}
