package mySearchEngine;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.*;

public class HtmtTextConvertor {
	public static String inputDirPath = "MyWebPages";
	public static String outDirPath = inputDirPath + "/convertedtextfiles/";
	public static File inputDir = new File(inputDirPath);
	public static File outputDir = new File(outDirPath);

	public static void main(String[] args) throws IOException {
		HtmtTextConvertor convertor = new HtmtTextConvertor();
		convertor.scanFolder(inputDir);
		System.out.println("files converted to text and saved..");
	}

	public void scanFolder(File folder) throws IOException
	{
		for (final File fileName : folder.listFiles()) {	
			if (fileName.isFile()) {
				//				System.out.println("File:  "+ fileName.getName());
				convertFileToText(fileName.getName());
			}
		}
	}

	private void convertFileToText(String inputfilename) throws IOException {
		String[] fName = inputfilename.split("\\.htm");
		String fileName = fName[0];
		if (!outputDir.exists()) {
			System.out.println("creating directory: " + outputDir);
			boolean result = outputDir.mkdir();
			if (result) {
				System.out.println("DIR created");
			}
		}
		File inputfile = new File(inputDirPath + "/" + inputfilename);
		org.jsoup.nodes.Document doc = Jsoup.parse(inputfile, "UTF-8", "");	
		String outputfilename = outDirPath + fileName+ ".txt";
		String text = doc.text();
		PrintWriter out = new PrintWriter(outputfilename);
		out.println(text);
		out.close();
		
	}
}
