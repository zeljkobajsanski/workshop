package com.lowagie.text.rtf.field;

import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.DocWriter;
import com.lowagie.text.Font;
import com.lowagie.text.rtf.document.RtfDocument;

public class RtfTitle extends RtfField {

	/**
	 * Constant for the Title field in RTF
	 */
	private static final byte[] TITLE = DocWriter.getISOBytes("TITLE");

	/**
	 * Constructs a RtfTitle. This can be added anywhere to add a title field.
	 */
	public RtfTitle() {
		super(null);

	}

	/**
	 * Constructs a RtfTitle with a specified Font. This can be added anywhere
	 * to add a title field.
	 * 
	 * @param font
	 */
	public RtfTitle(Font font) {
		super(null, font);

	}

	/**
	 * Constructs a RtfTitle object.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfTitle belongs to
	 */
	public RtfTitle(RtfDocument doc) {
		super(doc);

	}

	/**
	 * Constructs a RtfTitle object with a specific font.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfTitle belongs to
	 * @param font
	 *            The Font to use
	 */
	public RtfTitle(RtfDocument doc, Font font) {
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
		result.write(TITLE);
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

	}

}
