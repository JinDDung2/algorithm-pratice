package BOJ.dynamic_programming;

import java.io.*;
import java.util.*;

// [S1] 16194. 카드구매하기 2
public class 카드구매하기2_16194 {
    // 같은 카드 여러번 구매 가능
    // 현재 N개 카드팩 구매 단계
    // 문제 접근법 -> N번까지 반복문을 돌 때, 내가 i번째 구매한다면 이전에 있는 것들을 비교해야 한다.
    // ---
    // for i in range(1, N):
    // result = 자기자신
    // for j in range(1, <= i);
    // j장 까지 구매의 최솟값 + 나머지 카드값? -> min(result, dp[i-j] + arr[j])?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1 5 6 7
        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];
            for (int j = 1; j <= i; j++) {
                // i = 2 j = 1 -> i -> 카드를 i개 산다. -> j개가 들어있는 카드팩(들)을 산다 -> 1장 짜리 2개사겠다.
                dp[i] = Math.min(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[N]);
        br.close();
    }
}
