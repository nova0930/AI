import java.util.Random;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import aima.core.agent.EnvironmentView;





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
	
	
	protected void updateEnvironmentRepresentation(Agent agent, Actions action,
			EnvironmentState state) {
		for (EnvironmentRepresentation view : views) {
			view.agentActed(agent, action, state);
		}
	}
	
	 void addAgent(VacumAgent a)
	 {
		 
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
