package BOJ.trend;

import java.io.*;

// [G1] 1285. 동전뒤집기
// https://lordofkangs.tistory.com/432

public class 동전뒤집기_1285 {
    // 한 행 뒤집기 or 한 열 뒤집기 (if count(T) >= 2)
    // 1. 입력받기 1(T) or 0
    // 2. for i in range(N);
    // 행 비트^
    // . for j in range(N);
    // 열 비트 ^
    // count(T) >= 2 Math.min(result, count(T));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                data[i][j] = c == 'T' ? 1 : 0;
            }
        }

        int result = Integer.MAX_VALUE;

        // 뒤집는 경우의 수 : 2^N - 1
        for (int bit = 0; bit < (1 << N) - 1; bit++) {
            int sum = 0;

            for (int j = 0; j < N; j++) {
                int tail = 0;

                for (int i = 0; i < N; i++) {
                    int cur = data[i][j];

                    if ((bit & (1 << i)) != 0) {
                        cur = flip(i, j, data);
                    }

                    if (cur == 1)
                        tail++;
                }
                sum += Math.min(tail, N - tail);
            }
            result = Math.min(result, sum);
        }

        System.out.println(result);
        br.close();
    }

    private static int flip(int i, int j, int[][] data) {
        return data[i][j] ^ 1;
    }
}
