package com.lowagie.text.rtf.field;

import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.DocWriter;
import com.lowagie.text.Font;
import com.lowagie.text.rtf.document.RtfDocument;

public class RtfCompany extends RtfField {

	/**
	 * Constant for the Company field in RTF
	 */
	private static final byte[] COMPANY = DocWriter.getISOBytes("DOCPROPERTY \"Company\"");

	/**
	 * Constructs a RtfAuthor. This can be added anywhere to add a author field.
	 */
	public RtfCompany() {
		super(null);

	}

	/**
	 * Constructs a RtfCompany with a specified Font. This can be added anywhere
	 * to add a company field.
	 * 
	 * @param font
	 */
	public RtfCompany(Font font) {
		super(null, font);

	}

	/**
	 * Constructs a RtfCompany object.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfCompany belongs to
	 */
	public RtfCompany(RtfDocument doc) {
		super(doc);

	}

	/**
	 * Constructs a RtfCompany object with a specific font.
	 * 
	 * @param doc
	 *            The RtfDocument this RtfCompany belongs to
	 * @param font
	 *            The Font to use
	 */
	public RtfCompany(RtfDocument doc, Font font) {
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
		result.write(COMPANY);

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
