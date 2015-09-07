import java.util.Random;



public class Agent {
	
	
	private boolean alive = true;
	
	boolean isAlive()
	{
		return alive;
	}

	
	void setAlive(boolean live)
	{
		alive = live;
	}
	
	public Actions execute(PerceptFromOutside percept) {
		PerceptFromOutside vep = (PerceptFromOutside) percept;

		// if status = Dirty then return Suck
		if (Environment.LocationState.Dirty == vep.getLocationState()) {
			
			System.out.println("Suck");
			return Environment.ACTION_SUCK;
			// else if location = A then return Right
		} else if (Environment.LOCATION_A == vep.getAgentLocation()) {
			System.out.println("Move Right");
			return Environment.ACTION_MOVE_RIGHT;
		} else if (Environment.LOCATION_B == vep.getAgentLocation()) {
			// else if location = B then return Left
			System.out.println("Move Left");
			return Environment.ACTION_MOVE_LEFT;
		}

		// Note: This should not be returned if the
		// environment is correct
		return NoAction.NO_OP;
	}
	
	
}
