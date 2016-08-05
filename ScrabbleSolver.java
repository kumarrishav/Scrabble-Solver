import java.util.*; 
import java.io.*; 

public class ScrabbleSolver {

	private HashMap<String, Integer> dictionaryScoreMap;
	private HashMap<Character, Integer> letterScoreMap;
	
	public ScrabbleSolver(File dictionary) throws FileNotFoundException{
	    letterScoreInitializer();
		dictionaryScoreMap = new HashMap<String,Integer>(); 
		Scanner input = new Scanner(dictionary);   
		while(input.hasNext()) { 
		    String currentWord = input.next().toUpperCase();
			dictionaryScoreMap.put(currentWord,wordScoreCalculator(currentWord));
		}
	}
	
	private int wordScoreCalculator(String word) {
	    int wordScore = 0;
		char[] charArray = word.toCharArray();
	    for(int i = 0; i < charArray.length; i++)
	        wordScore += letterScoreMap.get(charArray[i]);
        return wordScore;
	}
	
	private void letterScoreInitializer(){
	    letterScoreMap = new HashMap<Character,Integer>();
	}
	
}