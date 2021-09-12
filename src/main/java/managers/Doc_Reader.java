//package managers;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.List;
//
//import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRun;
//import org.apache.poi.xwpf.usermodel.XWPFTable;
//import org.apache.poi.xwpf.usermodel.XWPFTableCell;
//import org.apache.poi.xwpf.usermodel.XWPFTableRow;
//
//import com.spire.doc.Document;
//import com.spire.doc.FileFormat;
//
//
//
//public class Doc_Reader {
//	// public static String filename =
//	// System.getProperty("user.dir")+"\\src\\testdata\testdata.xlsx";
//	
//	public String path;
//	public String fileOutPath;
//	public FileInputStream fis = null;
//	public FileOutputStream fileOut = null;
//	public XWPFRun r;
//
//	public XWPFDocument doc = null;
//	//public XWPFParagraph p = null;
//
//	public Doc_Reader(String path) {
//		this.path = path;
//		try {		
//			fis = new FileInputStream(path);		
//			doc = new XWPFDocument(OPCPackage.open(path));		
//			fis.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void replaceText(String textFind, String textReplace ) throws Exception {
//
//		for (XWPFParagraph p : doc.getParagraphs()) {
//			List<XWPFRun> runs = p.getRuns();
//			if (runs != null) {
//				for (XWPFRun r : runs) {
//					String text = r.getText(0);
//					if (text != null && text.contains(textFind)) {
//						text = text.replace(textFind, textReplace);
//						r.setText(text, 0);
//					}
//				}
//			}
//		}
//
//	}
//
//	public void replaceTextFromTable(String textFind, String textReplace) throws Exception {
//		
//		for (XWPFTable tbl : doc.getTables()) {
//			for (XWPFTableRow row : tbl.getRows()) {
//				for (XWPFTableCell cell : row.getTableCells()) {
//					for (XWPFParagraph p : cell.getParagraphs()) {
//						for (XWPFRun r : p.getRuns()) {
//							String text = r.getText(0);
//							if (text != null && text.contains(textFind)) {
//								text = text.replace(textFind, textReplace);
//								r.setText(text, 0);
//							}
//						}
//					}
//				}
//
//			}
//		}
//	}
//	
//	public void setbolt_table(String textbolt) throws Exception {
//		for (XWPFTable tbl : doc.getTables()) {
//			for (XWPFTableRow row : tbl.getRows()) {
//				for (XWPFTableCell cell : row.getTableCells()) {
//					for (XWPFParagraph p : cell.getParagraphs()) {
//						for (XWPFRun r : p.getRuns()) {
//							String text = r.getText(0);
//							if (text != null && text.contains(textbolt)) {
//								r.setBold(true);
//							}
//						}
//					}
//				}
//
//			}
//		}
//	}
//	public void setbolt(String textbolt) throws Exception {
//		for (XWPFParagraph p : doc.getParagraphs()) {
//			List<XWPFRun> runs = p.getRuns();
//			if (runs != null) {
//				for (XWPFRun r : runs) {
//					String text = r.getText(0);
//					if (text != null && text.contains(textbolt)) {
//						r.setBold(true);
//					}
//				}
//
//			}
//		}
//	}
//	public void setItalic_table(String textbolt) throws Exception {
//		for (XWPFTable tbl : doc.getTables()) {
//			for (XWPFTableRow row : tbl.getRows()) {
//				for (XWPFTableCell cell : row.getTableCells()) {
//					for (XWPFParagraph p : cell.getParagraphs()) {
//						for (XWPFRun r : p.getRuns()) {
//							String text = r.getText(0);
//							if (text != null && text.contains(textbolt)) {
//								r.setItalic(true);
//							}
//						}
//					}
//				}
//
//			}
//		}
//	}
//	public void setItalic(String textbolt) throws Exception {
//		for (XWPFParagraph p : doc.getParagraphs()) {
//			List<XWPFRun> runs = p.getRuns();
//			if (runs != null) {
//				for (XWPFRun r : runs) {
//					String text = r.getText(0);
//					if (text != null && text.contains(textbolt)) {
//						r.setItalic(true);
//					}
//				}
//
//			}
//		}
//	}
//	public void writeFile(String fileOutPath) throws Exception {		
//								fileOut= new FileOutputStream(fileOutPath);
//								doc.write(fileOut);
//								fileOut.close();
//	}
//	
//	
//	
//	
//	public  void pdfConverter(String fSource, String fTarget) throws Exception {
//		Document doc = new Document();
//		doc.loadFromFile(fSource);		
//		doc.saveToFile(fTarget, FileFormat.PDF);	
//		doc.close();
//	
//	}	
//	
//
//	
//}