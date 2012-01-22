package gui;

import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.text.Document;

public class TransparentTextArea extends JTextArea {
	
	private static final long serialVersionUID = -1964588762171601325L;

	public TransparentTextArea() {
		super();
		setOpaque(false);
		setEditable(false);
		setColumns(45);
		setLineWrap(true);
		setWrapStyleWord(true);
	}
	public TransparentTextArea(String text) {
		this();
		setText(text);
	}

	public TransparentTextArea(Document doc) {
		this();
		setDocument(doc);
	}

	public TransparentTextArea(int rows, int columns) {
		this();
		setRows(rows);
		setColumns(columns);
	}

	public TransparentTextArea(String text, int rows, int columns) {
		this(rows, columns);
		setText(text);
	}

	public TransparentTextArea(Document doc, String text, int rows, int columns) {
		super(text, rows, columns);
		setDocument(doc);
	}
	@Override
	public Dimension getPreferredSize() {
		Dimension dim = super.getPreferredSize();
		dim.setSize(dim.width, getLineCount() * getRowHeight());
		return dim;
	}

}
