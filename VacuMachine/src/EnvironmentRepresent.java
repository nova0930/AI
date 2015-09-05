

public class EnvironmentRepresent {
	
	public void agentActed(Agent agent, Actions action,
			EnvironmentState resultingState) {
		System.out.println("Agent acted: " + action.toString());
	}

	
	public void agentAdded(Agent agent, EnvironmentState resultingState) {
		System.out.println("Agent added.");
	}
	
	public void notify(String msg) {
		System.out.println("Message: " + msg);
	}
}