package com.lowagie.text.rtf.document;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ElementListener;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPTable;

public class TestDocument extends Table {

	public TestDocument(int arg0, int arg1) throws BadElementException {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public TestDocument(Table arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public TestDocument(int arg0) throws BadElementException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCell(Cell arg0, int arg1, int arg2)
			throws BadElementException {
		// TODO Auto-generated method stub
		super.addCell(arg0, arg1, arg2);
	}

	@Override
	public void addCell(Cell arg0, Point arg1) throws BadElementException {
		// TODO Auto-generated method stub
		super.addCell(arg0, arg1);
	}

	@Override
	public void addCell(Cell arg0) {
		// TODO Auto-generated method stub
		super.addCell(arg0);
	}

	@Override
	public void addCell(Phrase arg0, Point arg1) throws BadElementException {
		// TODO Auto-generated method stub
		super.addCell(arg0, arg1);
	}

	@Override
	public void addCell(Phrase arg0) throws BadElementException {
		// TODO Auto-generated method stub
		super.addCell(arg0);
	}

	@Override
	public void addCell(String arg0, Point arg1) throws BadElementException {
		// TODO Auto-generated method stub
		super.addCell(arg0, arg1);
	}

	@Override
	public void addCell(String arg0) throws BadElementException {
		// TODO Auto-generated method stub
		super.addCell(arg0);
	}

	@Override
	public void addColumns(int arg0) {
		// TODO Auto-generated method stub
		super.addColumns(arg0);
	}

	@Override
	public void complete() {
		// TODO Auto-generated method stub
		super.complete();
	}

	@Override
	public PdfPTable createPdfPTable() throws BadElementException {
		// TODO Auto-generated method stub
		return super.createPdfPTable();
	}

	@Override
	public void deleteAllRows() {
		// TODO Auto-generated method stub
		super.deleteAllRows();
	}

	@Override
	public void deleteColumn(int arg0) throws BadElementException {
		// TODO Auto-generated method stub
		super.deleteColumn(arg0);
	}

	@Override
	public boolean deleteLastRow() {
		// TODO Auto-generated method stub
		return super.deleteLastRow();
	}

	@Override
	public boolean deleteRow(int arg0) {
		// TODO Auto-generated method stub
		return super.deleteRow(arg0);
	}

	@Override
	public int endHeaders() {
		// TODO Auto-generated method stub
		return super.endHeaders();
	}

	@Override
	public void flushContent() {
		// TODO Auto-generated method stub
		super.flushContent();
	}

	@Override
	public int getAlignment() {
		// TODO Auto-generated method stub
		return super.getAlignment();
	}

	@Override
	public ArrayList getChunks() {
		// TODO Auto-generated method stub
		return super.getChunks();
	}

	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return super.getColumns();
	}

	@Override
	public Cell getDefaultCell() {
		// TODO Auto-generated method stub
		return super.getDefaultCell();
	}

	@Override
	public Cell getDefaultLayout() {
		// TODO Auto-generated method stub
		return super.getDefaultLayout();
	}

	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return super.getDimension();
	}

	@Override
	public Object getElement(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return super.getElement(arg0, arg1);
	}

	@Override
	public int getLastHeaderRow() {
		// TODO Auto-generated method stub
		return super.getLastHeaderRow();
	}

	@Override
	public float getOffset() {
		// TODO Auto-generated method stub
		return super.getOffset();
	}

	@Override
	public float getPadding() {
		// TODO Auto-generated method stub
		return super.getPadding();
	}

	@Override
	public float[] getProportionalWidths() {
		// TODO Auto-generated method stub
		return super.getProportionalWidths();
	}

