/*
Question: Maximum Number of Words Found in Sentences
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
You are given an array of strings sentences, where each sentences[i] represents a single sentence.
Return the maximum number of words that appear in a single sentence.

Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
Output: 6
Explanation:
- The first sentence, "alice and bob love leetcode", has 5 words in total.
- The second sentence, "i think so too", has 4 words in total.
- The third sentence, "this is great thanks very much", has 6 words in total.
Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.
 */

public class _3_MaximumNumberOfWordsFoundInSentences {

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int mostWordsFound1(String[] sentences){
        int result = 0;
        for (String sentence : sentences) {
            int count = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' '){
                    count++;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int mostWordsFound2(String[] sentences) {
         int max = 0;
         for(String sentence : sentences) {
             max = Math.max(max, sentence.split(" ").length);
         }
         return max;
    }
}
