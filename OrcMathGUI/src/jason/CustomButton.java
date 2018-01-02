package jason;

import java.awt.Color;
import java.awt.Graphics2D;

import guiPlayer.CustomLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button implements CustomLabel{

	public CustomButton(int x, int y) {
		super(x, y, 100, 100, "Save", new Action() {
			
			@Override
			public void act() {
				
			}
		});
		
		
		
	}

	@Override
	public void drawButton(Graphics2D g, boolean hover) {
		super.drawButton(g, hover);
		g.setColor(Color.BLACK);
		
	}
	
	@Override
	public void updateString1(String string) {
		
	}

	@Override
	public void updateString2(String string) {
		
	}

	@Override
	public void setIconColor(Color color) {
		// TODO Auto-generated method stub
		
	}
	
}
