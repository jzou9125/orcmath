package simonSays;

import guiTeacher.GUIApplication;

public class SimonGameJason extends GUIApplication {
	

	private static SimonScreenJason screen;
	private static SimonGameJason game;

	public SimonGameJason(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenJason screen = new SimonScreenJason(getWidth(), getHeight());
		setScreen(screen);

	}
	
	public static void main(String[] args) {
		game = new SimonGameJason(850,500);
		Thread runner = new Thread(game);
		runner.start();
	}
}
