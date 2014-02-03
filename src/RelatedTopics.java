import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;



public class RelatedTopics {
	public static void main(String args[]) throws IOException{
	File topics = new File("E:\\sem-4\\thesis\\catscan data\\AllTopics.txt");
	File ftopics = new File("E:\\sem-4\\thesis\\catscan data\\Alltopicsfilter.txt");
	//File postdir = new File(args[1]);
	Set<String> s = new HashSet();
	BufferedReader br = new BufferedReader(new FileReader(topics));
	String line;
	while ((line = br.readLine()) != null) {
	   s.add(line);
	}
	br.close();
	System.out.println(s.size());
	Iterator iter = s.iterator();
	FileWriter fw = new FileWriter(ftopics.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	while (iter.hasNext()) {
		System.out.println(iter.next());
		//bw.write(iter.next()+"\n");
	}
	bw.close();
	}

}
