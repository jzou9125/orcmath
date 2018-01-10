package simonSays;

public class MoveJason implements MoveInterfaceJason{
	
	private ButtonInterfaceJason b;
	
	public MoveJason(ButtonInterfaceJason b)
	{
		this.b = b;
	}

	@Override
	public ButtonInterfaceJason getButton() {
		return b;
	}

}
