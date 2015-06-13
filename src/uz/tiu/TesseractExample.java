package uz.tiu;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractExample {
	public static void main(String[] args) {
		File imageFile = new File("d:\\rrr.png");
		Tesseract instance = Tesseract.getInstance();
		instance.setHocr(true);
		instance.setLanguage("eng");

		try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);

		} catch (TesseractException e) {
			System.err.println(e.getMessage());

		}
	}
}
