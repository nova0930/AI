import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Environment {
	public static final String SIDE_A = "A";
	public static final String SIDE_B = "B";
	public static final Action M1_C1 = new Action("One_M_One_C");
	public static final Action M2 = new Action("Two_M");
	public static final Action C2 = new Action("Two_C");
	public static final Action C1 = new Action("One_C");
	public static final Action M1 = new Action("One_M");
	
	
	
	public int[] anArrayA= new int[]{3,3,1};
	public int[] anArrayB= new int[]{0,0,0};
	public Queue<State> stateQueue =  new LinkedList<State>();
	public Queue<State> solutionQueue = new LinkedList<State>();
	
	protected State envState = null;
	public State root = null;
//	public testGoal done = new testGoal(a);
	
	public Environment() {
		
		envState = new State(anArrayA, anArrayB);
		root = envState;
		stateQueue.add(envState);
	}
	
	

	public Environment(int[] locAState, int[] locBState) {
		envState = new State(locAState, locBState);
	}

	
	
	public State getCurrentState() {
		return envState;
	}
	

	public State addBoat(Boat a, String location) {
		envState.setBoatLocation(a, location);
		System.out.println("Agent added to specific location.");
		return envState;
	}
	 String getBoatLocation(Boat a)
	 {
		 return envState.getBoatLocation(a);
	 }
	
	
	
	
}
