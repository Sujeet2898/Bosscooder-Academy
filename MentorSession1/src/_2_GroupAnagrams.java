/*
Question: Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Input: strs = [""]
Output: [[""]]

Input: strs = ["a"]
Output: [["a"]]
 */

import java.util.*;

public class _2_GroupAnagrams {

    // Time Complexity: O(N^2 * M) where N is length of sentence and M is length of word
    // Space Complexity: O(N)
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        // Here i is each string i.e word in sentence
        for(int i = 0; i < strs.length; i++){
            List<String> currentAnagram = new ArrayList<>();

            // Here j is again each string i.e word in sentence for Comparing
            for(int j = 0; j < strs.length; j++){
                if(isAnagram(strs[i], strs[j])){
                    currentAnagram.add(strs[j]);
                }
            }

            if(!result.contains(currentAnagram)) {
                result.add(currentAnagram);
            }
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);

            if (!map.containsKey(ch)){
                return false;
            }else if (map.get(ch) == 1){
                map.remove(ch);
            }else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return map.size() == 0;
    }

    // Time Complexity: O(N*M * logM) where N is length of sentence and M is length of word
    // Space Complexity: O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for(String word : strs){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);

            String temp = new String(ch); //create a sorted string
            if(map.containsKey(temp)){
                map.get(temp).add(word);
            }
            else{
                map.put(temp,new LinkedList()); //create storage for new group of anagrams
                map.get(temp).add(word);
            }
        }

        return new ArrayList<>(map.values());
    }
}
