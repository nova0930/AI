
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Represents a state in the Vacuum World
 * 
 * @author Ciaran O'Reilly
 * @author Andrew Brown
 */
public class State  {

	private Map<String, int[]> state;
	private Map<Boat, String> boatLocations;
	public Set<State> parentState;
	public Set<State> childState;
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
	


	@Override
	public String toString() {
		return this.state.toString();
	}
	
	
	public boolean checkViolate()
	{
		
		
		
		if((getLocationState(Environment.SIDE_A)[1]-getLocationState(Environment.SIDE_A)[0]>0) || (getLocationState(Environment.SIDE_B)[1]-getLocationState(Environment.SIDE_B)[0]>0))
		
			return true;
		//else if ((getLocationState(Environment.SIDE_A)[1]-getLocationState(Environment.SIDE_A)[0]<=0) && (getLocationState(Environment.SIDE_B)[1]-getLocationState(Environment.SIDE_B)[0]<=0))
		  //  violate = false;
		
		
		return false;
	}
	
	//public State updateState(int[]sideA, int[]sideB)
	//{
		
		//setLocationState(Environment.SIDE_A,sideA);
		//setLocationState(Environment.SIDE_B,sideA);
	//}
	
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
	

}
