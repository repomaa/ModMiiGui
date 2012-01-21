package gui.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.TransparentTextArea;

public class FirstPanel extends SequencePanel {
	
	private static final long serialVersionUID = -4396233122618654765L;

	public FirstPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new TransparentTextArea(textAreas.getString("firstTime")));
		ButtonGroup yesNo = new ButtonGroup();
		JRadioButton yes = new JRadioButton(basicButtons.getString("yes"));
		JRadioButton no = new JRadioButton(basicButtons.getString("no"));
		yesNo.add(yes);
		yesNo.add(no);
		yes.setSelected(true);
		add(yes);
		add(no);
		JButton next = new JButton(basicButtons.getString("next"));
		next.addActionListener(nextListener);
		addButton(next);
	}

	@Override
	public SequencePanel getNextPanel() {
		parent.feedCollector("firstTime", true);
		return new SecondPanel(this, parent);
	}

}
