package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tools.DataCollector;

public abstract class SwitchFrame extends JFrame {
	
	private static final long serialVersionUID = -4311063486017120215L;
	private DataCollector collector;
	private SequencePanel currentPanel;
	
	public SwitchFrame(String title, DataCollector collector) {
		super(title);
		this.collector = collector;
	}
	public void feedCollector(String key, Object data) {
		collector.digest(key, data);
	}
	@SuppressWarnings("unchecked")
	public <T> T getData(String key) {
		return (T)collector.get(key);
	}
	public void setPanel(SequencePanel panel) {
		if(currentPanel != null)
			remove(currentPanel);
		validate();
		add(panel);
		currentPanel = panel;
		pack();
	}
}
