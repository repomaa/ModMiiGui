package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CommandLineArea extends JScrollPane {

	private static final long serialVersionUID = 2239419236779496797L;
	private JTextArea cmd;
	
	public CommandLineArea() {
		cmd = new JTextArea(15, 25);
		cmd.setBackground(Color.BLACK);
		cmd.setForeground(Color.WHITE);
		cmd.setFont(new Font(Font.MONOSPACED, Font.PLAIN, cmd.getFont().getSize()));
		setViewportView(cmd);
	}
	public void runCommand(String command) {
		cmd.setText("");
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(command);
			//StreamGobbler errorGobler = new StreamGobbler(this, process.getErrorStream(), "ERROR");
			StreamGobbler outputGobbler = new StreamGobbler(this, process.getInputStream());
			//errorGobler.start();
			outputGobbler.start();
		} catch (IOException e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			showLine(sw.toString());
		}
	}
	private class StreamGobbler extends Thread {
		InputStream in;
		CommandLineArea invoker;
		private StreamGobbler(CommandLineArea invoker, InputStream in) {
			this.in = in;
			this.invoker = invoker;
		}
		@Override
		public void run() {
			try {
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while((line = br.readLine()) != null) {
					invoker.showLine(line + "\n");
				}
			}
			catch (IOException e) {
				invoker.showLine(e.getStackTrace().toString());
			}
		}
	}
	public void showLine(String string) {
		cmd.append(string);
		cmd.setCaretPosition(cmd.getText().length());
	}
}
