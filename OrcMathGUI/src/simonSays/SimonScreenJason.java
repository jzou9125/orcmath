package simonSays;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJason extends ClickableScreen implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1341680881667906578L;
	public ProgressInterfaceJason si;
	private ButtonInterfaceJason[] buttons; 
	public  ArrayList<MoveInterfaceJason> avaiableMoves = new ArrayList<MoveInterfaceJason>();
	public  ArrayList<MoveInterfaceJason> playerMoves = new ArrayList<MoveInterfaceJason>();
	public int round = 0;
	public boolean playing = true;
	public TextArea sRound;
	
	
	public SimonScreenJason(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		buttons = new ButtonInterfaceJason[5];
		for( int i = 0; i< buttons.length; i++)
		{
			buttons[i] = getButton();
			buttons[i].setColor(Color.black);
		}
		sRound = new TextArea(10,40, 40, 40, "Round");
		viewObjects.add(sRound);

	}

	private ButtonInterfaceJason getButton() {
		return null;
	}

	@Override
	public void run() {
		generateMoves();
		updateRounds(sRound);
		
	}

	private void updateRounds(TextArea text) {
		text.setText("Round: "+Integer.toString(round));
		
	}

	private void generateMoves() {
		int randNum =(int) (Math.random()*4);
		for()
	}

}
