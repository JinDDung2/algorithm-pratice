package BOJ.class3;

import java.io.*;
import java.util.*;

// [S3] 1003. 피보나치 함수
public class 피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            final int N = Integer.parseInt(br.readLine());
            List<Integer> cntZero = new ArrayList<>();
            cntZero.add(1);
            cntZero.add(0);
            List<Integer> cntOne = new ArrayList<>();
            cntOne.add(0);
            cntOne.add(1);
            if (N >= 2) {
                for (int j = 2; j <= N; j++) {
                    cntZero.add(cntZero.get(j - 1) + cntZero.get(j - 2));
                    cntOne.add(cntOne.get(j - 1) + cntOne.get(j - 1));
                }
            }

            System.out.printf("%d %d\n", cntZero.get(N), cntOne.get(N));
        }

    }
}
