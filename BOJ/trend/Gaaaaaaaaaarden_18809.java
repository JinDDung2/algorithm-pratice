package BOJ.trend;

import java.io.*;
import java.util.*;

// [G1] 18809. Gaaaaaaaaaarden

public class Gaaaaaaaaaarden_18809 {

    static int N, M, G, R;
    static int[][] data;
    static List<int[]> availableList;
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    static int result = 0;
    static int flowers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int totalSeeds = G + R;
        data = new int[N][M];
        availableList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 2) {
                    availableList.add(new int[] { i, j });
                }
            }
        }

        // comb -> distribute -> simulate
        comb(new ArrayList<>(), totalSeeds, 0);
        System.out.println(result);
        br.close();
    }

    private static void comb(List<Integer> selected, int totalSeeds, int start) {
        if (selected.size() == totalSeeds) {
            // System.out.println(selected);
            distribute(selected, new ArrayList<>(), new ArrayList<>(), 0, 0, 0);
            return;
        }

        for (int i = start; i < availableList.size(); i++) {
            selected.add(i);
            comb(selected, totalSeeds, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    private static void distribute(List<Integer> selected, List<Integer> greenSeeds, List<Integer> redSeeds, int idx,
            int gCnt, int rCnt) {
        if (gCnt + rCnt == selected.size()) {
            if (gCnt == G && rCnt == R) {
                // System.out.println("---start---");
                // System.out.println(greenSeeds);
                // System.out.println(redSeeds);
                // System.out.println("---end---");
                simulate(greenSeeds, redSeeds);
            }
            return;
        }

        if (gCnt < G) {
            greenSeeds.add(selected.get(idx));
            distribute(selected, greenSeeds, redSeeds, idx + 1, gCnt + 1, rCnt);
            greenSeeds.remove(greenSeeds.size() - 1);
        }

        if (rCnt < R) {
            redSeeds.add(selected.get(idx));
            distribute(selected, greenSeeds, redSeeds, idx + 1, gCnt, rCnt + 1);
            redSeeds.remove(redSeeds.size() - 1);
        }
    }

    private static void simulate(List<Integer> greenSeeds, List<Integer> redSeeds) {
        int[][] tempData = new int[N][M];
        int[][] time = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(data[i], 0, tempData[i], 0, M);
        }

        Queue<int[]> gq = new LinkedList<>(), rq = new LinkedList<>();

        for (int idx : greenSeeds) {
            int[] curr = availableList.get(idx);
            int y = curr[0], x = curr[1];
            tempData[y][x] = 3;
            gq.add(new int[] { y, x, 3 }); // y, x, color
        }

        for (int idx : redSeeds) {
            int[] curr = availableList.get(idx);
            int y = curr[0], x = curr[1];
            tempData[y][x] = 4;
            rq.add(new int[] { y, x, 4 }); // y, x, color
        }

        // System.out.println("---tempData---");
        // for (int[] nums : tempData) {
        // System.out.println(Arrays.toString(nums));
        // }
        // System.out.println("---tempData---");

        flowers = 0;
        while (!gq.isEmpty() && !rq.isEmpty()) {
            int gSize = gq.size(), rSize = rq.size();

            Queue<int[]> tempGq = new LinkedList<>(), tempRq = new LinkedList<>();
            while (gSize-- > 0) {
                int[] curr = gq.poll();
                spreadSeeds(curr, tempData, time, tempGq, curr[2]);
            }

            while (rSize-- > 0) {
                int[] curr = rq.poll();
                spreadSeeds(curr, tempData, time, tempRq, curr[2]);
            }

            gq.addAll(tempGq);
            rq.addAll(tempRq);
        }

        // System.out.println("---result---");
        // for (int[] nums : tempData) {
        // System.out.println(Arrays.toString(nums));
        // }
        // System.out.println(flowers);
        // System.out.println("---result---");
        result = Math.max(result, flowers);
    }

    private static void spreadSeeds(int[] curr, int[][] tempData, int[][] time, Queue<int[]> que, int color) {
        int y = curr[0], x = curr[1];
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (isValid(ny, nx) &&
                    (tempData[ny][nx] == 1 || tempData[ny][nx] == 2) &&
                    time[ny][nx] == 0) {
                tempData[ny][nx] = color;
                time[ny][nx] = 1;
                que.add(new int[] { ny, nx, color });
            } else if (isValid(ny, nx) &&
                    tempData[ny][nx] != color &&
                    time[ny][nx] == time[y][x] + 1) {
                tempData[ny][nx] = 5;
                flowers++;
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < N && x < M;
    }
}