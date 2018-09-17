package mySearchEngine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class MyHashMap {
	public static String inputFolder = "c:/MyWebPages/convertedtextfiles";

	public void scanFolder(Hashtable<String, Hashtable<String, List<Integer>>> hashTables, final File folder)
	{
		int filecount = folder.listFiles().length;
		for (final File fileName : folder.listFiles()) {	
			if (fileName.isFile()) {
				Hashtable<String, List<Integer>> hs = new Hashtable<String, List<Integer>>();
				filecount++;
				String inputfile = inputFolder + "/" + fileName.getName();

				insertFileInHashTable(inputfile, hs);
				// System.out.println("File " + filecount + " : " + fileName.getName() + ", HashTable:" + hs);
				hashTables.put(inputfile, hs);
			}
		}
	}
	
	
	private String[] readFile(String inputfile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputfile));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
//				sb.append(System.lineSeparator());				
				line = br.readLine();
			}
			br.close();
			String fileContents = sb.toString();
			String[] words = SearchEngine.splitStringInWordList(fileContents);
			return words;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// br.close();
		}
		return null;
	}

	public void insertFileInHashTable(String inputfile, Hashtable<String, List<Integer>> hashtable) {
		String[] wordsFromFile = readFile(inputfile);
		for (int i=0; i < wordsFromFile.length; i++) {
			addWordToHashTable(wordsFromFile[i], i, hashtable);
		}
	}

	public void insertFileInHashTable_old(String inputfile, Hashtable<String, List<Integer>> hashtable) {
		File file = new File(inputfile);
		try {
			Scanner sc = new Scanner(file);
			String words;
			int index = 0;
			while (sc.hasNext()) {
				words = sc.next();
				words = words.toLowerCase();
				words = words.replaceAll("[^a-zA-Z0-9 ]", "");
				addWordToHashTable(words, index++, hashtable);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}

	public void addWordToHashTable(String word, int index, Hashtable<String, List<Integer>> hashtable) {
		List<Integer> indexList;
		if (hashtable.containsKey(word)) {
			indexList = hashtable.get(word);
		} else {
			indexList = new ArrayList<Integer>();
		}
		indexList.add(index);
		hashtable.put(word, indexList);
	}

	public void printHashTable2(Hashtable<String,Integer> hashtable) {
		System.out.println("read from hash table.." );
		Enumeration names = hashtable.keys();
		while(names.hasMoreElements()) {
			String key = (String) names.nextElement();
			System.out.println("File name: " + key + " File content: " + hashtable.get(key));
		}
	}

	public float searchWordsInsideHashTable(Hashtable<String, List<Integer>> hashtable, String[] queryList) {
		float pagerank = 0.0f;
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (String query : queryList) {
			query = query.toLowerCase();
			if (hashtable.containsKey(query)) {
				// System.out.println("Successful search, word : " + query + " |  frequency : " + hashtable.get(query));
				List<Integer> indexes = hashtable.get(query);
				results.add(indexes);
			} else {
				results.add(new ArrayList<Integer>());
			}
		}
		PageRank rank = new PageRank();
		pagerank = rank.pageRank(results);
		return pagerank;
	}
	
	public void printHashTable(Hashtable<String, Integer> hashtable) {
		for (java.util.Map.Entry<String, Integer> entry : hashtable.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

}
