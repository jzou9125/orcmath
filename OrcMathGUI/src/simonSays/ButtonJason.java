package simonSays;

import java.awt.Color;

import guiTeacher.components.Button;

public class ButtonJason extends Button implements ButtonInterfaceJason{

	private Color color;

	public ButtonJason() {
		super(0, 0, 500, 500,"",null);
	}

	@Override
	public void setColor(Color black) {
		this.color = black;
		
	}

	@Override
	public MoveInterfaceJason addMove() {
		return null;
	}

	@Override
	public void highlight() {
		Button.setHighlightColor(color.brighter());
	}

	@Override
	public void dim() {
		Button.setHighlightColor(color.darker());
	}

}
