package gui.wizard;

import javax.swing.JButton;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.TransparentTextArea;

public class SecondPanel extends SequencePanel {

	private static final long serialVersionUID = 3167242679541518662L;

	public SecondPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new TransparentTextArea(textAreas.getString("firmware")));
		addButton(new JButton("dummy"));
	}

	@Override
	public SequencePanel getNextPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
