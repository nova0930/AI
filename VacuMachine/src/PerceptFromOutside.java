

public class PerceptFromOutside extends DynamicObjects{
	
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
	
	
	@Override
	public String describeType() {
		return PerceptFromOutside.class.getSimpleName();
	}

	/**
	 * Constructs a DynamicPercept with one attribute
	 * 
	 * @param key1
	 *            the attribute key
	 * @param value1
	 *            the attribute value
	 */
	public PerceptFromOutside(Object key1, Object value1) {
		setAttribute(key1, value1);
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(getAgentLocation());
		sb.append(", ");
		sb.append(getLocationState());
		sb.append("]");
		return sb.toString();
	}
}

