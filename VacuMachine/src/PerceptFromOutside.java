import aima.core.agent.Agent;
import aima.core.agent.Percept;
import aima.core.environment.vacuum.VacuumEnvironment;




public class PerceptFromOutside {
	

	
	String getAgentLocation(Agent a)
	{
		return a.location;
	}
	Environment.LocationState getLocationState(String location)
	{
		return location.locationstate;
	}
}

