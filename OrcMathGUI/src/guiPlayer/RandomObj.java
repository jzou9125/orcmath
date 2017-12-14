package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class RandomObj extends Component {

	public RandomObj() {
		super(40, 40, 100, 100);
		update();
	}

	@Override
	public void update(Graphics2D g) { //abstract method 
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
