


public class isDone  {

	private Agent agent;

	
	
	
	public isDone(Agent agent) {
		this.agent = agent;
	}


	public boolean isGoalState(EnvironmentState state) {
		// setup
		String currentLocation = state.getAgentLocation(this.agent);
		String adjacentLocation = (currentLocation
				.equals(Environment.LOCATION_A)) ? Environment.LOCATION_B
				: Environment.LOCATION_A;
		// Test if both of the locations are clean
		if (Environment.LocationState.Clean != state
				.getLocationState(currentLocation)) {
			return false;
		} else if (Environment.LocationState.Clean != state
				.getLocationState(adjacentLocation)) {
			return false;
		} else {
			return true;
		}
	}
}