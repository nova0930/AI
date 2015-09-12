
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a state in the Vacuum World
 * 
 * @author Ciaran O'Reilly
 * @author Andrew Brown
 */
public class State  {

	private Map<String, int[]> state;
	private Map<Boat, String> boatLocations;
	public int[] anArray= new int[3];

	
	public State() {
		state = new LinkedHashMap<String, int[]>();
		boatLocations = new LinkedHashMap<Boat, String>();
	}

	public State(int[] sideAState,int[] sideBState) {
		this();
		state.put(Environment.SIDE_A, sideBState);
		state.put(Environment.SIDE_B, sideAState);
	}



	public String getBoatLocation(Boat a) {
		return boatLocations.get(a);
	}

	
	public void setAgentLocation(Boat a, String location) {
		boatLocations.put(a, location);
	}


	public int[] getLocationState(String location) {
		return state.get(location);
	}

	
	public void setLocationState(String location,int[] s) {
		state.put(location, s);
	}
/*
	@Override
	public boolean equals(Object o) {
		if (o instanceof State) {
			State s = (State) o;
			if (this.state.equals(s.state)
					&& this.getLocationState().equals(s.agentLocations)) {
				return true;
			}
		}
		return false;
	}
*/

	/**
	 * Returns a string representation of the environment
	 * 
	 * @return a string representation of the environment
	 */
	@Override
	public String toString() {
		return this.state.toString();
	}
}
