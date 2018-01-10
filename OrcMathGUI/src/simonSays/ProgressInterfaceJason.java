package simonSays;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceJason extends Visible {

	void gameover();

	void setRound(int round);
	
	void setSequenceSize(int size);
}
