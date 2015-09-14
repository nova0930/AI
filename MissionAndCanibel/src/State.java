
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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
	public State parentState = null;
	public List<State> childState = new ArrayList<State>();
	public int[] anArray= new int[3];

	
	public State() {
		state = new LinkedHashMap<String, int[]>();
		boatLocations = new LinkedHashMap<Boat, String>();
	}

	public State(int[] sideAState,int[] sideBState) {
		this();
		state.put(Environment.SIDE_A, sideAState);
		state.put(Environment.SIDE_B, sideBState);
	}


	public List<State> generateSuc(Boat a)
	{
		List<State> successors = new ArrayList<State>();
		
		if(this.getBoatLocation(a) == "A")
		{
			testAdd(successors, new State(
					this.getLocationState(Environment.SIDE_A), this.getLocationState(Environment.SIDE_B))
			); // Two missionaries cross left to right.
			
			
			
			testAndAdd(successors, new State(cannibalLeft - 2, missionaryLeft, Position.RIGHT,
					cannibalRight + 2, missionaryRight)); // Two cannibals cross left to right.
			testAndAdd(successors, new State(cannibalLeft - 1, missionaryLeft - 1, Position.RIGHT,
					cannibalRight + 1, missionaryRight + 1)); // One missionary and one cannibal cross left to right.
			testAndAdd(successors, new State(cannibalLeft, missionaryLeft - 1, Position.RIGHT,
					cannibalRight, missionaryRight + 1)); // One missionary crosses left to right.
			testAndAdd(successors, new State(cannibalLeft - 1, missionaryLeft, Position.RIGHT,
					cannibalRight + 1, missionaryRight)); // One cannibal crosses left to right.
		}
		
		return successors;
	}
	
	
	public String getBoatLocation(Boat a) {
		return boatLocations.get(a);
	}

	
	public void setBoatLocation(Boat a, String location) {
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
		else if ((getLocationState(Environment.SIDE_A)[1])<0 || (getLocationState(Environment.SIDE_A)[0])<0 ||(getLocationState(Environment.SIDE_B)[0])<0|| (getLocationState(Environment.SIDE_B)[1])<0)
		    return true;
		
		
		return false;
	}
	
	
	public boolean isGoalState(Object state) {
		
		
		State goalState = (State) state;
		 int[] B= new int[]{3,3,1};
		 int[] A= new int[]{0,0,0};
		 

	     
	     
	     int[] arrA = goalState.getLocationState(Environment.SIDE_A);
	     int[] arrB = goalState.getLocationState(Environment.SIDE_B);
	     
	     
	     if(compare(arrA,A) && compare(arrB,B))
	    
	     {
	      
	         System.out.println("Same");
	         return true;
	     }
	     
	     else{
		//System.out.println("Not Same" + Arrays.toString(goalState.getLocationState(Environment.SIDE_A)));
			return false;
	     }
}

	public boolean compare(int[] arrA, int[] a) {
		
		   boolean b = true;
	         if (arrA != null && a != null){
	           if (arrA.length != a.length)
	               b = false;
	           else
	               for (int i = 0; i < a.length; i++) {
	                   if (arrA[i] != a[i]) {
	                       b = false;    
	                   }                 
	             }
	         }else{
	           b = false;
	         }
		// TODO Auto-generated method stub
		return b;
	}
	
	public State getParentState()
	{
		
		return parentState;
	}
	
	
	public List<State> getChildState()
	{
		
		Iterator<State> stateIter = this.childState.iterator();
		
		while(stateIter.hasNext())
		{
			System.out.println("Child State "+Arrays.toString(stateIter.next().getLocationState(Environment.SIDE_A)));
			//System.out.println("Parent State "+ stateIter.next().getLocationState(Environment.SIDE_B));
		}
		
		return this.childState;
	}
	
	
	public void testAdd(List<State> successors, State newState) {
		if (!newState.checkViolate()) {
			newState.parentState = this;
			successors.add(newState);
		}
	}

	public boolean isGoal() {
			
			 int[] B= new int[]{3,3,1};
			 int[] A= new int[]{0,0,0};
			// setup
		//	State goalState = (State) state;
			// test goal state
			if ((this.getLocationState(Environment.SIDE_A).equals(A)) && (this.getLocationState(Environment.SIDE_B).equals(B))) {
	        	return true;
			}  
			
			
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
