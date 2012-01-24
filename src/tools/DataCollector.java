package tools;

import java.util.LinkedHashMap;

/**
 * Collects and handles data from user inputs
 * @author Joakim Reinert
 *
 */
public abstract class DataCollector {
	protected LinkedHashMap<String,String> data;
	private String mode;
	private String args;
	/**
	 * Creates a new DataCollector and initializes the data map
	 */
	public DataCollector() {
		data = new LinkedHashMap<String,String>();
	}
	/**
	 * Used to get the Arguments for ModMii based on the
	 * collected Data
	 * @return the Arguments
	 */
	public String getCmd() {
		return "ModMii.exe " + getMode() + " " + args;
	}
	/**
	 * Used to feed the collector with data
	 * @param key - the key for the data
	 * @param data - the data
	 */
	public abstract void digest(String key, String data);
	/**
	 * Returns the data for a given key
	 * @param key - the key for the data
	 * @return the data
	 */
	public String get(String key) {
		return data.get(key);
	}
	/**
	 * Returns a summary of the data that was collected
	 * @return the summary
	 */
	@Override
	public abstract String toString();
	
	/**
	 * Sets the mode of the collector (e.g. W for wizard, U for USB, etc.)
	 * @param mode - the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * Returns the current mode of the collector
	 * @return - the current mode
	 */
	protected String getMode() {
		return mode;
	}
	/**
	 * Used to set the command line argument string
	 * @param args - the arguments
	 */
	protected void setArgs(String args) {
		this.args = args;
	}
	public boolean needsSD() {
		return true;
	}
	public boolean needsUSB() {
		for(String value : data.values())
			if(value.contains("USB") || value.contains("usb"))
				return true;
		return false;
	}
}
