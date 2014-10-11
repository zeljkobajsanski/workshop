package com.lowagie.text.rtf.field;

import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.DocWriter;
import com.lowagie.text.Font;
import com.lowagie.text.rtf.document.RtfDocument;

public class RtfFilename extends RtfField {

	/**
	 * Constant for the Filename field in RTF
	 */
	private static final byte[] FILENAME = DocWriter.getISOBytes("FILENAME");

	/**
	 * Constructs a RtfFilename. This can be added anywhere to add a filename
	 * field.
	 */
	public RtfFilename() {
		super(null);
	}

	/**
	 * Constructs a RtfFilename with a specified Font. This can be added
	 * anywhere to add a filename field.
	 * 
	 * @param font
	 */
	public RtfFilename(Font font) {
		super(null, font);
	}

	/**
	 * Constructs a RtfFilename object.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfPFilename belongs to
	 */
	public RtfFilename(RtfDocument doc) {
		super(doc);

	}

	/**
	 * Constructs a RtfFilename object with a specific font.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfFilename belongs to
	 * @param font
	 *            The Font to use
	 */
	public RtfFilename(RtfDocument doc, Font font) {
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
		result.write(FILENAME);
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
