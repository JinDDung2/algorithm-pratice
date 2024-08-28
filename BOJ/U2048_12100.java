package BOJ;

import java.io.*;
import java.util.*;

// [G1] 12100. 2048(EASY)

public class U2048_12100 {

    static int result = 0;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        len = Integer.parseInt(br.readLine());
        int[][] data = new int[len][len];
        StringTokenizer st;
        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, data);
        System.out.println(result);
    }

    private static void dfs(int depth, int[][] data) {
        if (depth == 5) {
            result = Math.max(result, getMaxBlock(data));
            return;
        }

        // Move up, down, left, right using copies of the original data
        dfs(depth + 1, moveUp(copy(data)));
        dfs(depth + 1, moveDown(copy(data)));
        dfs(depth + 1, moveLeft(copy(data)));
        dfs(depth + 1, moveRight(copy(data)));
    }

    private static int[][] copy(int[][] data) {
        int[][] copy = new int[len][len];
        for (int i = 0; i < len; i++) {
            System.arraycopy(data[i], 0, copy[i], 0, len);
        }
        return copy;
    }

    private static int[][] moveUp(int[][] data) {
        int[][] newData = new int[len][len];
        boolean[][] merged = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            int pos = 0;
            for (int i = 0; i < len; i++) {
                if (data[i][j] != 0) {
                    int val = data[i][j];
                    if (pos > 0 && newData[pos - 1][j] == val && !merged[pos - 1][j]) {
                        newData[pos - 1][j] *= 2;
                        merged[pos - 1][j] = true;
                    } else {
                        newData[pos][j] = val;
                        pos++;
                    }
                }
            }
        }
        return newData;
    }

    private static int[][] moveDown(int[][] data) {
        int[][] newData = new int[len][len];
        boolean[][] merged = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            int pos = len - 1;
            for (int i = len - 1; i >= 0; i--) {
                if (data[i][j] != 0) {
                    int val = data[i][j];
                    if (pos < len - 1 && newData[pos + 1][j] == val && !merged[pos + 1][j]) {
                        newData[pos + 1][j] *= 2;
                        merged[pos + 1][j] = true;
                    } else {
                        newData[pos][j] = val;
                        pos--;
                    }
                }
            }
        }
        return newData;
    }

    private static int[][] moveLeft(int[][] data) {
        int[][] newData = new int[len][len];
        boolean[][] merged = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            int pos = 0;
            for (int j = 0; j < len; j++) {
                if (data[i][j] != 0) {
                    int val = data[i][j];
                    if (pos > 0 && newData[i][pos - 1] == val && !merged[i][pos - 1]) {
                        newData[i][pos - 1] *= 2;
                        merged[i][pos - 1] = true;
                    } else {
                        newData[i][pos] = val;
                        pos++;
                    }
                }
            }
        }
        return newData;
    }

    private static int[][] moveRight(int[][] data) {
        int[][] newData = new int[len][len];
        boolean[][] merged = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            int pos = len - 1;
            for (int j = len - 1; j >= 0; j--) {
                if (data[i][j] != 0) {
                    int val = data[i][j];
                    if (pos < len - 1 && newData[i][pos + 1] == val && !merged[i][pos + 1]) {
                        newData[i][pos + 1] *= 2;
                        merged[i][pos + 1] = true;
                    } else {
                        newData[i][pos] = val;
                        pos--;
                    }
                }
            }
        }
        return newData;
    }

    private static int getMaxBlock(int[][] data) {
        int max = 0;
        for (int[] d : data) {
            for (int num : d) {
                max = Math.max(max, num);
            }
        }
        return max;
    }

}
