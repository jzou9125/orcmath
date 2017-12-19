package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;

public class DonaldTrumpQuotes extends AnimatedComponent {

	
	private String[][] quotes; // String, Date
	
		
	public DonaldTrumpQuotes(String[][] s) {
		super(40, 40, 136, 130);
		this.quotes = s;
		
//		addSequence("resources/DonalTrump.png", 150, 0, 0, 100, 94, 6);
//		Thread Animation = new Thread(this);
//		Animation.start();
		update();
	}

	public String toString()
	{
		return "Quote"+","+ "Date";
		
	}
	@Override
	public void update(Graphics2D g) {
		//g.setColor(Color.CYAN);
		//g.fillRect(0, 0, getWidth(), getHeight());
//		super.update(g);
	}

	public String[][] getQuotes() {
		return quotes;
	}

}
