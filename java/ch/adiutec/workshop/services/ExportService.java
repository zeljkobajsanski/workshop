package ch.adiutec.workshop.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jms.JMSException;

import org.apache.activemq.util.ByteArrayInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.ODocumentInputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javassist.NotFoundException;

import ch.adiutec.workshop.data.FuelTypesDao;
import ch.adiutec.workshop.data.MakersDao;
import ch.adiutec.workshop.data.ModelsDao;
import ch.adiutec.workshop.data.VehiclesDao;
import ch.adiutec.workshop.entities.FuelType;
import ch.adiutec.workshop.entities.Maker;
import ch.adiutec.workshop.entities.Model;
import ch.adiutec.workshop.entities.Vehicle;
import ch.adiutec.workshop.messaging.SaveVehicle;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

public class ExportService {
	
	private static final int MAX_IMAGE_WIDTH = 150;
	private static final int MAX_IMAGE_HEIGHT = 150;
	
	private VehiclesDao vehiclesDao = new VehiclesDao();
	private MakersDao makersDao = new MakersDao();
	private ModelsDao modelsDao = new ModelsDao();
	private FuelTypesDao fuelTypesDao = new FuelTypesDao();
	private MessagingService messagingService = new MessagingService();
	
	public void exportVehicleData(int id) throws NotFoundException {
		Vehicle vehicle = vehiclesDao.getVehicle(id);
		if (vehicle == null) {
			throw new NotFoundException("Vehicle with ID=" + id + " not found");
		}
		FileOutputStream output = null;
		Document document = new Document(PageSize.A4);
		RtfWriter2 writer = null;
		try {
			String path = System.getProperty("catalina.base") + "/webapps/workshop/vehicle.rtf";
			output = new FileOutputStream(path);
			writer = RtfWriter2.getInstance(document, output);
			document.addAuthor("ZeksDev");
			document.addCreationDate();
			document.open();

			Paragraph title = new Paragraph();
			title.setAlignment(Paragraph.ALIGN_CENTER);
			title.setFont(new Font(Font.HELVETICA, 24));
			title.add("VEHICLE DATA");
			document.add(title);
			
			Table table = new Table(3);
			table.setWidths(new float[]{170, 90, 200});
			table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
			Cell c1 = new Cell();
			c1.setBorder(Rectangle.NO_BORDER);
			c1.setRowspan(12);
			if (vehicle.getImage() != null) {
				byte[] resizedImage = vehicle.getImage();
				Image image = Image.getInstance(resizedImage);
				if (image.getWidth() > MAX_IMAGE_WIDTH || image.getHeight() > MAX_IMAGE_HEIGHT) {
					image.scaleToFit(MAX_IMAGE_WIDTH, MAX_IMAGE_HEIGHT);
				}
				c1.addElement(image);
			}
			table.addCell(c1);
			table.addCell("MAKE");
			Cell cell = new Cell();
			Phrase phrase = getPhrase();
			phrase.add(vehicle.getMaker().getName());
			cell.add(phrase);
			table.addCell(cell);
			
			table.addCell("MODEL");
			phrase = getPhrase();
			phrase.add(vehicle.getModel().getName());
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("PLATE");
			phrase = getPhrase();
			phrase.add(vehicle.getPlate());
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("YEAR");
			phrase = getPhrase();
			phrase.add(Integer.toString(vehicle.getYear()));
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("COLOR");
			phrase = getPhrase();
			phrase.add(vehicle.getColor());
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("FUEL TYPE");
			phrase = getPhrase();
			phrase.add(vehicle.getFuelType().getName());
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("CHASIS #");
			phrase = getPhrase();
			phrase.add(vehicle.getVehicleId() != null ? vehicle.getVehicleId() : "-" );
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("ENGINE #");
			phrase = getPhrase();
			phrase.add(vehicle.getEngine() != null ? vehicle.getEngine() : "-" );
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("PRICE");
			phrase = getPhrase();
			phrase.add(new DecimalFormat("#,###.00 CHF").format(vehicle.getPrice()));
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("POWER");
			phrase = getPhrase();
			phrase.add(vehicle.getPower() + " kW");
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("VOLUME");
			phrase = getPhrase();
			phrase.add(vehicle.getVolume() + " ccm");
			cell = new Cell(phrase);
			table.addCell(cell);
			
			table.addCell("WEIGHT");
			phrase = getPhrase();
			phrase.add(vehicle.getWeight() + " kg");
			cell = new Cell(phrase);
			table.addCell(cell);
	
			document.add(table);
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			document.close();
			writer.close();
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Phrase getPhrase() {
		Phrase phrase = new Phrase();
		phrase.setFont(new Font(Font.HELVETICA, 12, Font.BOLD));
		return phrase;
	}
	
	public boolean exportToXsl() throws IOException {
		List<Vehicle> allVehicles = vehiclesDao.getVehicles();
		if (allVehicles.size() == 0) return false;
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Vehicles");
		Row row = sheet.createRow(0);
		org.apache.poi.ss.usermodel.Cell cell = null;
		
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		org.apache.poi.ss.usermodel.Font font = workbook.createFont();
		font.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		
		cell = row.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("ID");

		cell = row.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("MAKE");

		
		cell = row.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("MODEL");
		
		cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("PLATE");
		
		cell = row.createCell(4);
		cell.setCellStyle(style);
		cell.setCellValue("YEAR");
		
		cell = row.createCell(5);
		cell.setCellStyle(style);
		cell.setCellValue("COLOR");
		
		cell = row.createCell(6);
		cell.setCellStyle(style);
		cell.setCellValue("FUEL TYPE");
		
		cell = row.createCell(7);
		cell.setCellStyle(style);
		cell.setCellValue("CHASIS#");
		
		cell = row.createCell(8);
		cell.setCellStyle(style);
		cell.setCellValue("ENGINE#");
		
		cell = row.createCell(9);
		cell.setCellStyle(style);
		cell.setCellValue("PRICE");
		
		cell = row.createCell(10);
		cell.setCellStyle(style);
		cell.setCellValue("POWER");
		
		cell = row.createCell(11);
		cell.setCellStyle(style);
		cell.setCellValue("VOLUME");
		
		cell = row.createCell(12);
		cell.setCellStyle(style);
		cell.setCellValue("WEIGHT");
		
		cell = row.createCell(13);
		cell.setCellStyle(style);
		cell.setCellValue("DESCRIPTION");
		
		for (int i = 0; i < allVehicles.size(); i++) {
			Vehicle vehicle = allVehicles.get(i);
			row = sheet.createRow(i + 1);
			for(int j = 0; j < 14; j++) {
				cell = row.createCell(j);
				
				switch (j) {
					case 0:
						cell.setCellValue(vehicle.getId());
						break;
					case 1:
						cell.setCellValue(vehicle.getMaker().getName());
						break;
					case 2:
						cell.setCellValue(vehicle.getModel().getName());
						break;
					case 3:
						cell.setCellValue(vehicle.getPlate());
						break;
					case 4:
						cell.setCellValue(vehicle.getYear());
						break;
					case 5:
						cell.setCellValue(vehicle.getColor());
						break;
					case 6:
						cell.setCellValue(vehicle.getFuelType() != null ? vehicle.getFuelType().getName() : "");
						break;
					case 7:
						cell.setCellValue(vehicle.getVehicleId());
						break;
					case 8:
						cell.setCellValue(vehicle.getEngine());
						break;
					case 9:
						cell.setCellValue(vehicle.getPrice());
						break;
					case 10:
						cell.setCellValue(vehicle.getPower());
						break;
					case 11:
						cell.setCellValue(vehicle.getVolume());
						break;
					case 12:
						cell.setCellValue(vehicle.getWeight());
						break;
					case 13:
						cell.setCellValue(vehicle.getDescription());
						break;
					default:
						break;
					}
				sheet.autoSizeColumn(j);
			}
		}
		
		FileOutputStream output = null;
		try {
			String path = System.getProperty("catalina.base") + "/webapps/workshop/vehicles.xls";
			output = new FileOutputStream(path);
			workbook.write(output);
			return true;
		} finally {
			output.close();
		}
	}
	
	public List<Vehicle> importData(byte[] data) throws IOException {
		Map<String, Maker> makers = new HashMap<String, Maker>();
		for (Maker maker : makersDao.getMakers()) {
			makers.put(maker.getName(), maker);
		}
		Map<String, Model> models = new HashMap<String, Model>();
		for (Model model : modelsDao.getAllModel()) {
			models.put(model.getName(), model);
		}
		Map<String, FuelType> fuelTypes = new HashMap<String, FuelType>();
		for (FuelType fuelType : fuelTypesDao.getFuelTypes()) {
			fuelTypes.put(fuelType.getName(), fuelType);
		}
		Workbook workbook = new HSSFWorkbook(new ByteArrayInputStream(data));
		Sheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		for (int i = 0; i < lastRow + 1; i++) {
			if (i == 0) continue;
			Row row = sheet.getRow(i);
			int id = row.getCell(0) != null ? (int) row.getCell(0).getNumericCellValue() : 0;
			String makerName = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null;
			String modelName = row.getCell(2) != null ? row.getCell(2).getStringCellValue() : null;
			String plate = row.getCell(3) != null ? row.getCell(3).getStringCellValue() : null;
			int year = row.getCell(4) != null ? (int) row.getCell(4).getNumericCellValue() : 0;
			String color = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : null;
			String fuelTypeName = row.getCell(6).getStringCellValue();
			String chasis = row.getCell(7) != null ? row.getCell(7).getStringCellValue() : null;
			String engine = row.getCell(8) != null ? row.getCell(8).getStringCellValue() : null;
			int price = row.getCell(9) != null ? (int) row.getCell(9).getNumericCellValue() : 0;
			int power = row.getCell(10) != null ? (int) row.getCell(10).getNumericCellValue() : 0;
			int volume = row.getCell(11) != null ? (int) row.getCell(11).getNumericCellValue() : 0;
			int weight = row.getCell(12) != null ? (int) row.getCell(12).getNumericCellValue() : 0;
			String description = row.getCell(13) != null ? row.getCell(13).getStringCellValue() : null;
			
			Maker maker = null;
			if (makers.containsKey(makerName)) {
				maker = makers.get(makerName);
			}
			if (maker == null) {
				maker = new Maker(0, makerName);
				makers.put(makerName, maker);
				makersDao.save(maker);
			}
			Model model = null;
			if (models.containsKey(modelName)) {
				model = models.get(modelName);
			}
			if (model == null) {
				model = new Model(0, modelName);
				model.setMaker(maker);
				models.put(modelName, model);
				modelsDao.save(model);
			}
			FuelType fuelType = null;
			if (fuelTypes.containsKey(fuelTypeName)) {
				fuelType = fuelTypes.get(fuelTypeName);
			}
			if (fuelType == null) {
				fuelType = new FuelType(0, fuelTypeName);
				fuelTypes.put(fuelTypeName, fuelType);
				fuelTypesDao.save(fuelType);
			}
			
			Vehicle vehicle = new Vehicle(id, maker, model, plate, chasis, engine, color, null, description, fuelType, power, year, volume, 0, weight, price, 0);
			vehiclesDao.saveVehicle(vehicle);
		}
		ArrayList<Vehicle> vehicles = vehiclesDao.getVehicles();
		try {
			messagingService.sendMessage(new SaveVehicle(vehicles, null));
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
}
