

public class NoAction extends Actions {

	public static final NoAction NO_OP = new NoAction();

	//
	// START-Action
	public boolean isNoOp() {
		return true;
	}

	// END-Action
	//

	private NoAction() {
		super("NoOp");
	}
}