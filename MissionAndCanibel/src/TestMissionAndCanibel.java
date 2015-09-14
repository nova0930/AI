import java.util.ArrayList;
import java.util.List;

public class TestMissionAndCanibel {

	public static void main(String[] args) {
	
		Environment env = new Environment();
	//	State tempState = null;
		Boat a = null;
		a = new Boat();
		
		env.addBoat(a, Environment.SIDE_A);
		System.out.println("The agent's current location "+ env.getBoatLocation(a));
		
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		State solution = bfs.exec(env.envState);
		printSolution(solution);
			
		

	}

	
	private static void printSolution(State solution) {
		if (null == solution) {
			System.out.print("\nNo solution found.");
		} else {
			System.out.println("\nSolution (cannibalLeft,missionaryLeft,boat,cannibalRight,missionaryRight): ");
			List<State> path = new ArrayList<State>();
			State state = solution;
			while(null!=state) {
				path.add(state);
				state = state.getParentState();
			}

			int depth = path.size() - 1;
			for (int i = depth; i >= 0; i--) {
				state = path.get(i);
				if (state.isGoal()) {
					System.out.print(state.toString());
				} else {
					System.out.print(state.toString() + " -> ");
				}
			}
			System.out.println("\nDepth: " + depth);
		}
	}
}



