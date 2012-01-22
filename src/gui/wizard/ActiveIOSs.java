package gui.wizard;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import gui.SequencePanel;
import gui.SwitchFrame;
import gui.TransparentTextArea;

public class ActiveIOSs extends SequencePanel {

	private JRadioButton yes;
	public ActiveIOSs(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new TransparentTextArea(textAreas.getString("dlActiveIOSs")));
		ButtonGroup yesNo = new ButtonGroup();
		yes = new JRadioButton(basicButtons.getString("yes"));
		JRadioButton no = new JRadioButton(basicButtons.getString("no"));
		yesNo.add(yes);
		yesNo.add(no);
		if(parent.<Integer>getData("firmware") == 0) {
			add(new TransparentTextArea(textAreas.getString("dlActiveIOSs4_3")));
			no.setSelected(true);
		}
		else {
			add(new TransparentTextArea(textAreas.getString("dlActiveIOSsOther")));
			yes.setSelected(true);
		}
		add(yes);
		add(no);
		JButton next = new JButton(basicButtons.getString("next"));
		addButton(next);
	}

	@Override
	public SequencePanel getNextPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
