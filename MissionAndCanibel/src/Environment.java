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
	public Queue<State> stateQueue;
	
	protected State envState = null;
	public State root = null;
	
	public Environment() {
		
		envState = new State(anArrayA, anArrayB);
		root = envState;
		stateQueue.add(root);
	}

	
	public State executeAction(Boat a, Action agentAction) {
		envState = stateQueue.poll();
		State tempState = null;

		if (M1_C1 == agentAction) {
			
			String tempLoc =envState.getBoatLocation(a); 
			if(tempLoc == "A")
			{
				envState.getLocationState(SIDE_A)[0] = envState.getLocationState(SIDE_A)[0]-1;
				envState.getLocationState(SIDE_A)[1] = envState.getLocationState(SIDE_A)[1]-1;
				envState.getLocationState(SIDE_A)[2] = 0;
				
				envState.getLocationState(SIDE_B)[0] = envState.getLocationState(SIDE_B)[0]+1;
				envState.getLocationState(SIDE_B)[1] = envState.getLocationState(SIDE_B)[1]+1;
				envState.getLocationState(SIDE_B)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_B);
			}
			else
			{
				envState.getLocationState(SIDE_B)[0] = envState.getLocationState(SIDE_B)[0]-1;
				envState.getLocationState(SIDE_B)[1] = envState.getLocationState(SIDE_B)[1]-1;
				envState.getLocationState(SIDE_B)[2] = 0;
				
				envState.getLocationState(SIDE_A)[0] = envState.getLocationState(SIDE_A)[0]+1;
				envState.getLocationState(SIDE_A)[1] = envState.getLocationState(SIDE_A)[1]+1;
				envState.getLocationState(SIDE_A)[2] = 1;
				
			envState.setAgentLocation(a, SIDE_A);
			}
			
			if(!envState.checkViolate())
			{
			    envState.setLocationState(Environment.SIDE_A, envState.getLocationState(SIDE_A));
			    envState.setLocationState(Environment.SIDE_B, envState.getLocationState(SIDE_B));
			    
			    envState.childState.add(tempState);
			}
		} 
		else if (M2 == agentAction) {
			String tempLoc =envState.getBoatLocation(a); 
			if(tempLoc == "A")
			{
				envState.getLocationState(SIDE_A)[0] = envState.getLocationState(SIDE_A)[0]-2;
				envState.getLocationState(SIDE_A)[2] = 0;
				
				envState.getLocationState(SIDE_B)[0] = envState.getLocationState(SIDE_B)[0]+2;
				envState.getLocationState(SIDE_B)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_B);
			}
			else
			{
				envState.getLocationState(SIDE_B)[0] = envState.getLocationState(SIDE_B)[0]-2;
				envState.getLocationState(SIDE_B)[2] = 0;
				
				envState.getLocationState(SIDE_A)[0] = envState.getLocationState(SIDE_A)[0]+2;
				envState.getLocationState(SIDE_A)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_A);
			    
			    if(!envState.checkViolate())
				{
				    envState.setLocationState(Environment.SIDE_A, envState.getLocationState(SIDE_A));
				    envState.setLocationState(Environment.SIDE_B, envState.getLocationState(SIDE_B));
				    envState.parentState.add(tempState);
				}
			}
		} 
		else if (C2 == agentAction) {
			String tempLoc =envState.getBoatLocation(a); 
			if(tempLoc == "A")
			{
				envState.getLocationState(SIDE_A)[1] = envState.getLocationState(SIDE_A)[0]-2;
				envState.getLocationState(SIDE_A)[2] = 0;
				
				envState.getLocationState(SIDE_B)[1] = envState.getLocationState(SIDE_B)[0]+2;
				envState.getLocationState(SIDE_B)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_B);
			}
			else
			{
				envState.getLocationState(SIDE_B)[1] = envState.getLocationState(SIDE_B)[0]-2;
				envState.getLocationState(SIDE_B)[2] = 0;
				
				envState.getLocationState(SIDE_A)[1] = envState.getLocationState(SIDE_A)[0]+2;
				envState.getLocationState(SIDE_A)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_A);
			    if(!envState.checkViolate())
				{
				    envState.setLocationState(Environment.SIDE_A, envState.getLocationState(SIDE_A));
				    envState.setLocationState(Environment.SIDE_B, envState.getLocationState(SIDE_B));
				    envState.parentState.add(tempState);
				}
			}
		} 
		else if (C1 == agentAction) {
			String tempLoc =envState.getBoatLocation(a); 
			if(tempLoc == "A")
			{
				envState.getLocationState(SIDE_A)[1] = envState.getLocationState(SIDE_A)[1]-1;
				envState.getLocationState(SIDE_A)[2] = 0;
				
				envState.getLocationState(SIDE_B)[1] = envState.getLocationState(SIDE_B)[1]+1;
				envState.getLocationState(SIDE_B)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_B);
			}
			else
			{
				envState.getLocationState(SIDE_B)[1] = envState.getLocationState(SIDE_B)[1]-1;
				envState.getLocationState(SIDE_B)[2] = 0;
				
				envState.getLocationState(SIDE_A)[1] = envState.getLocationState(SIDE_A)[0]+1;
				envState.getLocationState(SIDE_A)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_A);
			    if(!envState.checkViolate())
				{
				    envState.setLocationState(Environment.SIDE_A, envState.getLocationState(SIDE_A));
				    envState.setLocationState(Environment.SIDE_B, envState.getLocationState(SIDE_B));
				    envState.parentState.add(tempState);
				}
			}
		} 
		else if (M1 == agentAction) {
			String tempLoc =envState.getBoatLocation(a); 
			if(tempLoc == "A")
			{
				envState.getLocationState(SIDE_A)[0] = envState.getLocationState(SIDE_A)[0]-1;
				envState.getLocationState(SIDE_A)[2] = 0;
				
				envState.getLocationState(SIDE_B)[0] = envState.getLocationState(SIDE_B)[0]+1;
				envState.getLocationState(SIDE_B)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_B);
			}
			else
			{
				envState.getLocationState(SIDE_B)[0] = envState.getLocationState(SIDE_B)[0]-1;
				envState.getLocationState(SIDE_B)[2] = 0;
				
				envState.getLocationState(SIDE_A)[0] = envState.getLocationState(SIDE_A)[0]+1;
				envState.getLocationState(SIDE_A)[2] = 1;
				
			    envState.setAgentLocation(a, SIDE_A);
			    
			    if(!envState.checkViolate())
				{
				    envState.setLocationState(Environment.SIDE_A, envState.getLocationState(SIDE_A));
				    envState.setLocationState(Environment.SIDE_B, envState.getLocationState(SIDE_B));
				    envState.parentState.add(tempState);
				}
			}
		} 
		

		return envState;
	}
	public Environment(int[] locAState, int[] locBState) {
		envState = new State(locAState, locBState);
	}

	
	public State getCurrentState() {
		return envState;
	}
	
	
	
	
}
