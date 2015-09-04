




public class Agent {
	
	
	public Actions execute(PerceptFromOutside percept)
	{
		if (null != program) {
			return program.execute(percept);
		}
		return NoOpAction.NO_OP;
	}

	boolean isAlive()
	{
		
	}

	
	void setAlive(boolean alive)
	{
		
	}
}
