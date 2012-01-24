package gui;

import javax.swing.JFrame;

import tools.DataCollector;

/**
 * A abstract subclass of JFrame to display SequencePanels
 * @author Joakim Reinert
 * @see SequencePanel
 */
public abstract class SwitchFrame extends JFrame {
	
	private static final long serialVersionUID = -4311063486017120215L;
	private DataCollector collector;
	private SequencePanel currentPanel;
	
	/**
	 * Creates a new SwichFrame
	 * @param title - the title of the frame
	 * @param collector - the DataCollector to be used for this frame
	 * @see DataCollector
	 */
	public SwitchFrame(String title, DataCollector collector) {
		super(title);
		this.collector = collector;
	}
	/**
	 * Feeds the collector with the given data
	 * @param key - the key for the data
	 * @param data - the data
	 */
	public void feedCollector(String key, String data) {
		collector.digest(key, data);
	}
	/**
	 * Sets the mode of the collector (e.g. W for wizard, HS for HackMii solutions, etc.)
	 * @param mode - the mode to set
	 */
	protected void setCollectorMode(String mode) {
		collector.setMode(mode);
	}
	/**
	 * Returns the data from the collector for the given key
	 * @param key - the key to the data
	 * @return - the data
	 */
	public String getData(String key) {
		return collector.get(key);
	}
	/**
	 * Sets the panel to show inside the frame to the given one
	 * @param panel - the panel to show
	 */
	public void setPanel(SequencePanel panel) {
		if(currentPanel != null)
			remove(currentPanel);
		validate();
		add(panel);
		currentPanel = panel;
		pack();
	}
	/**
	 * Returns a string representation i.e a summary of the data
	 * collected by the DataCollector.
	 * @return - a summary of the collected data
	 */
	public String getData() {
		return collector.toString();
	}
	public boolean needsSD() {
		return collector.needsSD();
	}
	public boolean needsUSB() {
		return collector.needsUSB();
	}
	public String getCmd() {
		return collector.getCmd();
	}
	public void parseOptions() {
		collector.parseOptions();
	}
}
