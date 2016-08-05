import java.util.*; 
import java.io.*; 

public class SCrabbleSolver {
	private static int maxScore = 0;
	private static String maxWord = "";
	private HashMap<String, Integer> dictionaryScoreMap;
	private static HashMap<Character, Integer> letterScoreMap;
	public static TreeMap<String,String> FileMap ;
	public SCrabbleSolver(File dictionary) throws FileNotFoundException{
	    letterScoreInitializer();
//		dictionaryScoreMap = new HashMap<String,Integer>(); 
//		Scanner input = new Scanner(dictionary);   
//		while(input.hasNext()) { 
//		    String currentWord = input.next().toUpperCase();
//			dictionaryScoreMap.put(currentWord,wordScoreCalculator(currentWord));
//		}
	}
	
	private static void wordScoreCalculator(char[] a) {
	    int wordScore = 0;
	    //System.out.println( letterScoreMap.get(a[i]));
//	    for(int i = 0; i < a.length; i++)
//	        wordScore += letterScoreMap.get(a[i]);
	    System.out.println(wordScore);
       // compareMaxScore(wordScore, a);
	}
	
	private static void compareMaxScore(int wordScore, char[] arr){
		if(wordScore >= maxScore){
			maxWord += arr.toString() +" ";
			System.out.println(maxWord);
		}
	}
	
	/*public static int calculateScore(String s){
		char[] letters = s.toCharArray();
		int value = 0;
		for(int i = 0;i < letters.length ;i++ ){
			value += letterScoreMap.get(letters[i]);
		}
		return value;
	}*/
	
	public static void buildHashMap(){
		FileMap = new TreeMap<>();
		try{
			Scanner s = new Scanner(new File("C:/Users/mpitchai/workspace/ScrabbleScorer/src/sowpods.txt"));
			String line ="";
			while(s.hasNextLine()){
				line = s.nextLine();
				char [] a = line.toCharArray();
				Arrays.sort(a); 
				String word = "";
				for(int i = 0 ; i < a.length ; i++ ){
					word +=a[i];
				}
				FileMap.put( word , line );
			}
		}
		catch(Exception E){
			System.out.println("Exception"+E);
		}
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
	
	public static boolean isValidWord(char [] a ){
			
			
			String word = "";
			
			for(int i=0;i<a.length;i++){
				word+=a[i];
			}
			//System.out.println();
			try{
				Scanner s = new Scanner(new File("C:/Users/mpitchai/workspace/ScrabbleScorer/src/sowpods.txt"));
				String line ="";
				while(s.hasNextLine()){
					line = s.nextLine();
					if(line.equalsIgnoreCase(word)){
						System.out.println("Valid Word : " + word);
						return true;
					}
				}
			}
			catch(Exception E){
				System.out.println("Exception"+E);
			}
			
			return false;
	}
	
	
	public static void permute(char[] a ,int k)
	{
		if (k == a.length) 
        {
			if(isValidWord(a)){
				wordScoreCalculator(a);
			}
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                char temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
		
	}

	public static void Combination(String s, int n, int r)
	{
	    char arr[] = s.toCharArray();
	    char data[] = new char[r];
	    //System.out.println("Combination");
	    combinationUtil(arr, data, 0, n-1, 0, r);
	}
	
	public static void combinationUtil(char arr[], char data[], int start, int end,
            int index, int r)
	{
		
		if (index == r)
		{
			for (int j=0; j<r; j++)
			{
				//System.out.print(data[j]);
				permute(data,0);
				//System.out.println("Permutation is over ");
				
			}
			//System.out.println("");
			
			return;
		}
	
		for (int i=start; i<=end && end-i+1 >= r-index; i++){
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r);
		}
	}
	public static void main(String []args){
        
		
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		//System.out.println(input);
		//Combination(input , input.length(),3);
		/*for(int i=0 ; i<=input.length() ; i++){
			Combination(input , input.length() , i);
		}*/
		buildHashMap();
		
		for( String key : FileMap.keySet()){
			System.out.println("Key : " + key +"  Value : " + FileMap.get(key));
		}
     }
	
}