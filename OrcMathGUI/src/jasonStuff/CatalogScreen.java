package jasonStuff;

import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField quote;
	private TextField date;
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		quote = new TextField(40,40,200,30, "Text goes here.", "Quotes");
		viewObjects.add(quote);
		
		date = new TextField(280,40,200,30, "Date goes here.", "Date");
		viewObjects.add(date);
	}

	
}
