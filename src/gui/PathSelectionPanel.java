package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PathSelectionPanel extends SequencePanel {

	private static final long serialVersionUID = 7252968160310515431L;
	private PathSelector sd;
	private PathSelector usb;
	
	public PathSelectionPanel(SequencePanel last, final SwitchFrame parent) {
		super(last, parent);
		if(parent.needsSD()) {
			sd = new PathSelector("sdPath");
			add(sd);
		}
		if(parent.needsUSB()) {
			usb = new PathSelector("usbPath");
			add(usb);
		}
		addNextButton();
	}

	@Override
	protected String getInfo() {
		return null;
	}

	@Override
	protected String getTitle() {
		return "pathSelect";
	}

	@Override
	public SequencePanel getNextPanel() {
		if(sd != null)
			parent.feedCollector("sdPath", sd.getPath());
		if(usb != null)
			parent.feedCollector("usbPath", usb.getPath());
		return new ConfirmationPanel(this, parent);
	}
	private class PathSelector extends JPanel {

		private static final long serialVersionUID = 628382782875154241L;
		private JTextField pathField;
		
		private PathSelector(String sdOrUSB) {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			JLabel label = new JLabel(labels.getString(sdOrUSB));
			add(label);
			int strutLength = 150 - label.getPreferredSize().width;
			add(Box.createHorizontalStrut(strutLength));
			pathField = new JTextField();
			String tempPath = new File("").getAbsolutePath();
			tempPath += File.separator;
			tempPath += labels.getString("cpTo" + sdOrUSB);
			pathField.setEditable(false);
			pathField.setText(tempPath);
			JButton browse = new JButton(basicButtons.getString("browse"));
			browse.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser(pathField.getText());
					fc.setApproveButtonText(basicButtons.getString("select"));
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int i = fc.showOpenDialog(PathSelectionPanel.this);
					if(i == JFileChooser.APPROVE_OPTION)
						pathField.setText(fc.getSelectedFile().getAbsolutePath());
				}
			});
			add(pathField);
			add(browse);
		}
		private String getPath() {
			return pathField.getText();
		}
	}
	
}
