package simonSays;

import guiTeacher.GUIApplication;

public class SimonGameJason extends GUIApplication{

	public static SimonScreenJason screen;
	public SimonGameJason(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		SimonGameJason game = new SimonGameJason(800, 800);
		Thread s = new Thread();
		s.start();
	}

	@Override
	public void initScreen() {
		screen = new SimonScreenJason(getWidth(), getHeight());
		setScreen(screen);
	}

}
