package ch.adiutec.workshop.services;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageServices {
	public  byte [] resize(byte [] img, int newW, int newH) throws IOException {  
		 
		 BufferedImage bImageFromConvert = ImageIO.read(new ByteArrayInputStream(img));

			double wNew=1;
			double hNew=1;
			
			if (bImageFromConvert.getHeight() > bImageFromConvert.getWidth()) {
				wNew =  ((double) bImageFromConvert.getWidth() * ((double)newH / bImageFromConvert.getHeight()));
				hNew = newH;
			} else {
				hNew =  (((double)bImageFromConvert.getHeight() * ((double)newW / bImageFromConvert.getWidth())));
				wNew = newW;
			}

	        int w = bImageFromConvert.getWidth();  
	        int h = bImageFromConvert.getHeight();  
	        BufferedImage dimg = new BufferedImage((int)wNew, (int)hNew, bImageFromConvert.getType());  
	        Graphics2D g = dimg.createGraphics();  
	        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
	        g.drawImage(bImageFromConvert, 0, 0, (int)wNew, (int)hNew, 0, 0, w, h, null);  
	        g.dispose();  
	         
	        
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(dimg, "png", baos);
	        byte[] bytesOut = baos.toByteArray();
	        return bytesOut;
	    } 
}
