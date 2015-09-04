import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class Actions {

	
	
	public static final String action = "action";
	Set<Actions> actions = new HashSet<Actions>();

	//
	private Map<Object, Object> attributes = new LinkedHashMap<Object, Object>();
	
	public Actions(String name) {
		
		attributes.put(action, name);
	}



	public String getAction(Object key) {
		
		return (String) attributes.get(key);
	}


	
	
	public boolean isNoOp() {
		return false;
	}
	

	
	void setAction(String name)
	{
		attributes.put(action, name);
		
	}
	
	
	
	
	boolean isIdle()
	{
		return false;
		
	}
	
	public Set<Actions> possibleActions(Object s) {
		
		actions.add(Environment.ACTION_SUCK);
		actions.add(Environment.ACTION_MOVE_LEFT);
		actions.add(Environment.ACTION_MOVE_RIGHT);
		return actions;
		
	}
	
}
