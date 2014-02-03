
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import edu.jhu.nlp.wikipedia.*;

public class CompSciTopics{ 
  public static void main(String args[]) {
  edu.jhu.nlp.wikipedia.WikiXMLParser wxsp = WikiXMLParserFactory.getSAXParser("E:\\sem-4\\thesis\\wikitopics\\enwiki");
  try {
	  final List<String> topics = new ArrayList<String>();
	  final Vector<String> vc=new Vector<String>();
	  File inputfile = new File("E:\\sem-4\\thesis\\codedata\\cstopics.txt");
	  BufferedReader br = new BufferedReader(new FileReader(inputfile));
	  String line;
	  while ((line = br.readLine()) != null) {
		  topics.add(line.toString());
		}
	  //System.out.println(topics.size());
	  /*FileOutputStream fis = new FileOutputStream(outputfile);  
	  PrintStream out = new PrintStream(fis);  
	  System.setOut(out);*/
	  //final String str = "Abstraction (computer science)";
      wxsp.setPageCallback(new PageCallbackHandler() { 
                     public void process(WikiPage page) {
                    	 for(String s : topics){
                    		 if(page.getTitle().contains(s)){
                    			 vc.addAll(page.getLinks());
                    			 //System.out.println(page.getLinks()); 
                    		 }	 
                    	 }
                    	 }  	 
      });   
      System.out.println(vc.size());
      wxsp.parse();
     /*fis.close();
     out.close();*/
  }catch(Exception e) {
          e.printStackTrace();
  }
  }
}