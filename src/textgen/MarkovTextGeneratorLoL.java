package textgen;

import java.util.*;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;

	// Mapping of word to ListNode representing it
	Map<String, ListNode> wordListNodeMap;

	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
		wordListNodeMap = new HashMap<String, ListNode>();
	}

	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		String[] sourceWords = sourceText.split("[\\s]+");
		if((wordListNodeMap.isEmpty() && wordList.size() == 0)) //if not trained only then set starter
			starter = sourceWords[0];
		int i = 0;
		for(i = 0; i < sourceWords.length - 1 ; i++) {
			updateTrainDS(sourceWords[i], sourceWords[i+1]);
		}
		updateTrainDS(sourceWords[i], starter);
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		if((wordListNodeMap.isEmpty() && wordList.size() == 0) || numWords == 0) //if not trained or num words requested is 0
			return "";
		int count = 0;
		StringBuilder generatedText = new StringBuilder();
		String currentWord = starter;
		String nextWord = null;
		generatedText.append(currentWord + ' ');
		count += 1;
		while(count < numWords) {
			nextWord = wordListNodeMap.get(currentWord).getRandomNextWord(rnGenerator);
			generatedText.append(nextWord + ' ');
			count += 1;
			currentWord = nextWord;
		}
		return generatedText.toString();
	}

	// Can be helpful for debugging
	@Override
	public String toString()
	{
		StringBuilder toReturn = new StringBuilder();
		for (ListNode n : wordList)
		{
			toReturn.append(n.toString());
		}
		return toReturn.toString();
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
		wordList = new LinkedList<ListNode>();
		wordListNodeMap = new HashMap<String, ListNode>();
		train(sourceText);
	}
	
	// TODO: Add any private helper methods you need here.
	private void updateTrainDS(String currentWord, String nextWord) {
		ListNode listNode = null;
		if(wordListNodeMap.containsKey(currentWord)) {
			listNode = wordListNodeMap.get(currentWord);
		} else {
			listNode = new ListNode(currentWord);
			wordListNodeMap.put(currentWord, listNode);
			wordList.add(listNode);
		}
		listNode.addNextWord(nextWord);
	}
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		return nextWords.get(generator.nextInt(nextWords.size()));
	}

	public String toString()
	{
		StringBuilder toReturn = new StringBuilder().append(word + ": ");
		for (String s : nextWords) {
			toReturn.append(s + "->");
		}
		toReturn.append("\n");
		return toReturn.toString();
	}
	
}


