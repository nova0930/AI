


public class testGoal {
	
	private Boat agent;

	public testGoal(Boat agent) {
		this.agent = agent;
	}

	public boolean isGoalState(Object state) {
		
		 int[] B= new int[]{3,3,1};
		 int[] A= new int[]{0,0,0};
		// setup
		State goalState = (State) state;
		String currentLocation = goalState.getBoatLocation(this.agent);
		
		// test goal state
		if ((goalState.getLocationState(Environment.SIDE_A).equals(A)) && (goalState.getLocationState(Environment.SIDE_B).equals(B))) {
        	return true;
		}  
		
		
			return false;
		
	

}
}