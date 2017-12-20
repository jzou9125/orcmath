package jasonStuff;

import java.util.List;

import guiPlayer.CatalogMaker;
import guiPlayer.DonaldTrumpQuotes;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	private TextField quote;
	private TextField date;
	private Button add;
	private CatalogMaker catalog;
	private TextArea textarea;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		catalog = new CatalogMaker();
		quote = new TextField(40,40,200,30, "Text goes here.", "Quotes");
		viewObjects.add(quote);
		
		date = new TextField(280,40,200,30, "Date goes here.", "Date");
		viewObjects.add(date);
		
		add = new Button(280, 80,60, 50, "Submit", new Action() {
			
			@Override
			public void act() {
				addButtonClick();
				
			}
		});
		viewObjects.add(add);
		
		textarea = new TextArea(550,40,100,100,"Box of text");
		viewObjects.add(textarea);
	}

	protected void addButtonClick() {
		String[] input = new String[2];
		input[0] = quote.getText();
		input[1] = date.getText();
		DonaldTrumpQuotes text = new DonaldTrumpQuotes(input);
		
		
		textarea.setText(textarea.getText()+" "+text+"\n");
		 catalog.addBook(text);
		 
		 quote.setText("");
		 date.setText("");
	}

	
}
