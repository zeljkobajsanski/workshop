package ch.adiutec.workshop.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import ch.adiutec.workshop.entities.Vehicle;
import ch.adiutec.workshop.services.ExportService;

public class ExportServiceFixtures {

	@Test
	public void export() throws Exception {
		ExportService servcie = new ExportService();
		servcie.exportVehicleData();
	}
	
	@Test
	public void exportToXsl() throws IOException {
		ExportService servcie = new ExportService();
		servcie.exportToXsl();
	}
	
	@Test
	public void importData() throws IOException {
		ExportService servcie = new ExportService();
		File file = new File(System.getProperty("catalina.base") + "/webapps/workshop/vehicles.xls");
		int fileLen = (int) file.length();
		byte[] content = new byte[fileLen];
		FileInputStream fis = new FileInputStream(file);
		fis.read(content, 0, fileLen);
		List<Vehicle> vehicles = servcie.importData(content);
		Assert.assertTrue(vehicles.size() == 2);
	}
}
