You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.

While there is a '*', do the following operation:

Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, you can delete any of them.

Return the lexicographically smallest resulting string after removing all '*' characters.

```java
import java.util.*;

class Solution {
    public String clearStars(String s) {
        int n = s.length();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
        }

        boolean[] isRemoved = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                isRemoved[i] = true;
                for (int j = 0; j < 26; j++) {
                    if (!list.get(j).isEmpty()) {
                        isRemoved[list.get(j).get(list.get(j).size() - 1)] = true;
                        list.get(j).remove(list.get(j).size() - 1);
                        break;
                    }
                }
            } else {
                list.get(s.charAt(i) - 'a').add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!isRemoved[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
```