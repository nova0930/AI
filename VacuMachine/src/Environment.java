import java.util.Random;





public class Environment {
	
	
	public static final Actions ACTION_MOVE_LEFT = new Actions("Left");
	public static final Actions ACTION_MOVE_RIGHT = new Actions("Right");
	public static final Actions ACTION_SUCK = new Actions("Suck");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	
	public enum LocationState {
		Clean, Dirty
	};
	
	public EnvironmentState envState = null;
	
	public Environment() {
		Random r = new Random();
		envState = new EnvironmentState(
				0 == r.nextInt(2) ? LocationState.Clean : LocationState.Dirty,
				0 == r.nextInt(2) ? LocationState.Clean : LocationState.Dirty);
	}
	
	
	public EnvironmentState addAgent(Agent a, String location) {
		// Ensure the agent state information is tracked before
		// adding to super, as super will notify the registered
		// EnvironmentViews that is was added.
		envState.setAgentLocation(a, location);
		System.out.println("Agent added.");
		return envState;
	}
	
	//Add Agent randomly
	public void addAgent(Agent a) {
		int idx = new Random().nextInt(2);
		envState.setAgentLocation(a, idx == 0 ? LOCATION_A : LOCATION_B);
		System.out.println("Agent added.");
	}
	
	
	
	 
	 void deleteAgent()
	 {
		 
	 }
	 
	 void setAgentLocation()
	 {
		 
	 }
	 
	 void getAgentLocation()
	 {
		 
	 }
	 
}
