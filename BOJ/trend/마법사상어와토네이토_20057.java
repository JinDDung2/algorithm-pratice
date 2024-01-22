package BOJ.trend;

import java.io.*;
import java.util.*;

// [G3] 20057. 마법사 상어와 토네이도
public class 마법사상어와토네이토_20057 {
    // 계산에서 소수점 아래는 버린다
    // 시작시점: n/2, n/2 | 종료지점: 1, 1
    // 모래가 격자의 밖으로 이동할 수도 있다 -> 토네이도가 소멸되었을 때, 격자의 밖으로 나간 모래의 양을 구해보자.
    // 이동 방향 4가지
    static int N;
    static int[][] graph;
    // 좌 하 우 상
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dc = { 1, 1, 2, 2 };
    static int[][] dsx = { { 1, 1, 0, 0, 0, 0, -1, -1, -2 }, { -1, 1, -2, -1, 1, 2, -1, 1, 0 },
            { -1, -1, 0, 0, 0, 0, 1, 1, 2 }, { 1, -1, 2, 1, -1, -2, 1, -1, 0 } };
    static int[][] dsy = { { -1, 1, -2, -1, 1, 2, -1, 1, 0 }, { -1, -1, 0, 0, 0, 0, 1, 1, 2 },
            { 1, -1, 2, 1, -1, -2, 1, -1, 0 }, { 1, 1, 0, 0, 0, 0, -1, -1, -2 } };
    static int[] ratio = { 1, 1, 2, 7, 7, 2, 10, 10, 5 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 토네이도 이동: 현재위치에서 다음 위치 이동 -> 다음 위치에 모래 뿌리기 -> 이동한 위치로 현재위치 업데이트
        // 토네이도 이동횟수: 1122 -> 3344 -> 5566 -> ... (각각 2씩 증가)
        int result = moveTornado(graph);

        System.out.println(result);
        br.close();
    }

    // 토네이도 이동 -> 모래도 뿌려야함
    private static int moveTornado(int[][] graph) {
        int totalSandOut = 0;
        int n = graph.length, m = graph[0].length;
        int currX = n / 2, currY = m / 2;

        while (true) {
            for (int d = 0; d < 4; d++) {
                for (int moveCnt = 0; moveCnt < dc[d]; moveCnt++) {
                    int nextX = currX + dx[d];
                    int nextY = currY + dy[d];

                    if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                        return totalSandOut;
                    }

                    // 이동한 위치 모래 뿌리기
                    int sand = graph[nextY][nextX];
                    graph[nextY][nextX] = 0;
                    int spreadTotal = 0;

                    // x -> y할 떄 y의 모든 모래를 비율과 a로 전부 이동
                    // 1. y 값을 비율 있는 있는 곳에 전부 전파 -> (y * 비율) / 100
                    for (int spread = 0; spread < 9; spread++) {
                        int sandX = nextX + dsx[d][spread];
                        int sandY = nextY + dsy[d][spread];
                        int spreadAmount = (sand * ratio[spread]) / 100;

                        if (sandY < 0 || sandX < 0 || sandY >= n || sandX >= m) {
                            totalSandOut += spreadAmount;
                        } else {
                            graph[sandY][sandX] += spreadAmount;
                        }
                        spreadTotal += spreadAmount;
                    }

                    // 2. a값에 전파: 비율이 적혀있던 칸으로 가지 않은 남은 모래 양
                    // 2-1) 이동하는 칸에 모래가 있으면 더한다.
                    int alphaX = nextX + dx[d];
                    int alphaY = nextY + dy[d];
                    int alphaAmount = sand - spreadTotal;
                    if (alphaX < 0 || alphaY < 0 || alphaY >= n || alphaX >= m) {
                        totalSandOut += alphaAmount;
                    } else {
                        graph[alphaY][alphaX] += alphaAmount;
                    }

                    // 이동한 위치를 현재 위치로 업데이트
                    currX = nextX;
                    currY = nextY;
                }
            }

            // 횟수 업데이트
            for (int i = 0; i < 4; i++) {
                dc[i] += 2;
            }
        }
    }
}
