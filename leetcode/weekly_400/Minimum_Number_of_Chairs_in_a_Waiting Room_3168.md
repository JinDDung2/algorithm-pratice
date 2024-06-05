You are given a string s. Simulate events at each second i:

If s[i] == 'E', a person enters the waiting room and takes one of the chairs in it.
If s[i] == 'L', a person leaves the waiting room, freeing up a chair.
Return the minimum number of chairs needed so that a chair is available for every person who enters the waiting room given that it is initially empty.

```java
class Solution {
    public int minimumChairs(String s) {
        int min = 0;
        int num = 0;

        for (char c : s.toCharArray()) {
            if (c == 'E') {
                num++;
                if (num > min) {
                    min++;
                }
            } else {
                num--;
            }
        }

        return min;
    }
}
```