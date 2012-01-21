package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tools.DataCollector;

public abstract class SwitchFrame extends JFrame {
	
	private static final long serialVersionUID = -4311063486017120215L;
	private DataCollector collector;
	
	public SwitchFrame(String title, DataCollector collector) {
		super(title);
		this.collector = collector;
	}
	public void feedCollector(String key, Object data) {
		collector.digest(key, data);
	}
	public void setPanel(JPanel panel) {
		int index = 0;
		for(index = 0; index < getComponentCount(); index++)
			if(getComponent(index) instanceof JPanel) {
				remove(getComponent(index));
				break;
			}
		add(panel, index - 1);
		pack();
	}
}
