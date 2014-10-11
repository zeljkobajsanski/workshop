package com.lowagie.text.rtf.field;

import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.DocWriter;
import com.lowagie.text.Font;
import com.lowagie.text.rtf.document.RtfDocument;

public class RtfAuthor extends RtfField {

	/**
	 * Constant for the Filename field in RTF
	 */
	private static final byte[] AUTHOR = DocWriter.getISOBytes("AUTHOR");

	/**
	 * Constructs a RtfAuthor. This can be added anywhere to add a author field.
	 */
	public RtfAuthor() {
		super(null);

	}

	/**
	 * Constructs a RtfAuthor with a specified Font. This can be added anywhere
	 * to add a autor field.
	 * 
	 * @param font
	 */
	public RtfAuthor(Font font) {
		super(null, font);

	}

	/**
	 * Constructs a RtfAuthor object.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfAuthor belongs to
	 */
	public RtfAuthor(RtfDocument doc) {
		super(doc);

	}

	/**
	 * Constructs a RtfAuthor object with a specific font.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfAuthor belongs to
	 * @param font
	 *            The Font to use
	 */
	public RtfAuthor(RtfDocument doc, Font font) {
		super(doc, font);

	}

	/**
	 * Writes the field instruction content
	 * 
	 * @param result
	 *            The <code>OutputStream</code> to write to.
	 * @throws IOException
	 *             on i/o errors.
	 */
	protected void writeFieldInstContent(OutputStream result)
			throws IOException {
		result.write(AUTHOR);

	}

	/**
	 * Writes the field result content
	 * 
	 * @param result
	 *            The <code>OutputStream</code> to write to.
	 * @throws IOException
	 *             on i/o errors.
	 */
	protected void writeFieldResultContent(OutputStream result)
			throws IOException {
		// TODO Auto-generated method stub

	}

}
