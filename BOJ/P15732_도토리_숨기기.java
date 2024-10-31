package BOJ;

import java.io.*;
import java.util.*;

public class P15732_도토리_숨기기 {

    /**
     * @입력: n = 상자의 개수, k = 규칙의 개수, d = 도토리의 개수
     * @조건 1 <= n <= 100,000, 1 <= k <= 10,000, 1 <= d <= 1,000,000,000
     * @풀이:
     *  @1. 상자의 개수를 찾아야 하니 이분 탐색 대상은 상자의 개수
     *  O(log N)
     *  @2. 1번부터 mid 상자까지 도토리를 채웠을 때 도토리의 개수 찾기 >= d?
     *      규칙을 순회하며 count의 누적 합을 구할 것임
     *  O(K)
     *  @3. 2번에서 구한 값에 따라 mid 값 변경
     * @결론 O(K * log N) = 10,000 * 20 = 200,000
     */

    int n, k, d;
    int[][] ruleList;

    public static void main(String[] args) throws IOException {
        P15732_도토리_숨기기 sol = new P15732_도토리_숨기기();
        int result = sol.solution();

        System.out.println(result);
    }

    int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        ruleList = new int[k][3];
        for (int i = 0; i < k; i++) {
            StringTokenizer ruleString = new StringTokenizer(br.readLine());
            ruleList[i][0] = Integer.parseInt(ruleString.nextToken());
            ruleList[i][1] = Integer.parseInt(ruleString.nextToken());
            ruleList[i][2] = Integer.parseInt(ruleString.nextToken());
        }

        // 상자의 개수 -> 이진탐색
        int l = 1, r = n, answer = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (countItems(m, ruleList) >= d) {
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return answer;
    }

    long countItems(int boxNum, int[][] ruleList) {
        long count = 0;

        for (int[] rule : ruleList) {
            int start = rule[0];
            int end = rule[1];
            int interval = rule[2];

            if (boxNum >= start) {
                count += (Math.min(boxNum, end) - start) / interval + 1;
            }
        }

        return count;
    }
}
