import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class BreadthFirstSearch {

	public State exec(State initialState, Boat a) {
		if (initialState.isGoal()) {
			return initialState;
		}
		Queue<State> frontier = new LinkedList<State>();	// FIFO queue
		Set<State> explored = new HashSet<State>();
		
		System.out.println("Initial State"+Arrays.toString(initialState.getLocationState(Environment.SIDE_A)));
		System.out.println("Initial State"+Arrays.toString(initialState.getLocationState(Environment.SIDE_B)));
		frontier.add(initialState);
		
	
		
		while (!frontier.isEmpty()) {
			
			
			
			State state = frontier.poll();
			explored.add(state);
			
			
		//	System.out.println(" Test Boat Location "+state.getBoatLocation(a));
		//	System.out.println(" BFS "+Arrays.toString(state.getLocationState(Environment.SIDE_B)));
			
			List<State> successors = state.generateSuc(a);
			
			for (State child : successors) {
				
				System.out.println("CHild in BFS"+Arrays.toString(child.getLocationState(Environment.SIDE_A))+ Arrays.toString(child.getLocationState(Environment.SIDE_B)));
				
			
				if (child.isGoal()) {
					System.out.println("This is the end");
					return child;
				}
				
				
				
				frontier.offer(child);
				System.out.println("Added");
				System.out.println(frontier.isEmpty());
				
				//if (!explored.contains(child) || !frontier.contains(child)) 
				//{
					//if (child.isGoal()) {
						//return child;
				//	}
					
					//frontier.offer(child);
					//System.out.println("Added");
					//System.out.println(frontier.isEmpty());
				//}

			}
			
		}
		
		System.out.println("No elements");
		System.out.println(frontier.isEmpty());
		return null;

	}
}