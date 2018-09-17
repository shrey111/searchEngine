package mySearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class fileReader {
	private static String inputFolder = "c:/MyWebPages/convertedtextfiles2";
	private static String inputfile = "sampledata.txt";
	private static String inputfile2 = "sampledata2.txt";
	//private static String inputfile = "MyWebPages/convertedtextfiles2/About W3C Standards.txt";
	//		private static String searchQuery = "standards";
	public static final String searchQuery = "standards-based'design";	//final can be public
	private static String searchQuery2 = "Standards ISO Studies on benefits of standards";
	

	public static void main(String[] args) {

		File inputDir = new File(inputFolder);

		//scanFolder(inputDir, searchQuery);

		read_file(inputfile2);
	}

	public static void read_file2(String filename) {
		File file = new File(filename);
		try {
			String line;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuffer stringBuffer = new StringBuffer();
			//			Scanner reader = new Scanner(file);
			while((line = reader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
				System.out.println(line);
			}
			System.out.println("\nContents of file:");
			System.out.println(stringBuffer.toString());
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void read_file(String filename) {
		File file = new File(filename);
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(line);
				String words[] = line.split(" ");
				for(String word:words) {
					System.out.println(word + "\t");
				}				
			}
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*	public static void scanFolder2(String inputFolder)
	{
		int filecount = 0;
		for (File fileName : inputFolder.) {	
			if (fileName.isFile()) {
				String inputfile = inputFolder + "/" + fileName.getName();


			}
		}
	}
	 */	public static void scanFolder(File folder, String searchQuery)
	 {
		 int filecount = folder.listFiles().length;
		 System.out.println("filecount : " + filecount);
		 for (File fileName : folder.listFiles()) {	
			 if (fileName.isFile()) {
				 String inputfile = inputFolder + "/" + fileName.getName();

				 System.out.println("input file name : " + inputfile);

				 search_file(inputfile, searchQuery);
			 }
		 }
	 }

	 public static void search_file(String inputfile, String searchQuery) {

		 File file = new File(inputfile);
		 String line;
		 Scanner sc;
		 try {
			 sc = new Scanner(file);
			 line = sc.nextLine();
			 //System.out.println("line :" + line);

			 Boolean match = sentence_match(line, searchQuery);

			 if(match) {
				 System.out.println("sentence match found in file named: " + inputfile);
			 } 
                         sc.close();

		 } catch (FileNotFoundException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }


	 }
	 public static void search_file2(String inputfile, String searchQuery) {
		 try{
			 try {
				 String content = new Scanner(new File(inputfile)).useDelimiter("\\Z").next();
				 //System.out.println("file contents are :\n" + content);
				 Boolean match = sentence_match(content, searchQuery);
				 if(match) {
					 System.out.println("match found in file named: " + inputfile);
				 } 

			 }catch(IOException io){
				 io.printStackTrace();
			 }
		 }finally {

		 }
	 }

	 public static boolean sentence_match(String content, String searchQuery) {

		 searchQuery = "(.*)"+ searchQuery +"(.*)";

		 if(content.matches(searchQuery)) {
			 return true;
		 } else {
			 return false;
		 }
	 }
}
