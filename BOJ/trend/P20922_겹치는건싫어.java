package BOJ.trend;

import java.util.*;
import java.io.*;

public class P20922_겹치는건싫어 {

    // 슬라이딩윈도우
    // l, r, maxLength. 배열 순회하면서 갯수 세기 + 최댓값 할당
    // 해당 지점의 갯수가 K를 초과한다면?
    // 1. l을 r지점까지 올리면서 count[l]--;

    static class Problem {
        int N, K;
        int[] data;
        int[] count = new int [100_001];

        int solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int l = 0, maxLength = 0;
            for (int r = 0; r < N; r++) {
                int num = data[r];
                count[num]++;

                while (count[num] > K) {
                    count[data[l]]--;
                    l++;
                }
                maxLength = Math.max(maxLength, r - l + 1);
            }

            return maxLength;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
