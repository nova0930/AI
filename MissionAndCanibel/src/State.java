
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
		{System.out.println("The Boat is at A");
			
			int[]tempSA = this.getLocationState(Environment.SIDE_A).clone();
			int[] tempSB = this.getLocationState(Environment.SIDE_B).clone();
			
			
			
			//Move two missinaries from A to B
			int[]M2A = tempSA.clone();
			int[]M2B = tempSB.clone();
			
			M2A[0] = M2A[0]-2;
			M2B[0] = M2B[0]+2;
			M2A[2] = 0;
			M2B[2] = 1;
			
			this.setBoatLocation(a, Environment.SIDE_B);
			State tempM2A = new State(M2A, M2B);
			tempM2A.setBoatLocation(a, Environment.SIDE_B);
			//System.out.println("CHild"+Arrays.toString(new State(M2A, M2B).getLocationState(Environment.SIDE_B)));
			testAdd(successors, tempM2A); // Two missionaries cross left to right.
			
			
			
			
			int[]M1A = tempSA.clone();
			int[]M1B = tempSB.clone();
			
			M1A[0] = M1A[0]-1;
			M1B[0] = M1B[0]+1;
			M1A[2] = 0;
			M1B[2] = 1;
			this.setBoatLocation(a, Environment.SIDE_B);
			State tempM1A = new State(M1A, M1B);
			tempM1A.setBoatLocation(a, Environment.SIDE_B);
			//System.out.println("CHild"+Arrays.toString(new State(M1A, M1B).getLocationState(Environment.SIDE_B)));
			testAdd(successors, tempM1A);
			
			
			int[]M1_C1_A = tempSA.clone();
			int[]M1_C1_B = tempSB.clone();
			
			M1_C1_A[0] = M1_C1_A[0]-1;
			M1_C1_B[0] = M1_C1_B[0]+1;
			M1_C1_A[1] = M1_C1_A[1]-1;
			M1_C1_B[1] = M1_C1_B[1]+1;
			M1_C1_A[2] = 0;
			M1_C1_B[2] = 1;
			this.setBoatLocation(a, Environment.SIDE_B);
			State tempM1C1A = new State(M1_C1_A, M1_C1_B);
			tempM1C1A.setBoatLocation(a, Environment.SIDE_B);
			testAdd(successors, tempM1C1A);
			
			int[]C1A = tempSA.clone();
			int[]C1B = tempSB.clone();
			
			
			C1A[1] = C1A[1]-1;
			C1B[1] = C1B[1]+1;
			C1A[2] = 0;
			C1B[2] = 1;
			this.setBoatLocation(a, Environment.SIDE_B);
			State tempC1A = new State(C1A, C1B);
			tempC1A.setBoatLocation(a, Environment.SIDE_B);
			testAdd(successors, tempC1A);
			
			
			
			
			int[]C2A = tempSA.clone();
			int[]C2B = tempSB.clone();
			C2A[1] = C2A[1]-2;
			C2B[1] = C2B[1]+2;
			C2A[2] = 0;
			C2B[2] = 1;
			
			this.setBoatLocation(a, Environment.SIDE_B);
			State tempC2A = new State(C2A, C2B);
			tempC2A.setBoatLocation(a, Environment.SIDE_B);
			//System.out.println("CHild"+Arrays.toString(new State(M1A, M1B).getLocationState(Environment.SIDE_B)));
			testAdd(successors, tempC2A);
		}
		
		
		else if(this.getBoatLocation(a) == "B")
		{
			System.out.println();
			System.out.println();
			
			
			
			System.out.println("The Boat is at B");
			int[] tempSA = this.getLocationState(Environment.SIDE_A);
			int[] tempSB = this.getLocationState(Environment.SIDE_B);
			
			//Move two missinaries from A to B
			int[]M2A = tempSA.clone();
			int[]M2B = tempSB.clone();
			
			M2A[0] = M2A[0]-2;
			M2B[0] = M2B[0]+2;
			M2A[2] = 0;
			M2B[2] = 1;
			this.setBoatLocation(a, Environment.SIDE_A);
			State tempM2B = new State(M2A, M2B);
			tempM2B.setBoatLocation(a, Environment.SIDE_A);
			testAdd(successors, tempM2B); // Two missionaries cross left to right.
			
			int[]M1A = tempSA.clone();
			int[]M1B = tempSB.clone();
			
			M1A[0] = M1A[0]-1;
			M1B[0] = M1B[0]+1;
			M1A[2] = 0;
			M1B[2] = 1;
			this.setBoatLocation(a, Environment.SIDE_A);
			State tempM1B = new State(M1A, M1B);
			tempM1B.setBoatLocation(a, Environment.SIDE_A);
			testAdd(successors, tempM1B);
			
			
			int[]M1_C1_A = tempSA.clone();
			int[]M1_C1_B = tempSB.clone();
			
			M1_C1_A[0] = M1_C1_A[0]-1;
			M1_C1_B[0] = M1_C1_B[0]+1;
			M1_C1_A[1] = M1_C1_A[1]-1;
			M1_C1_B[1] = M1_C1_B[1]+1;
			M1_C1_A[2] = 0;
			M1_C1_B[2] = 1;
			this.setBoatLocation(a, Environment.SIDE_A);
			State tempM1C1B = new State(M1_C1_A, M1_C1_B);
			tempM1C1B.setBoatLocation(a, Environment.SIDE_A);
			testAdd(successors, tempM1C1B);
			
			int[]C1A = tempSA.clone();
			int[]C1B = tempSB.clone();
			
			
			C1A[1] = C1A[1]-1;
			C1B[1] = C1B[1]+1;
			C1A[2] = 0;
			C1B[2] = 1;
			this.setBoatLocation(a, Environment.SIDE_A);
			State tempC1B = new State(C1A, C1B);
			tempM1B.setBoatLocation(a, Environment.SIDE_A);
			testAdd(successors, tempC1B);
			
			int[]C2A = tempSA.clone();
			int[]C2B = tempSB.clone();
			
			
			
			C2A[1] = C2A[1]-2;
			C2B[1] = C2B[1]+2;
			C2A[2] = 0;
			C2B[2] = 1;
			
			this.setBoatLocation(a, Environment.SIDE_A);
			State tempC2B = new State(C2A, C2B);
			tempC2B.setBoatLocation(a, Environment.SIDE_A);
			testAdd(successors, tempC2B);
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
		if(
				(((this.getLocationState(Environment.SIDE_A)[1]-this.getLocationState(Environment.SIDE_A)[0])>0) && this.getLocationState(Environment.SIDE_A)[0]>0)
				| 
				(((this.getLocationState(Environment.SIDE_B)[1]-this.getLocationState(Environment.SIDE_B)[0])>0)  && this.getLocationState(Environment.SIDE_B)[0]>0)
				)
		
		
			return true;
		else if ((this.getLocationState(Environment.SIDE_A)[1])<0 | (this.getLocationState(Environment.SIDE_A)[0])<0 |(this.getLocationState(Environment.SIDE_B)[0])<0 |(this.getLocationState(Environment.SIDE_B)[1])<0)
		    return true;
		
		
		//System.out.println("Not Violate");
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
	         System.out.println("THe Same");
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
			System.out.println("Child State "+ Arrays.toString(stateIter.next().getLocationState(Environment.SIDE_A))+Arrays.toString(stateIter.next().getLocationState(Environment.SIDE_B)));
			
		}
		
		return this.childState;
	}
	
	
	public void testAdd(List<State> successors, State newState) {
		
		if (!newState.checkViolate()) {
			newState.parentState = this;
			successors.add(newState);
			System.out.println("Successors "+Arrays.toString(newState.getLocationState(Environment.SIDE_A))+Arrays.toString(newState.getLocationState(Environment.SIDE_B)));
			System.out.println();
			
		}
	}

	public boolean isGoal() {
			
			 int[] B= new int[]{3,3,1};
			 int[] A= new int[]{0,0,0};
			// setup
		//	State goalState = (State) state;
			// test goal state
			 
			if( compare(this.getLocationState(Environment.SIDE_A), A) && compare(this.getLocationState(Environment.SIDE_B), B))
			return true;  
			
			
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

	


}