	@Override
	public float getSpacing() {
		// TODO Auto-generated method stub
		return super.getSpacing();
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	@Override
	public float[] getWidths(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return super.getWidths(arg0, arg1);
	}

	@Override
	public void insertTable(Table arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		super.insertTable(arg0, arg1, arg2);
	}

	@Override
	public void insertTable(Table arg0, Point arg1) {
		// TODO Auto-generated method stub
		super.insertTable(arg0, arg1);
	}

	@Override
	public void insertTable(Table arg0) {
		// TODO Auto-generated method stub
		super.insertTable(arg0);
	}

	@Override
	public boolean isCellsFitPage() {
		// TODO Auto-generated method stub
		return super.isCellsFitPage();
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return super.isComplete();
	}

	@Override
	public boolean isConvert2pdfptable() {
		// TODO Auto-generated method stub
		return super.isConvert2pdfptable();
	}

	@Override
	public boolean isLocked() {
		// TODO Auto-generated method stub
		return super.isLocked();
	}

	@Override
	public boolean isNestable() {
		// TODO Auto-generated method stub
		return super.isNestable();
	}

	@Override
	public boolean isNotAddedYet() {
		// TODO Auto-generated method stub
		return super.isNotAddedYet();
	}

	@Override
	public boolean isTableFitsPage() {
		// TODO Auto-generated method stub
		return super.isTableFitsPage();
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return super.iterator();
	}

	@Override
	public boolean process(ElementListener arg0) {
		// TODO Auto-generated method stub
		return super.process(arg0);
	}

	@Override
	public void setAlignment(int arg0) {
		// TODO Auto-generated method stub
		super.setAlignment(arg0);
	}

	@Override
	public void setAlignment(String arg0) {
		// TODO Auto-generated method stub
		super.setAlignment(arg0);
	}

	@Override
	public void setAutoFillEmptyCells(boolean arg0) {
		// TODO Auto-generated method stub
		super.setAutoFillEmptyCells(arg0);
	}

	@Override
	public void setCellsFitPage(boolean arg0) {
		// TODO Auto-generated method stub
		super.setCellsFitPage(arg0);
	}

	@Override
	public void setComplete(boolean arg0) {
		// TODO Auto-generated method stub
		super.setComplete(arg0);
	}

	@Override
	public void setConvert2pdfptable(boolean arg0) {
		// TODO Auto-generated method stub
		super.setConvert2pdfptable(arg0);
	}

	@Override
	public void setDefaultCell(Cell arg0) {
		// TODO Auto-generated method stub
		super.setDefaultCell(arg0);
	}

	@Override
	public void setDefaultLayout(Cell arg0) {
		// TODO Auto-generated method stub
		super.setDefaultLayout(arg0);
	}

	@Override
	public void setLastHeaderRow(int arg0) {
		// TODO Auto-generated method stub
		super.setLastHeaderRow(arg0);
	}

	@Override
	public void setLocked(boolean arg0) {
		// TODO Auto-generated method stub
		super.setLocked(arg0);
	}

	@Override
	public void setNotAddedYet(boolean arg0) {
		// TODO Auto-generated method stub
		super.setNotAddedYet(arg0);
	}

	@Override
	public void setOffset(float arg0) {
		// TODO Auto-generated method stub
		super.setOffset(arg0);
	}

	@Override
	public void setPadding(float arg0) {
		// TODO Auto-generated method stub
		super.setPadding(arg0);
	}

	@Override
	public void setSpacing(float arg0) {
		// TODO Auto-generated method stub
		super.setSpacing(arg0);
	}

	@Override
	public void setTableFitsPage(boolean arg0) {
		// TODO Auto-generated method stub
		super.setTableFitsPage(arg0);
	}

	@Override
	public void setWidth(float arg0) {
		// TODO Auto-generated method stub
		super.setWidth(arg0);
	}

	@Override
	public void setWidths(float[] arg0) throws BadElementException {
		// TODO Auto-generated method stub
		super.setWidths(arg0);
	}

	@Override
	public void setWidths(int[] arg0) throws DocumentException {
		// TODO Auto-generated method stub
		super.setWidths(arg0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}

	@Override
	public int type() {
		// TODO Auto-generated method stub
		return super.type();
	}

	@Override
	public void cloneNonPositionParameters(Rectangle arg0) {
		// TODO Auto-generated method stub
		super.cloneNonPositionParameters(arg0);
	}

	@Override
	public void disableBorderSide(int arg0) {
		// TODO Auto-generated method stub
		super.disableBorderSide(arg0);
	}

	@Override
	public void enableBorderSide(int arg0) {
		// TODO Auto-generated method stub
		super.enableBorderSide(arg0);
	}

	@Override
	public Color getBackgroundColor() {
		// TODO Auto-generated method stub
		return super.getBackgroundColor();
	}

	@Override
	public int getBorder() {
		// TODO Auto-generated method stub
		return super.getBorder();
	}

	@Override
	public Color getBorderColor() {
		// TODO Auto-generated method stub
		return super.getBorderColor();
	}

	@Override
	public Color getBorderColorBottom() {
		// TODO Auto-generated method stub
		return super.getBorderColorBottom();
	}

	@Override
	public Color getBorderColorLeft() {
		// TODO Auto-generated method stub
		return super.getBorderColorLeft();
	}

	@Override
	public Color getBorderColorRight() {
		// TODO Auto-generated method stub
		return super.getBorderColorRight();
	}

	@Override
	public Color getBorderColorTop() {
		// TODO Auto-generated method stub
		return super.getBorderColorTop();
	}

	@Override
	public float getBorderWidth() {
		// TODO Auto-generated method stub
		return super.getBorderWidth();
	}

	@Override
	public float getBorderWidthBottom() {
		// TODO Auto-generated method stub
		return super.getBorderWidthBottom();
	}

	@Override
	public float getBorderWidthLeft() {
		// TODO Auto-generated method stub
		return super.getBorderWidthLeft();
	}

	@Override
	public float getBorderWidthRight() {
		// TODO Auto-generated method stub
		return super.getBorderWidthRight();
	}

	@Override
	public float getBorderWidthTop() {
		// TODO Auto-generated method stub
		return super.getBorderWidthTop();
	}

	@Override
	public float getBottom() {
		// TODO Auto-generated method stub
		return super.getBottom();
	}

	@Override
	public float getBottom(float arg0) {
		// TODO Auto-generated method stub
		return super.getBottom(arg0);
	}

	@Override
	public float getGrayFill() {
		// TODO Auto-generated method stub
		return super.getGrayFill();
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public float getLeft() {
		// TODO Auto-generated method stub
		return super.getLeft();
	}

	@Override
	public float getLeft(float arg0) {
		// TODO Auto-generated method stub
		return super.getLeft(arg0);
	}

	@Override
	public float getRight() {
		// TODO Auto-generated method stub
		return super.getRight();
	}

	@Override
	public float getRight(float arg0) {
		// TODO Auto-generated method stub
		return super.getRight(arg0);
	}

	@Override
	public int getRotation() {
		// TODO Auto-generated method stub
		return super.getRotation();
	}

	@Override
	public float getTop() {
		// TODO Auto-generated method stub
		return super.getTop();
	}

	@Override
	public float getTop(float arg0) {
		// TODO Auto-generated method stub
		return super.getTop(arg0);
	}

	@Override
	public boolean hasBorder(int arg0) {
		// TODO Auto-generated method stub
		return super.hasBorder(arg0);
	}

	@Override
	public boolean hasBorders() {
		// TODO Auto-generated method stub
		return super.hasBorders();
	}

	@Override
	public boolean isContent() {
		// TODO Auto-generated method stub
		return super.isContent();
	}

	@Override
	public boolean isUseVariableBorders() {
		// TODO Auto-generated method stub
		return super.isUseVariableBorders();
	}

	@Override
	public void normalize() {
		// TODO Auto-generated method stub
		super.normalize();
	}

	@Override
	public Rectangle rectangle(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return super.rectangle(arg0, arg1);
	}

	@Override
	public Rectangle rotate() {
		// TODO Auto-generated method stub
		return super.rotate();
	}

	@Override
	public void setBackgroundColor(Color arg0) {
		// TODO Auto-generated method stub
		super.setBackgroundColor(arg0);
	}

	@Override
	public void setBorder(int arg0) {
		// TODO Auto-generated method stub
		super.setBorder(arg0);
	}

	@Override
	public void setBorderColor(Color arg0) {
		// TODO Auto-generated method stub
		super.setBorderColor(arg0);
	}

	@Override
	public void setBorderColorBottom(Color arg0) {
		// TODO Auto-generated method stub
		super.setBorderColorBottom(arg0);
	}

	@Override
	public void setBorderColorLeft(Color arg0) {
		// TODO Auto-generated method stub
		super.setBorderColorLeft(arg0);
	}

	@Override
	public void setBorderColorRight(Color arg0) {
		// TODO Auto-generated method stub
		super.setBorderColorRight(arg0);
	}

	@Override
	public void setBorderColorTop(Color arg0) {
		// TODO Auto-generated method stub
		super.setBorderColorTop(arg0);
	}

	@Override
	public void setBorderWidth(float arg0) {
		// TODO Auto-generated method stub
		super.setBorderWidth(arg0);
	}

	@Override
	public void setBorderWidthBottom(float arg0) {
		// TODO Auto-generated method stub
		super.setBorderWidthBottom(arg0);
	}

	@Override
	public void setBorderWidthLeft(float arg0) {
		// TODO Auto-generated method stub
		super.setBorderWidthLeft(arg0);
	}

	@Override
	public void setBorderWidthRight(float arg0) {
		// TODO Auto-generated method stub
		super.setBorderWidthRight(arg0);
	}

	@Override
	public void setBorderWidthTop(float arg0) {
		// TODO Auto-generated method stub
		super.setBorderWidthTop(arg0);
	}

	@Override
	public void setBottom(float arg0) {
		// TODO Auto-generated method stub
		super.setBottom(arg0);
	}

	@Override
	public void setGrayFill(float arg0) {
		// TODO Auto-generated method stub
		super.setGrayFill(arg0);
	}

	@Override
	public void setLeft(float arg0) {
		// TODO Auto-generated method stub
		super.setLeft(arg0);
	}

	@Override
	public void setRight(float arg0) {
		// TODO Auto-generated method stub
		super.setRight(arg0);
	}

	@Override
	public void setTop(float arg0) {
		// TODO Auto-generated method stub
		super.setTop(arg0);
	}

	@Override
	public void setUseVariableBorders(boolean arg0) {
		// TODO Auto-generated method stub
		super.setUseVariableBorders(arg0);
	}

	@Override
	public void softCloneNonPositionParameters(Rectangle arg0) {
		// TODO Auto-generated method stub
		super.softCloneNonPositionParameters(arg0);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	

}
