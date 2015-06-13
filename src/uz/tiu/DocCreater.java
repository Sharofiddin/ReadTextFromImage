package uz.tiu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class DocCreater {

	public static void createDocFile(String fileName, String text) {

		try {
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());

			XWPFDocument doc = new XWPFDocument();
			XWPFParagraph tempParagraph = doc.createParagraph();
			XWPFRun tempRun = tempParagraph.createRun(); 
			String[] mas = text.split( "\n" );
			for (int i = 0; i < mas.length; i++) 
			{
				tempRun.setText(mas[i]);
				tempRun.addBreak();
			}
			tempRun.setFontSize(12);
			doc.write(fos);
			fos.close();
			

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void createTxtFile(String outURL, String text) {

		try {
			FileWriter fileWriter = new FileWriter(outURL);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			StringBuffer buffer = new StringBuffer();
			String[] mas = text.split("\n");
			for(int i = 0; i < mas.length; i++){
				
				buffer.append( mas[i]);
				buffer.append( System.lineSeparator());
			}
			String result = buffer.toString();
			bufferedWriter.write( result );

			bufferedWriter.flush();
			bufferedWriter.close();
			fileWriter.close();
			

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
