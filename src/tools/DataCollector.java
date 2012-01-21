package tools;

import java.util.HashMap;

public abstract class DataCollector {
	private HashMap<String,Object> data;
	public DataCollector() {
		data = new HashMap<String,Object>();
	}
	/**
	 * Used to get the Arguments for ModMii based on the
	 * collected Data
	 * @return the Arguments
	 */
	public abstract String getArgs();
	public void digest(String key, Object data) {
		this.data.put(key, data);
	}
}
