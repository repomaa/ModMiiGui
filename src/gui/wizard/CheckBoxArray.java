package gui.wizard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CheckBoxArray extends JPanel {
	
	private static final long serialVersionUID = -8770705415444106741L;
	private JCheckBox[] checkBoxes;
	public CheckBoxArray(JCheckBox[] array) {
		checkBoxes = new JCheckBox[array.length + 1];
		final JCheckBox all = new JCheckBox();
		checkBoxes[0] = all;
		System.arraycopy(array, 0, checkBoxes, 1, array.length);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		all.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 1; i < checkBoxes.length; i++)
					checkBoxes[i].setSelected(all.isSelected());
			}
		});
		ActionListener others = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean b = true;
				for(int i = 1; i < checkBoxes.length; i++)
					b &= checkBoxes[i].isSelected(); 
				all.setSelected(b);
			}
		};
		add(all);
		for(int i = 1; i < checkBoxes.length; i++) {
			add(checkBoxes[i]);
			checkBoxes[i].addActionListener(others);
		}
	}
}
