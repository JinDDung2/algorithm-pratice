You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.

```java
import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        List<int[]> list = new ArrayList<>();
        int[] prev = meetings[0];
        list.add(prev);

        for (int i = 1; i < meetings.length; i++) {
            int[] curr = meetings[i];
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                list.add(curr);
                prev = curr;
            }
        }

        for (int[] arr : list) {
            days -= (arr[1] - arr[0] + 1);
        }

        return days;
    }
}
```