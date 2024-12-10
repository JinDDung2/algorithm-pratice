package swea.D4;

import java.io.*;
import java.util.*;

public class P1210_Ladder1 {
    static int N = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int testNum = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
            int[][] ladder = new int[N][N];

            // 사다리 데이터 입력
            for (int i = 0; i < N; i++) {
                ladder[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            // 마지막 행에서 값이 2인 위치 찾기
            int startCol = 0;
            for (int col = 0; col < N; col++) {
                if (ladder[N - 1][col] == 2) {
                    startCol = col;
                    break;
                }
            }

            // 탐색 시작: 아래에서 위로
            int x = N - 1;
            int y = startCol;

            while (x > 0) {
                // 좌측 이동
                if (y > 0 && ladder[x][y - 1] == 1) {
                    while (y > 0 && ladder[x][y - 1] == 1) {
                        y--;
                    }
                }
                // 우측 이동
                else if (y < N - 1 && ladder[x][y + 1] == 1) {
                    while (y < N - 1 && ladder[x][y + 1] == 1) {
                        y++;
                    }
                }
                // 위로 이동
                x--;
            }

            // 도착한 열이 출발 지점
            sb.append("#").append(test_case).append(" ").append(y).append("\n");
        }

        System.out.print(sb);
    }
}
