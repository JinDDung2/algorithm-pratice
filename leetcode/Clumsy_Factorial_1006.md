```java
class Solution {
    public int clumsy(int n) {
        int cnt = 10;
        int result = 1;
        if (n <= 4) {
            if (n <= 2) return n;
            else if (n == 3 || n == 4) return n + 3; 
        } else {
            if (n % 4 == 1 || n % 4 == 2) result = n + 2;
            else if (n % 4 == 3) result = n - 1;
            else result = n + 1;
        }
        return result;
    }
}
```

![image](https://github.com/JinDDung2/algorithm-pratice/assets/92037996/3ef6a1bb-c14a-47c0-a81b-ffed521306bb)
