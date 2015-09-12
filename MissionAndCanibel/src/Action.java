import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Action {
	
	public static final String action = "action";
	Set<Action> actions = new HashSet<Action>();

	//
	private Map<Object, Object> attributes = new LinkedHashMap<Object, Object>();
	
	public Action(String name) {
		
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
	
	public Set<Action> possibleActions(Object s) {
		
		actions.add(Environment.M1_C1);
		actions.add(Environment.M2);
		actions.add(Environment.C2);
		actions.add(Environment.C1);
		actions.add(Environment.M1);
		return actions;
		
	}


	
	
}
