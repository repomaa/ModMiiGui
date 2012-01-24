package gui.sneek;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import gui.MainWindow;
import gui.TransparentTextArea;
import gui.sneek.sneekInstall.SneekWizard;
import gui.sneek.sneekNand.SneekNandWizard;

public class SneekWindow extends MainWindow {

	private static final long serialVersionUID = -2459621145821722600L;
	private TransparentTextArea textArea;
	
	@Override
	protected void init() {
		setTitle("ModMiiGui - SNEEK options");
		textArea = new TransparentTextArea(textAreas.getString("sneek"));
	}
	@Override
	public JButton[] getMenuButtons() {
		final JButton install = new JButton(menuItems.getString("sneekInstall"));
		final JButton nandBuild = new JButton(menuItems.getString("nandBuild"));
		final JButton all = new JButton(menuItems.getString("sneekAll"));
		final JButton extractor = new JButton(menuItems.getString("extractor"));
		final JButton modify = new JButton(menuItems.getString("sneekModify"));
		extractor.setToolTipText(tooltips.getString("extractor"));
		modify.setToolTipText(tooltips.getString("sneekModify"));
		ActionListener menuListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton)e.getSource();
				if(source.equals(install))
					new SneekWizard();
				else if(source.equals(nandBuild))
					new SneekNandWizard();
			}
		};
		JButton[] buttons = new JButton[] {install, nandBuild, all, extractor, modify};
		resizeButtonsAndSetListener(buttons, menuListener);
		return buttons;
	}
	@Override
	protected Component getContentBeforeBtns() {
		return textArea;
	}
}
