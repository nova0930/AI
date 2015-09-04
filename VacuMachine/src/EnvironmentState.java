import java.util.LinkedHashMap;
import java.util.Map;




public class EnvironmentState {
	
	int size;      // Can be measured by steps of the agent
	String Shape;
	
	private Map<String, Environment.LocationState> locationState;
	private Map<Agent, String> agentLocations;
	
	
	
	
	
	
	public EnvironmentState() {
		locationState = new LinkedHashMap<String, Environment.LocationState>();
		agentLocations = new LinkedHashMap<Agent, String>();
	}
	
	public EnvironmentState(Environment.LocationState locAState,
			Environment.LocationState locBState) {
		// TODO Auto-generated constructor stub
		this();
		locationState.put(Environment.LOCATION_A, locAState);
		locationState.put(Environment.LOCATION_B, locBState);
	}
	
	public String getAgentLocation(Agent a) {
		return agentLocations.get(a);
	}

	
	public void setAgentLocation(Agent a, String location) {
		agentLocations.put(a, location);
	}
	
	public Environment.LocationState getLocationState(String location) {
		return locationState.get(location);
	}
	
	public void setLocationState(String location,Environment.LocationState s) {
		locationState.put(location, s);
	}
	
	
	public boolean equals(Object o) {
		if (o instanceof EnvironmentState) {
			EnvironmentState s = (EnvironmentState) o;
			if (this.locationState.equals(s.locationState)
					&& this.agentLocations.equals(s.agentLocations)) {
				return true;
			}
		}
		return false;
	}



}
