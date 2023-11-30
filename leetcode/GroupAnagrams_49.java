package leetcode;

import java.util.*;

// 49. Group Anagrams
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // {str: [strs]}
        Map<String, List<String>> result = new HashMap<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String newWord = String.valueOf(charArray);

            if (!result.containsKey(newWord)) {
                result.put(newWord, new ArrayList<>());
            }

            result.get(newWord).add(word);
        }

        return new ArrayList<>(result.values());
    }
}
