package BOJ;

import java.io.*;
import java.util.*;

public class P20055_컨테이너벨트위의로봇 {

    static class Problem {

        int N;
        int K;
        int[] belt;
        boolean[] robots;

        int solution() throws IOException {
            // 입력
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            belt = new int[2 * N];
            robots = new boolean[N];
            int step = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2 * N; i++) {
                belt[i] = Integer.parseInt(st.nextToken());
            }

            do {
                step++;
                // 1. 벨트 이동
                rotateBelt();
                // 2. 로봇 이동
                rotateRobot();
                // 3. 로봇 올리기
                putRobot();
                // 4. 내구도 체크
            } while (!checkDurability());

            return step;
        }

        void rotateBelt() {
            // 벨트 이동
            int last = belt[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = last;

            // 로봇도 이동해야 함
            for (int i = N - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }

            robots[0] = false; // 시작점은 로봇 올리지 않아서 없음
            robots[N - 1] = false; // N - 1은 로봇 내려서 없음
        }

        void rotateRobot() {
            for (int i = N - 2; i >= 0; i--) {
                // 로봇이 이동 조건: 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
                if (robots[i] && !robots[i + 1] && belt[i + 1] > 0) {
                    robots[i] = false;
                    robots[i + 1] = true;
                    belt[i + 1]--;
                }
            }

            robots[N - 1] = false; // N - 1은 로봇 내려서 없음
        }

        void putRobot() {
            if (belt[0] > 0) {
                belt[0]--;
                robots[0] = true;
            }
        }

        boolean checkDurability() {
            int count = 0;
            for (int i = 0; i < 2 * N; i++) {
                if (belt[i] == 0) count++;
            }

            return count >= K;
        }
    }

    public static void main(String[] args) throws IOException {
        Problem p = new Problem();
        System.out.println(p.solution());
    }
}
