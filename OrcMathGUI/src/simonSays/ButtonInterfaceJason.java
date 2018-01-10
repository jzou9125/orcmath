package simonSays;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceJason extends Clickable {
	
	void setAction(Action a);

	void highlight();

	void dim();

	void setColor(Color color);

}
