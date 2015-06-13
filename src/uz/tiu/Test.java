package uz.tiu;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import net.sourceforge.tess4j.*;

class Test {
	public static void main(String[] args) throws TesseractException, IOException {
		ReadFromImToFile fromImToFile = new ReadFromImToFile();
   fromImToFile.readAndWriteFile("D:\\Folder E\\Diplom uchun\\Namunalar\\russian.jpg", "d:\\www.txt","rus", "txt");
			
	}
		}

