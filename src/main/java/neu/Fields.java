package neu;

import java.util.ArrayList;
import java.util.List;

/**
 * Demodaten ermöglichen
 */
public class Fields {
	public static final String NAME = "___fields";
	private final String itemVar;
	private final List<String> fields;
	private final List<String> orig;
	
	public Fields(String itemVar, String pFields) {
		this.itemVar = itemVar; 
		List<String> list = new ArrayList<>();
		for (String field : pFields.split(";")) {
			list.add(field);
		}
		orig = list; // ListUtils.unmodifiableList(list);
		if (orig.isEmpty()) {
			throw new IllegalArgumentException("fields must not be empty!");
		}
		fields = new ArrayList<>(orig.size());
	}
	
	public String pop() {
		if (fields.isEmpty()) {
			fields.addAll(orig); // reset
		}
		String ret = fields.get(0);
		//System.out.println(ret);
		fields.remove(0);
		if (ret.trim().isEmpty()) {
			return ret;
		}
		return "${" + itemVar + "." + ret + "}";
	}
}
