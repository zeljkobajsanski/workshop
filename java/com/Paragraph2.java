package com;

import com.lowagie.text.Chunk;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.Paragraph;


public class Paragraph2 extends Paragraph {
	 public boolean add(Object o) {
	        if (o instanceof List) {
	            List list = (List) o;
	            list.setIndentationLeft(list.getIndentationLeft() + indentationLeft);
	            list.setIndentationRight(indentationRight);
	            return super.add(list);
	        }
	        else if (o instanceof Image) {
	            super.addSpecial(o);
	            return true;
	        }
	        else if (o instanceof Paragraph) {
	            super.add(o);
	            java.util.List chunks = getChunks();
	            if (!chunks.isEmpty()) {
	            	Chunk tmp = ((Chunk) chunks.get(chunks.size() - 1));
	            	//super.add(new Chunk("\n", tmp.getFont()));
	            }
	            else {
	            //	super.add(Chunk.NEWLINE);
	            }
	            return true;
	        }
	        return super.add(o);
	    }

}
