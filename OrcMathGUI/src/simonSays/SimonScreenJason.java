package simonSays;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenJason extends ClickableScreen implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1341680881667906578L;
	private  ArrayList<String> playerMoves = new ArrayList<String>();
	private ArrayList<String> sequence = new ArrayList<String>();
	private static Color[] color = {Color.black, Color.blue, Color.green, Color.red, Color.PINK};
	private String[] ai = {"black", "blue", "green", "red", "pink"};
	private Button[] buttons;
	private static int round = 0;
	private boolean playing = true;
	private int sequenceNum = 1;
	private TextArea text;


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
		Button[] buttons = new Button[5];
		for( int i = 0; i< buttons.length; i++)
		{
			buttons[i] = new Button((i*40)+10, 30, 30, 30, "", color[i], null);
		}
		buttons[0].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("black");
				System.out.print(" wow");

			}
		});
		buttons[1].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("blue");

			}
		});
		buttons[2].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("green");

			}
		});
		buttons[3].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("red");

			}
		});
		buttons[4].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("pink");

			}
		});
		for( int i = 0; i< buttons.length; i++)
		{
			viewObjects.add(buttons[i]);
		}
		this.buttons = buttons;

		TextArea progress = new TextArea(10, 100, 200, 200, "Progress");
		text = progress;
		text.setText("Rounds: "+ round + " Sequence: "+sequenceNum);

		viewObjects.add(progress);


	}

	@Override
	public void run() {
		setSequenceNum(sequenceNum + 4);
		generateMoves();
		setRound(round + 1);
		text.setText("Rounds: "+ round + " Sequence: "+sequenceNum);
		while(playing)
		{
			if(playerMoves.size() == sequenceNum)
			{
				checkMoves();
				playing = true;
				run();
			}
		}
	}
	private void checkMoves() {
		String[] playerM = (String[]) playerMoves.toArray();
		String[] seq = (String[]) sequence.toArray();
		for( int i =0; i< playerMoves.size(); i++)
		{
			if( !(playerM[i].equals(seq[i]) ) )
			{
				restart();
			}
		}
	}

	private void restart() {
		text.setText("Game Over");
		round = 0;
		sequenceNum = 1;
	}

	private void setSequenceNum(int i) {
		sequenceNum = i;
	}

	private void generateMoves() {
		for(int i = 0; i< sequenceNum; i++)
		{
			int randNum =(int) (Math.random()*4);
			sequence.add(ai[randNum]);
			String holder = ai[randNum];
			ai[randNum] = ai[buttons.length -1];
			ai[buttons.length-1] = holder;
		}
	}

}
