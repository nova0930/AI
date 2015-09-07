import java.util.LinkedHashMap;
import java.util.Map;

public class DynamicObjects {
	
	private Map<Object, Object> attributes = new LinkedHashMap<Object, Object>();	
	public void setAttribute(Object key, Object value) {
		attributes.put(key, value);
	}


	public String describeType() {
		return getClass().getSimpleName();
	}
	
	public Object getAttribute(Object key) {
		return attributes.get(key);
	}
	
	public String describeAttributes() {
		StringBuilder sb = new StringBuilder();

		sb.append("[");
		boolean first = true;
		for (Object key : attributes.keySet()) {
			if (first) {
				first = false;
			} else {
				sb.append(", ");
			}

			sb.append(key);
			sb.append("==");
			sb.append(attributes.get(key));
		}
		sb.append("]");

		return sb.toString();
	}
}
