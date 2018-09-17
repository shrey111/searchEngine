import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import mySearchEngine.SearchEngine;
import java.net.*;
import java.io.*;

import mySearchEngine.Result;

public class HelloWorld extends HttpServlet { 
    	private static int NUM_RESULTS_TO_DISPLAY = 10;
	private static String inputFolder = "c:/MyWebPages/convertedtextfiles";
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  {		
	SearchEngine searchengine = new SearchEngine();

    // reading the user input
       List<Result> list = null;
    String query= request.getParameter("color");  
    if(query!=null&&query!=""){
       list = searchengine.returnResults(query);
    }
    PrintWriter out = response.getWriter();
    out.println (
      "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\"http://www.w3.org/TR/html4/loose.dtd\">\n" +
      "<html> \n" +
        "<head> \n" +
          "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"> \n" +
          "<title> Search Results  </title> \n" +
        "</head> \n" +
        "<body> \n <table><tr><td><b>Page Rank </b></td><td><b>Occurence Count </b></td><td><b>File Name </b></td></tr>" );
    int numResults=list.size();
   String emptyString = "";
    for( int i=0; i < Math.min(numResults, 10); i++) {
                        
			out.println("<tr><td>"+(i+1) + "</td><td>" + list.get(i).frequency + " times</td><td>"+ "<a href=" + URLEncoder.encode((list.get(i).fileName.replace(inputFolder+"/",emptyString ).replace("txt","htm")), "UTF-8") + ">" + list.get(i).fileName.replace(inputFolder+"/",emptyString ).replace(".txt","") +"</a>" ) ;
                        out.println("</td></tr>");
		}   
    out.println (
           "</table>\n"+
        "</body> \n" +
      "</html>" 
    );  
  }
	
}