import java.util.LinkedHashMap;
import java.util.Map;
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
	
	public Map<Agent, Double> scoreMeasure = new LinkedHashMap<Agent, Double>();
	
	public EnvironmentState envState = null;
	
	public Environment() {
		Random r = new Random();
		envState = new EnvironmentState(
				0 == r.nextInt(2) ? LocationState.Clean : LocationState.Dirty,
				0 == r.nextInt(2) ? LocationState.Clean : LocationState.Dirty);
	}
	
	
	public EnvironmentState addAgent(Agent a, String location) {
		envState.setAgentLocation(a, location);
		System.out.println("Agent added to specific location.");
		return envState;
	}
	
	
	protected void updateScoreMeasure(Agent forAgent, double addTo) {
		scoreMeasure.put(forAgent, getScoreMeasure(forAgent)
				+ addTo);
	}
	
	public double getScoreMeasure(Agent forAgent) {
		Double pm = scoreMeasure.get(forAgent);
		if (null == pm) {
			pm = new Double(0);
			scoreMeasure.put(forAgent, pm);
		}

		return pm;
	}
	
	
	
	public PerceptFromOutside getPerceptSeenBy(Agent anAgent) {
	
		String agentLocation = envState.getAgentLocation(anAgent);
		return new PerceptFromOutside(agentLocation,
				envState.getLocationState(agentLocation));
	}
	
	//Add Agent randomly
	public void addAgent(Agent a) {
		int idx = new Random().nextInt(2);
		envState.setAgentLocation(a, idx == 0 ? LOCATION_A : LOCATION_B);
		System.out.println("Agent added randomly.");
	}
	
	public EnvironmentState executeAction(Agent a, Actions agentAction) {

		if (ACTION_MOVE_RIGHT == agentAction) {
			envState.setAgentLocation(a, LOCATION_B);
			//updateScoreMeasure(a, -1);
		} else if (ACTION_MOVE_LEFT == agentAction) {
			envState.setAgentLocation(a, LOCATION_A);
			//updatePerformanceMeasure(a, -1);
		} else if (ACTION_SUCK == agentAction) {
			if (LocationState.Dirty == envState.getLocationState(envState
					.getAgentLocation(a))) {
				envState.setLocationState(envState.getAgentLocation(a),
						LocationState.Clean);
				updateScoreMeasure(a, 10);
			}
		} else if (agentAction.isNoOp()) {
		//	isDone = true;
		}

		return envState;
	}
	
	 
	 void deleteAgent()
	 {
		 
	 }
	 
	 void setAgentLocation()
	 {
		 
	 }
	 
	 String getLocationState(String location)
	 {
		 return envState.getLocationState(location).toString();
	 }
	 
	 String getAgentLocation(Agent a)
	 {
		 return envState.getAgentLocation(a);
	 }
	 
}
