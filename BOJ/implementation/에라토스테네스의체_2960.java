package BOJ.implementation;

import java.util.*;

public class 에라토스테네스의체_2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true); // 모든 숫자 소수로 가정

        int removeCnt = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) { // 소수라면 그 소수의 배수는 더이상 소수가 아니다.
                for (int j = i; j <= N; j += i) {
                    if (!isPrime[j]) // 이미 다른 소수의 배수가 방문해서 처리를 했기에 pass
                        continue;
                    isPrime[j] = false; // 소수가 아님을 처리하고,
                    removeCnt++; // 개수를 추가한다.
                    if (removeCnt == K) { // K가 됐을 때 출력한다.
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}
