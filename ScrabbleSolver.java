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
		letterScoreMap.put(' ',0);
		letterScoreMap.put('A',1);
		letterScoreMap.put('E',1);
		letterScoreMap.put('I',1);
		letterScoreMap.put('O',1);
		letterScoreMap.put('N',1);
		letterScoreMap.put('R',1);
		letterScoreMap.put('T',1);
		letterScoreMap.put('L',1);
		letterScoreMap.put('S',1);
		letterScoreMap.put('U',1);
		letterScoreMap.put('D',2);
		letterScoreMap.put('G',2);
		letterScoreMap.put('B',3);
		letterScoreMap.put('C',3);
		letterScoreMap.put('M',3);
		letterScoreMap.put('P',3);
		letterScoreMap.put('F',4);
		letterScoreMap.put('H',4);
		letterScoreMap.put('V',4);
		letterScoreMap.put('W',4);
		letterScoreMap.put('Y',4);
		letterScoreMap.put('K',5);
		letterScoreMap.put('J',8);
		letterScoreMap.put('X',8);
		letterScoreMap.put('Q',10);
		letterScoreMap.put('Z',10);
	}
	
}