package simonSays;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	public  ArrayList<String> playerMoves = new ArrayList<String>();
	public ArrayList<String> sequence = new ArrayList<String>();
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

		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Button[] buttons = new Button[5];
		for( int i = 0; i< buttons.length; i++)
		{
			buttons[i] = new Button((i*40)+10, 30, 30, 30, "", color[i], null);
		}
		Button blackButton = buttons[0];
		buttons[0].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("black");
				Thread light = new Thread(new Runnable() {

					@Override
					public void run() {
						blackButton.setBackgroundColor(blackButton.getBackgroundColor().darker());
						update();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						blackButton.setBackgroundColor(blackButton.getBackgroundColor().brighter());
						update();
					}
				});
				light.start();

				if(playerMoves.size() == sequenceNum)
				{
					checkMoves();
					playing = true;
					run();
				}

			}
		});
		Button blueButton = buttons[1];
		buttons[1].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("blue");
				Thread light = new Thread(new Runnable() {

					@Override
					public void run() {
						blueButton.setBackgroundColor(blackButton.getBackgroundColor().darker());
						update();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						blueButton.setBackgroundColor(blackButton.getBackgroundColor().brighter());
						update();
					}
				});
				light.start();
				if(playerMoves.size() == sequenceNum)
				{
					checkMoves();
					playing = true;
					run();
				}

			}
		});
		Button greenButton = buttons[2];
		buttons[2].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("green");
				Thread light = new Thread(new Runnable() {

					@Override
					public void run() {
						greenButton.setBackgroundColor(blackButton.getBackgroundColor().darker());
						update();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						greenButton.setBackgroundColor(blackButton.getBackgroundColor().brighter());
						update();
					}
				});
				light.start();
				if(playerMoves.size() == sequenceNum)
				{
					checkMoves();
					playing = true;
					run();
				}

			}
		});
		Button redButton = buttons[3];

		buttons[3].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("red");
				Thread light = new Thread(new Runnable() {

					@Override
					public void run() {
						redButton.setBackgroundColor(blackButton.getBackgroundColor().darker());
						update();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						redButton.setBackgroundColor(blackButton.getBackgroundColor().brighter());
						update();
					}
				});
				light.start();
				if(playerMoves.size() == sequenceNum)
				{
					checkMoves();
					playing = true;
					run();
				}

			}
		});
		Button pinkButton = buttons[4];
		buttons[4].setAction(new Action() {

			@Override
			public void act() {
				playerMoves.add("pink");
				Thread light = new Thread(new Runnable() {

					@Override
					public void run() {
						pinkButton.setBackgroundColor(Color.GRAY);
						update();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pinkButton.setBackgroundColor(Color.black);
						update();
					}
				});
				light.start();
				if(playerMoves.size() == sequenceNum)
				{
					checkMoves();
					playing = true;
					run();
				}

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
		try {
			generateMoves();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setRound(round + 1);
		text.setText("Rounds: "+ round + " Sequence: "+sequenceNum);
	}
	private void checkMoves() {
		if( !sequence.equals(playerMoves))
		{
			restart();
		}
		else
		{
			run();
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

	private void generateMoves() throws InterruptedException {
		for(int i = 0; i< sequenceNum; i++)
		{
			int randNum =(int) (Math.random()*4);
			sequence.add(ai[randNum]);
			String holder = ai[randNum];
			ai[randNum] = ai[buttons.length -1];
			ai[buttons.length-1] = holder;
			buttons[randNum].act();
		}
	}

}
