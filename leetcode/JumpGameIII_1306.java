package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII_1306 {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        que.add(start);

        while(!que.isEmpty()) {
            int cur = que.poll();
            if (visited[cur]) continue;
            visited[cur] = true;

            if (arr[cur] == 0) return true;

            if (cur + arr[cur] < arr.length) que.add(cur + arr[cur]);
            if (cur - arr[cur] >= 0) que.add(cur - arr[cur]);
        }

        return false;
    }
}
