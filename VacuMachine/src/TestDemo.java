import java.util.Scanner;



public class TestDemo {

	public static void main(String[] args) {
	// In this example, we define that the performance measure will be the score that dirty objects are collected within
	//	certain steps


		Scanner input = new Scanner(System.in); //opens a scanner, keyboard
		System.out.print("How many times do you want this machine to execute? "); //prompt the user
		Integer testGoingOn = input.nextInt(); //store the input from the user	
		
		 //import the framework
		// create environment with random state of cleaning.
				Environment env = new Environment();
				//EnvironmentView view = new SimpleEnvironmentView();
				//env.addEnvironmentView(view);
				Agent a = null;
				a = new Agent();
while(testGoingOn>=0)
{
		
		
		
		
		env.addAgent(a);
		System.out.println("The agent's current location "+ env.getAgentLocation(a));
		
		System.out.println("Location A State: "+env.getLocationState(env.LOCATION_A));
		System.out.println("Location B State: "+env.getLocationState(env.LOCATION_B));
		
		// The agent can only see the location information which it is reside on.
	    // PerceptFromOutside temp = env.getPerceptSeenBy(a);
		System.out.println(env.getPerceptSeenBy(a));
		
		//Action excuted by the agent
		a.execute(env.getPerceptSeenBy(a));
		
		//Actions performed on the environment
		env.executeAction(a, a.execute(env.getPerceptSeenBy(a)));
		
		
		System.out.println("Location A State after execution: "+env.getLocationState(env.LOCATION_A));
		System.out.println("Location B State after execution: "+env.getLocationState(env.LOCATION_B));
		isDone done = new isDone(a);
		
		if(done.isGoalState(env.envState))
		{//System.out.println("The Work is Over");
			System.out.println();
			System.out.println();
			
		
		}
		else
		{
			System.out.println("Still needs more work");
		}
		
		testGoingOn--;
	}
		//env.step(16);
		//env.notifyViews("Performance=" + env.getPerformanceMeasure(a));

System.out.println("The total score after certain steps are : "+ env.getScoreMeasure(a));
	
//System.out.println("Come to the end! ");
	}

}



