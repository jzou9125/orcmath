package simonSays;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;

public class ProgressJason extends Component implements ProgressInterfaceJason{

	private TextLabel text;
	private int rounds = 0;
	private int sequence = 4;

	public ProgressJason(int x, int y, int w, int h) {
		super(x, y, w, h);
		text = new TextArea(x, y, w, h, "");
	}

	@Override
	public void gameover() {
		text.setText("Game Over!");
	}

	@Override
	public void setRound(int round) {
		this.rounds = round;
	}

	@Override
	public void setSequenceSize(int size) {
		this.sequence = size;
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		g.drawString(text.getText(), getX(), getY());
	}

	@Override
	public void displayProgress()
	{
		text.setText("Round: " + rounds + " Sequence: "+ sequence);
		update();
	}

	@Override
	public void setText(String string) {
		text.setText(string);
		update();
	}
}
