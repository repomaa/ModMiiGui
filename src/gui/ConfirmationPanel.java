package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 * A panel that shows the collected data and asks for confirmation.
 * Is shown before execution of ModMii
 * @author Joakim Reinert
 *
 */
public class ConfirmationPanel extends SequencePanel {

	private static final long serialVersionUID = 3690785804007617642L;
	
	public ConfirmationPanel(SequencePanel last, SwitchFrame parent) {
		super(last, parent);
		add(new Title(labels.getString("confirm")));
		add(Box.createVerticalStrut(30));
		add(new TransparentTextArea(parent.getData().toString()));
		JButton save = new JButton(menuItems.getString("saveForLater"));
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(new File("Wizard_Settings.bat").exists()) {
					int overWrite = JOptionPane.showConfirmDialog(ConfirmationPanel.this, messages.getString("saveForLater_exists"), messages.getString("warning"), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if(overWrite == JOptionPane.NO_OPTION)
						return;
				}
				//TODO save settings
			}
		});
		addButton(save);
		JButton confirm = new JButton(basicButtons.getString("confirm"));
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		addButton(confirm);
	}
	@Override
	public SequencePanel getNextPanel() {
		// TODO Auto-generated method stub
		return null;
	}

}
