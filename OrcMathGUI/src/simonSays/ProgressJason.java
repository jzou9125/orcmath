package simonSays;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;

public class ProgressJason extends Component implements ProgressInterfaceJason{

	
	public ProgressJason(){
		super(0, 0, 0, 0);
	}

	@Override
	public void changeRound() {
		SimonScreenJason.setRound(SimonScreenJason.getRound() + 1);
		update();
	}

	@Override
	public void changeSequence() {
		//SimonScreenJason.
		update();
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	

}
