import aima.core.environment.vacuum.VacuumEnvironment;





public class PerceptFromOutside {
	
	public static final String ATTRIBUTE_AGENT_LOCATION = "agentLocation";
	public static final String ATTRIBUTE_STATE = "locationState";
	
	
	
	public PerceptFromOutside(String agentLocation,Environment.LocationState state) {
		setAttribute(ATTRIBUTE_AGENT_LOCATION, agentLocation);
		setAttribute(ATTRIBUTE_STATE, state);
	}

	/**
	 * Return the agent's perception of the current location, which is either A
	 * or B.
	 * 
	 * @return the agent's perception of the current location, which is either A
	 *         or B.
	 */
	public String getAgentLocation() {
		return (String) getAttribute(ATTRIBUTE_AGENT_LOCATION);
	}
	
	public Environment.LocationState getLocationState() {
		return (Environment.LocationState) getAttribute(ATTRIBUTE_STATE);
	}
	
	String getAgentLocation(Agent a)
	{
		return a.location;
	}
	Environment.LocationState getLocationState(String location)
	{
		return location.locationstate;
	}
}

