package mySearchEngine;

import java.util.ArrayList;
import java.util.List;

public class Result {
	public String fileName;
	public int frequency;
	List<Integer> frequency2 = new ArrayList<Integer>();
	
	public float pageRank;
	
	public Result(String fileName, float pagerank) {
		this.fileName = fileName;
		this.frequency = (int) pagerank;
		this.pageRank = pagerank;
	}

}
