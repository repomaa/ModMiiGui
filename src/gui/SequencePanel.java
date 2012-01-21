package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class SequencePanel extends JPanel {
	
	private static final long serialVersionUID = -7985908778341030189L;
	protected SequencePanel last;
	protected SwitchFrame parent;
	protected ResourceBundle basicButtons = MainWindow.basicButtons;
	protected ResourceBundle textAreas = MainWindow.textAreas;
	protected ResourceBundle menuItems = MainWindow.menuItems;
	protected ActionListener nextListener;
	private Box buttonBox;
	
	public SequencePanel(SequencePanel last, SwitchFrame parent) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.last = last;
		this.parent = parent;
		nextListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SequencePanel.this.parent.setPanel(getNextPanel());
			}
		};
	}
	/**
	 * Adds a custom button to the button row at the bottom of the panel.
	 * Should only be called once after all other components above have been added.
	 * @param button the rightmost custom button to be added
	 */
	public void addButton(JButton button) {
		if(buttonBox == null) {
			buttonBox = Box.createHorizontalBox();
			ActionListener backListener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					parent.setPanel(last);
				}
			};
			ActionListener mainMenuListener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					parent.dispose();
				}
			};
			JButton back = new JButton(basicButtons.getString("back"));
			back.addActionListener(backListener);
			if(last == null)
				back.setEnabled(false);
			JButton mainMenu = new JButton(basicButtons.getString("mainMenu"));
			mainMenu.addActionListener(mainMenuListener);
			buttonBox.add(mainMenu);
			buttonBox.add(back);
			buttonBox.add(Box.createHorizontalGlue());
			add(buttonBox);
		}
		buttonBox.add(button);
		align(this, LEFT_ALIGNMENT);
	}
	private void align(Component comp, float alignmentX) {
		if(comp instanceof Container)
			for(Component current : ((Container)comp).getComponents())
				align(current, alignmentX);
		if(comp instanceof JComponent)
			((JComponent)comp).setAlignmentX(alignmentX);
	}
	public abstract SequencePanel getNextPanel();
}
