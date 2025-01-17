package BOJ;

import java.util.*;
import java.io.*;

public class P2531_회전초밥 {
    static class Problem {
        int solution() throws IOException {
            // 1. 데이터 입력
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // <= 30000
            int d = Integer.parseInt(st.nextToken()); // <= 3000
            int k = Integer.parseInt(st.nextToken()); // <= 3000
            int c = Integer.parseInt(st.nextToken()); // <= d

            int[] data = new int[N * 2];
            int[] visited = new int[d + 1];

            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(br.readLine());
            }
            for (int i = N; i < 2 * N; i++) {
                data[i] = data[i - N];
            }
            // 2. 현재 종류의 개수 구하기
            int curr = 0;
            for (int i = 0; i < k; i++) {
                int num = data[i];
                if (visited[num] == 0) curr++;
                visited[num]++;
            }
            // 3. 탐색하면서 현재 종류의 개수와 최댓값 비교
            // 3.1 'c' 종류가 없다면 max+1, 없다면 pass;
            int max = curr;
            for (int i = k; i < 2 * N; i++) {
                int dequeueNum = data[i - k];
                int enqueueNum = data[i];

                visited[dequeueNum]--;
                curr -= visited[dequeueNum] == 0 ? 1 : 0;

                visited[enqueueNum]++;
                curr += visited[enqueueNum] == 1 ? 1 : 0;

                int withCoupon = visited[c] == 0 ? curr + 1 : curr;
                max = Math.max(max, withCoupon);
            }
            return max;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
