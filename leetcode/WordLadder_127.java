package leetcode;

import java.util.*;

// 127. Word Ladder
public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> que = new LinkedList<>();
        que.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int result = 1;

        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                String word = que.poll();
                if (word.equals(endWord))
                    return result;

                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;

                        String str = String.valueOf(arr);
                        if (set.contains(str) && !visited.contains(str)) {
                            que.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            result++;
        }

        return 0;
    }
}