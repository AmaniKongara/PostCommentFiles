import java.util.*;

public class Test {

    public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<String>();
        String[] words = str.split(" ");
       
        for (int i = 0; i < words.length - n + 1; i++)
            ngrams.add(concat(words, i, i+n));
        for(int i=0;i<words.length;i++)
            ngrams.add(words[i]);
        return ngrams;
    }

    public static String concat(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append((i > start ? " " : "") + words[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
       // for (int n = 1; n <= 3; n++) {
            for (String ngram : ngrams(2, "This is my_car."))
                System.out.println(ngram);
            System.out.println();
       // }
    	//Jaccard_Cofficient jc = new Jaccard_Cofficient();
    	//double d = jc.jaccard("Travelling salesman problem k","travelling salesman");
    	//System.out.println(d);
    }
}