package gui;

import gui.wizard.WizardWindow;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 2740437090361841747L;
	public static ResourceBundle menuItems;
	public static ResourceBundle textAreas;
	public static ResourceBundle basicButtons;
	
	/**
	 * Initialize and draw the MainWindow
	 */
	public MainWindow() {
		super("ModMiiGui");
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		menuItems = ResourceBundle.getBundle("resources.lang.MenuItems");
		textAreas = ResourceBundle.getBundle("resources.lang.TextAreas");
		basicButtons = ResourceBundle.getBundle("resources.lang.BasicButtons");
		for(JButton button : getMenuButtons())
			panel.add(button);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	/**
	 * Creates the main menu buttons
	 * @return the buttons
	 */
	public JButton[] getMenuButtons() {
		final JButton wizard = new JButton(menuItems.getString("wizard"));
		final JButton usb = new JButton(menuItems.getString("usb"));
		final JButton hack = new JButton(menuItems.getString("hack"));
		JButton sysCheck = new JButton(menuItems.getString("sysCheck"));
		final JButton regChange = new JButton(menuItems.getString("regChange"));
		final JButton sneek = new JButton(menuItems.getString("sneek"));
		final JButton downloads = new JButton(menuItems.getString("downloads"));
		final JButton conf = new JButton(menuItems.getString("conf"));
		final JButton fileCleanup = new JButton(menuItems.getString("fileCleanup"));
		JButton[] buttons = new JButton[] {wizard, usb, hack, sysCheck, regChange, sneek, downloads, conf, fileCleanup};
		ActionListener menuListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton)e.getSource();
				if(source.equals(wizard))
					openWizard();
				if(source.equals(usb))
					openUSB();
				if(source.equals(hack))
					openHack();
				if(source.equals(regChange))
					openRegChange();
				if(source.equals(sneek))
					openSneek();
				if(source.equals(downloads))
					openDownloads();
				if(source.equals(conf))
					openConf();
				if(source.equals(fileCleanup))
					openFileCleanup();
			}
		};
		int maxWidth = 0;
		for(JButton current : buttons) {
			if(current.getPreferredSize().width > maxWidth)
				maxWidth = current.getPreferredSize().width;
			current.addActionListener(menuListener);
		}
		for(JButton current : buttons)
			current.setMaximumSize(new Dimension(maxWidth, current.getPreferredSize().height));
		return buttons;
	}
	/**
	 * Open up the wizard window
	 */
	protected void openWizard() {
		WizardWindow wizard = new WizardWindow();
	}
	protected void openUSB() {
		// TODO Auto-generated method stub
		
	}
	protected void openHack() {
		// TODO Auto-generated method stub
		
	}
	protected void openRegChange() {
		// TODO Auto-generated method stub
		
	}
	protected void openSneek() {
		// TODO Auto-generated method stub
		
	}
	protected void openDownloads() {
		// TODO Auto-generated method stub
		
	}
	protected void openConf() {
		// TODO Auto-generated method stub
		
	}
	protected void openFileCleanup() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		MainWindow mw = new MainWindow();
	}
}
