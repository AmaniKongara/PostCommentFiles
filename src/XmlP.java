import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Iterator;

import edu.jhu.nlp.wikipedia.*;

public class XmlP{ 
  public static void main(String args[]) throws IOException {
  WikiXMLParser wxsp1 = WikiXMLParserFactory.getSAXParser("E:\\sem-4\\wikitopics\\enwiki");
  
  File file = new File("E:\\sem-4\\wikitopics\\techtopics2.txt");
  File fileout = new File("E:\\sem-4\\wikitopics\\techtopics3.txt");
  BufferedReader br = new BufferedReader(new FileReader(file));
  final List<String> pages = new ArrayList<String>();
	String line;
	while ((line = br.readLine()) != null) {
	   pages.add(line.toString());
	}
	 FileOutputStream fis = new FileOutputStream(fileout);  
	  PrintStream out = new PrintStream(fis);  
	  System.setOut(out);
  try {
      wxsp1.setPageCallback(new PageCallbackHandler() { 
          public void process(WikiPage page) {
                for(String pagename : pages){
                  if(page.getCategories().contains(pagename)){
                 	 System.out.println(page.getTitle());
                  }
                }
              
          }
}); 
     
     wxsp1.parse();
     fis.close();
     out.close();
  }catch(Exception e) {
          e.printStackTrace();
  }
  }
}