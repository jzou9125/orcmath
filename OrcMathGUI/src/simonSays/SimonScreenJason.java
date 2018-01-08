package simonSays;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import guiTeacher.components.Button;
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
	private ArrayList<MoveInterfaceJason> sequence = new ArrayList<MoveInterfaceJason>();
	private static int round = 0;
	private boolean playing = true;
	private int sequenceNum;
	private TextArea tRound;
	private Button button;


	public static int getRound() {
		return round;
	}

	public static void setRound(int round) {
		SimonScreenJason.round = round;
	}

	public SimonScreenJason(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		/*buttons = new ButtonInterfaceJason[5];
		for( int i = 0; i< buttons.length; i++)
		{
			buttons[i] = getButton();
			buttons[i].setColor(Color.black);
			viewObjects.add(buttons[i]);
		}*/
		for(int i = 0; i < 5; i++) {
			Button button = new Button(0 + i * 50, 0, 50, 50, "hi", null);
			viewObjects.add(button);
		}
		

	}

	private ButtonInterfaceJason getButton() {
		ButtonJason button = new ButtonJason();
		return button;
	}

	@Override
	public void run() {
		generateMoves();
		updateRounds(tRound);

		getButton().highlight();
		try {
		Thread.sleep(800);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		getButton().dim();
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
