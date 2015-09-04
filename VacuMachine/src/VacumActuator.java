import java.util.HashSet;
import java.util.Set;


public class VacumActuator {
	
	public static final Set<Actions> Actions;

	Set<Actions> actions = new HashSet<Actions>();
			actions.add(VacuumEnvironment.ACTION_SUCK);
			actions.add(VacuumEnvironment.ACTION_MOVE_LEFT);
			actions.add(VacuumEnvironment.ACTION_MOVE_RIGHT);
	
	
	
	

}
