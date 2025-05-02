package BOJ.길라잡이.backtracking;

import java.io.*;
import java.util.*;

public class P15686_치킨배달 {
    static class Problem {
        int N, M;
        int[][] data;
        List<int[]> checkinList = new ArrayList<>();
        List<int[]> homeList = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;
        void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            data = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                    if (data[i][j] == 1) {
                        homeList.add(new int[]{i, j});
                    } else if (data[i][j] == 2) {
                        checkinList.add(new int[]{i, j});
                    }
                }
            }

            backtracking(0, new ArrayList<>());
            System.out.println(minDist);
        }
        void backtracking(int start, List<int[]> selected) {
            if (selected.size() == M) {
                // 최소거리 구하기
                getMinDistance(selected);
                return;
            }

            for (int i = start; i < checkinList.size(); i++) {
                int[] node = checkinList.get(i);
                selected.add(node);
                backtracking(i + 1, selected);
                selected.remove(selected.size() - 1);
            }
        }

        void getMinDistance(List<int[]> ckList) {
            int totalDist = 0;

            for (int[] home : homeList) {
                int dist = Integer.MAX_VALUE;
                for (int[] ck : ckList) {
                    dist = Math.min(dist, Math.abs(home[0] - ck[0]) + Math.abs(home[1] - ck[1]));
                }
                totalDist += dist;
            }

            minDist = Math.min(minDist, totalDist);
        }
    }


    public static void main(String[] args) throws IOException {
        Problem problem = new Problem();
        problem.solution();
    }
}
