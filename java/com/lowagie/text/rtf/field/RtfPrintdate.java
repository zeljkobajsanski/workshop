package com.lowagie.text.rtf.field;

import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.DocWriter;
import com.lowagie.text.Font;
import com.lowagie.text.rtf.document.RtfDocument;

public class RtfPrintdate extends RtfField {

	/**
	 * Constant for the Printdate field in RTF
	 */
	private static final byte[] PRINTDATE = DocWriter.getISOBytes("PRINTDATE");

	/**
	 * Constructs a RtfPrintdate. This can be added anywhere to add a printdate
	 * field.
	 */
	public RtfPrintdate() {
		super(null);

	}

	/**
	 * Constructs a RtfPrintdate with a specified Font. This can be added
	 * anywhere to add a printdate field.
	 * 
	 * @param font
	 */
	public RtfPrintdate(Font font) {
		super(null, font);

	}

	/**
	 * Constructs a RtfPrintdate object.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfPrintdate belongs to
	 */
	public RtfPrintdate(RtfDocument doc) {
		super(doc);

	}

	/**
	 * Constructs a RtfPrintdate object with a specific font.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfPrintdate belongs to
	 * @param font
	 *            The Font to use
	 */
	public RtfPrintdate(RtfDocument doc, Font font) {
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
		result.write(PRINTDATE);

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
