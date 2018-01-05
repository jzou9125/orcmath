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
	private ProgressInterfaceJason si;
	private ButtonInterfaceJason[] buttons;
	private  ArrayList<MoveInterfaceJason> playerMoves = new ArrayList<MoveInterfaceJason>();
	private ArrayList<MoveInterfaceJason> sequence = new ArrayList<MoveInterfaceJason>;
	private int round = 0;
	private boolean playing = true;
	private int sequenceNum;
	private TextArea tRound;


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
		
		

	}

	private ButtonInterfaceJason getButton() {
		return null;
	}

	@Override
	public void run() {
		generateMoves();
		updateRounds(tRound);

	}

	private void updateRounds(TextArea text) {
		text.setText("Round: "+Integer.toString(round));

	}

	private void generateMoves() {
		for(int i = 0; i< sequenceNum; i++)
		{
			int randNum =(int) (Math.random()*4);
			sequence.add(buttons[randNum].addMove());
			ButtonInterfaceJason holder = buttons[randNum];
			buttons[randNum] = buttons[buttons.length -1];
			buttons[buttons.length-1] = holder;
		}
	}

}
