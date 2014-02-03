import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;


public class AllTopics {
public static void main(String args[]) throws IOException{
	Set<String> mySet = new TreeSet<String>();
	File file1 = new File("E:\\sem-4\\wikitopics\\techtopics.txt");
	File file2 = new File("E:\\sem-4\\wikitopics\\techtopics2.txt");
	File file3 = new File("E:\\sem-4\\wikitopics\\techtopics3.txt");
	File file4 = new File("E:\\sem-4\\wikitopics\\finaltechtopics.txt");
	BufferedReader br1 = new BufferedReader(new FileReader(file1));
	BufferedReader br2 = new BufferedReader(new FileReader(file2));
	BufferedReader br3 = new BufferedReader(new FileReader(file3));
    String line;
	while ((line = br1.readLine()) != null) {
	  mySet.add(line.toString());	
	}
	while ((line = br2.readLine()) != null) {
		  mySet.add(line.toString());	
	}
	while ((line = br3.readLine()) != null) {
		  mySet.add(line.toString());	
	}	
	System.out.println(mySet.size());
	
	FileOutputStream fis = new FileOutputStream(file4);  
	  PrintStream out = new PrintStream(fis);  
	  System.setOut(out);
	  java.util.Iterator<String> iter = mySet.iterator();
	  while (iter.hasNext()) {
	    System.out.println(iter.next());
	  }
	  fis.close();
	  out.close();
}
}
