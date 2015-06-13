package uz.tiu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.html.InlineView;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * 
 * @author Sharofiddin Pardayev : 09.05.2015 tasvirdan matnni o'qib uni faylga
 *         yozish
 *
 */
public class ReadFromImToFile {
	String inLanguage;
	DocCreater docCreater = new DocCreater();
	public ReadFromImToFile() {

	}

	/**
	 * 
	 * @param inUrl
	 *            - kiruvchi tasvir turgan joyning manzili
	 * @param outURL
	 *            - Chiquvchi fayl turgan joyning manzili
	 * @param inLanguage
	 *            -
	 * @param outFileType
	 *            -
	 * @throws TesseractException
	 * @throws IOException
	 */
	public void readAndWriteFile(String inUrl, String outURL,
			String inLanguage, String outFileType) throws TesseractException,
			IOException {
		File imageFile = new File(inUrl);
		Tesseract instance = Tesseract.getInstance();
		instance.setLanguage(inLanguage);
	
		String stBuff;
		stBuff = instance.doOCR(imageFile);
		String mas[] = stBuff.split("\n"); 
		 String result = "";
		 int length = mas.length; 
		/* for (int i =length-1; i >= 0; i-- ) 
		 {
			 if (i != 0)
				 result += mas[i] + "\n";
			 else result += mas[i];
			 }*/
		 if(outFileType == "txt"){
			 docCreater.createTxtFile(outURL, stBuff);
		 }else if(outFileType == "doc"){
			 docCreater.createDocFile(outURL, stBuff);
		 }
	}
	
	public void setLanguage( String language )
	{
		inLanguage = language;
	}
	
	public String getlanguage()
	{
		return inLanguage;
	}
}
