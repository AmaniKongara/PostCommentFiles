import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
 
public class Crawler {
 
	public static void main(String[] args) throws IOException {
		processPage("http://en.wikipedia.org/wiki/Theoretical_computer_science");
	}
 
	public static void processPage(String URL) throws IOException{
		Document doc = Jsoup.connect(URL).get();
		String title = doc.title();
			System.out.println(title);
 //get all links and recursively call the processPage method
		Elements links = doc.select("a[href]");
		for(Element link: links){
			String s = link.attr("title");
			String l = link.attr("href");
			System.out.println(s);
			//System.out.println("http://en.wikipedia.org/" + l);
			if(l.contains("/wiki/")){
			processPage(("http://en.wikipedia.org" + l));
			}
		}
	}
}
