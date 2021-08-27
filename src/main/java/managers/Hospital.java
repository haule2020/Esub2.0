package managers;

import java.io.IOException;

import managers.Doc_Reader;
import managers.Xls_Reader;

public class Hospital {
			
	public  void CreateHospital(Xls_Reader reader) throws Exception, IOException {						
		String SOURCE_FILE = reader.getCellData("config", "TEMPLATE", 2);
		String OUTPUT_WORD = reader.getCellData("config", "OUTPUT_WORD", 2);
		String OUTPUT_PDF = reader.getCellData("config", "OUTPUT_PDF", 2);
					
		//XWPFDocument doc = new XWPFDocument(OPCPackage.open(SOURCE_FILE));
		int rowcount = reader.getRowCount("data");
		System.out.println("Total Files Generating: " + (rowcount - 1));

		for (int i = 2; i <=rowcount; i++) {

			String hospitalName = reader.getCellData("data", "hospitalName", i);
			String idNum = reader.getCellData("data", "idNum", i);
			String clientName = reader.getCellData("data", "clientName", i);
			String age = reader.getCellData("data", "age", i);
			String sex = reader.getCellData("data", "sex", i);
			String day1 = reader.getCellData("data", "day1", i);
			String month1 = reader.getCellData("data", "month1", i);
			String year1 = reader.getCellData("data", "year1", i);
			String day2 = reader.getCellData("data", "day2", i);
			String month2 = reader.getCellData("data", "month2", i);
			String year2 = reader.getCellData("data", "year2", i);
			String diagnosis = reader.getCellData("data", "diagnosis", i);
			String soyte = reader.getCellData("data", "soyte", i);
			String address = reader.getCellData("data", "address", i);

			// configure file name
			String output_word = OUTPUT_WORD + "\\HospitalDischarge_"+  idNum + ".docx";
			String output_pdf = OUTPUT_PDF + "\\HospitalDischarge_" + idNum + ".pdf";
			
			Doc_Reader docreader = new Doc_Reader(SOURCE_FILE);
			
			docreader.replaceTextFromTable("hospitalName", hospitalName);
			docreader.setbolt_table(hospitalName);
			docreader.replaceTextFromTable("soyte", soyte);
			docreader.setbolt_table(soyte);			
			docreader.replaceText("address", address);
			docreader.setItalic(address);			
			docreader.replaceText("age", age);
			docreader.replaceText("sex", sex);
			docreader.replaceText("clientName", clientName);
			docreader.replaceText("day1", day1);
			docreader.replaceText("month1", month1);
			docreader.replaceText("year1", year1);
			docreader.replaceText("day2", day2);
			docreader.replaceText("month2", month2);
			docreader.replaceText("year2", year2);
			docreader.replaceText("diagnosis", diagnosis);
									
			//docreader.r.setBold(true);						
			docreader.writeFile(output_word);									
			Thread.sleep(2000);
			docreader.pdfConverter(output_word, output_pdf);
		}
		System.out.println("");	
		System.out.println("Gen Document Completed!");
		Thread.sleep(5000);
					
	}

}