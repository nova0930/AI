import java.util.List;


interface Problem {
	
	State getInitialState();
	boolean isGoalState(State s);
	List<Action> getActions(State s);
	State getSucessor(State s, Action a);
	
	
	

}
