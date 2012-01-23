package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 * Abstract subclass of JPanel stores the "last" panel and handles
 * the basic structure of moving to the "next" panel. This allows proper
 * "Back" and "Next" behavior.
 * @author Joakim Reinert
 *
 */
public abstract class SequencePanel extends JPanel {
	
	private static final long serialVersionUID = -7985908778341030189L;
	protected SequencePanel last;
	protected SwitchFrame parent;
	protected ResourceBundle basicButtons = MainWindow.basicButtons;
	protected ResourceBundle textAreas = MainWindow.textAreas;
	protected ResourceBundle menuItems = MainWindow.menuItems;
	protected ResourceBundle messages = MainWindow.messages;
	protected ResourceBundle tooltips = MainWindow.tooltips;
	protected ResourceBundle labels = MainWindow.labels;
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
	 * Adds the default Next button. It will point to the SequencePanel
	 * defined in getNextPanel
	 */
	protected void addNextButton() {
		JButton next = new JButton(basicButtons.getString("next"));
		next.addActionListener(nextListener);
		addButton(next);
	}
	/**
	 * Adds a custom button to the button row at the bottom of the panel.
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
	/**
	 * Sets the alignment of all components within the given component recursively
	 * @param comp - the component to start from
	 * @param alignmentX - the desired x alignment
	 */
	private void align(Component comp, float alignmentX) {
		if(comp instanceof Container)
			for(Component current : ((Container)comp).getComponents())
				align(current, alignmentX);
		if(comp instanceof JComponent)
			((JComponent)comp).setAlignmentX(alignmentX);
	}
	/**
	 * Returns the next panel (which will become visible, when next is pressed)
	 * @return - the next panel
	 */
	public abstract SequencePanel getNextPanel();
	
	/**
	 * Used to open up web pages included in the sources such as help pages, etc.
	 * @param resource - the name of the web page located in resources.
	 * @throws URISyntaxException - if something goes wrong
	 */
	protected void browse(String resource) throws URISyntaxException {
		URI uri = getClass().getResource("/resources/" + resource).toURI();
		if(Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			if(desktop.isSupported(Desktop.Action.BROWSE)) {
				try {
					desktop.browse(uri);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return;
			}
		}
		JOptionPane.showMessageDialog(SequencePanel.this, messages.getString("error"), messages.getString("noBrowseSupport") + uri.toString(), JOptionPane.ERROR_MESSAGE);
	}
	/**
	 * Adds a "yes" "no" radio button pair.
	 * @param yesNo - the button pair to be added
	 */
	public void add(YesNo yesNo) {
		add(yesNo.yes);
		add(yesNo.no);
	}
	/**
	 * A radio button pair with the buttons labeled as "yes" and "no" in the
	 * respective language. The buttons are added to a ButtonGroup so that only
	 * one or the other can be selected at a time.
	 * @author Joakim Reinert
	 *
	 */
	protected class YesNo {
		public JRadioButton yes;
		public JRadioButton no;
		public YesNo() {
			ButtonGroup yesNo = new ButtonGroup();
			yes = new JRadioButton(basicButtons.getString("yes"));
			no = new JRadioButton(basicButtons.getString("no"));
			yesNo.add(yes);
			yesNo.add(no);
		}
		/**
		 * Returns whether yes is selected or not
		 * @return - true if yes is selected, false otherwise
		 */
		public boolean isYes() {
			return yes.isSelected();
		}
		/**
		 * Sets yes or no as selected (depending on the given boolean)
		 * @param b - if true, yes is selected (and no deselected), if false
		 * it's the other way around
		 */
		public void setYes(boolean b) {
			yes.setSelected(b);
			no.setSelected(!b);
		}
	}
}
