
import edu.jhu.nlp.wikipedia.*;

public class XmlParser{ 
  public static void main(String args[]) {
  edu.jhu.nlp.wikipedia.WikiXMLParser wxsp = WikiXMLParserFactory.getSAXParser("E:\\ss.xml");
  //File outputfile = new File("E:\\sem-4\\wikitopics\\looptopics.txt");
  try {
	  /*FileOutputStream fis = new FileOutputStream(outputfile);  
	  PrintStream out = new PrintStream(fis);  
	  System.setOut(out);*/
	  final String str = "Outline of computer science";
	 // final Vector<String> vc=new Vector<String>();
      wxsp.setPageCallback(new PageCallbackHandler() { 
                     public void process(WikiPage page) {
                    	 System.out.println(page.getLinks());
                    	/* if(page.getTitle().contains(str)){
                    	 vc.addAll(page.getLinks());
                    	 for(String st : vc){
                    		 vc.remove(st);
                    		 process(page);
                    	 }
                    	 }
                    	 else if(vc != null){
                    		 for(String st : vc){
                        		 vc.remove(st);
                        		 process(page);
                    		 }
                    	 }*/
                     }
      });   
      wxsp.parse();
     /*fis.close();
     out.close();*/
  }catch(Exception e) {
          e.printStackTrace();
  }
  }
}