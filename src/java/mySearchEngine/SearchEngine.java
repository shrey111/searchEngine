package mySearchEngine;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class SearchEngine {
	private static int NUM_RESULTS_TO_DISPLAY = 10;
	private static String inputFolder = "c:/MyWebPages/convertedtextfiles";
	Hashtable<String, Hashtable<String, List<Integer>>> hashTables;
	MyHashMap hs;

	public static List<Result>  returnResults(String query) {
		String query1 = "assurance", query2 = "available";
		File inputDir = new File(inputFolder);
		SearchEngine searchengine = new SearchEngine();
		searchengine.hashTables = new Hashtable<>();
		searchengine.hs = new MyHashMap();
		searchengine.hs.scanFolder(searchengine.hashTables, inputDir);
                List<Result> list= null;
				//do {
					String[] queryList = SearchEngine.splitStringInWordList(query);
					printArray(queryList, "Query: ");
					MySpellChecker.spellChecker(queryList);
					list =searchengine.search(queryList);
				//}
				//while (query != null);
				
		
		
                return list;
	}

	public static String[] splitStringInWordList(String query) {
		query = query.toLowerCase();
		query = query.replaceAll("[^a-zA-Z0-9 ]", " ");
		query = query.replaceAll("\\s+", " ").replaceAll("^\\s+", "");
		String[] queryList = query.split(" ");
		return queryList;
	}
	
	public static void printArray(String[] input, String message) {		
		System.out.print(message);
		for (int i=0; i<input.length; i++) {
			System.out.print("["+ i + "]:" + input[i] + " ");
		}
		System.out.println("");
	}

	private List<Result> search(String[] query) {
		List<Result> results = new ArrayList<Result>();
		Enumeration names = hashTables.keys();
		while(names.hasMoreElements()) {
			String fileName = (String) names.nextElement();
			float pagerank = hs.searchWordsInsideHashTable(hashTables.get(fileName), query);

			if ( pagerank > 0) {
				Result r = new Result(fileName, pagerank);
				results.add(r);
			}
		}

		int numResults = results.size();
		System.out.println("\nmatching files are : "+ numResults);

		Collections.sort(results, new Comparator<Result>() {
			public int compare(Result a, Result b)  {
				return (int) (b.pageRank - a.pageRank);
			}
		});


		/*for( int i=0; i < Math.min(numResults, NUM_RESULTS_TO_DISPLAY); i++) {
			System.out.println((i+1) + ": PageRank: " + results.get(i).frequency + ", filename: "+ results.get(i).fileName.replace(inputFolder + "/", "")) ;
		}*/
                return results;
	}
}
