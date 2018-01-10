package simonSays;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;

public class ProgressJason extends Component implements ProgressInterfaceJason{

	private TextLabel text;
	private int rounds = 0;
	private int sequence = 4;
	private boolean lose;

	public ProgressJason(int x, int y, int w, int h) {
		super(x, y, w, h);
		lose = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameover() {
		lose = true;
		update();
	}

	@Override
	public void setRound(int round) {
		this.rounds = round;
		update();
	}

	@Override
	public void setSequenceSize(int size) {
		this.sequence = size;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		FontMetrics fm = g.getFontMetrics();	
		int fontSize = 15;
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		if(lose) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, 100, 100);
			g.setColor(Color.BLACK);
			g.drawString("Game Over!", 15, 50);
		}else {
			g.setColor(Color.blue);
			g.fillRect(0, 0, 100, 100);
			g.setColor(Color.BLACK);
			g.drawString("Round: " + rounds , 10, 30);
			g.drawString("Sequence: " + sequence , 10, 50);
		}
	}
}
