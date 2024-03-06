package BOJ.trend;

import java.io.*;
import java.util.*;

// [G3] 16235. 나무 재테크

public class 나무재테크_16235 {
    // 봄: 나이 += 1. if 여러 개 -> 나이가 어린 나무부터, 양분은 자신의 나이만큼 못먹으면 죽는다.
    // 여름: 죽은 나무 -> 양분. (죽은 나무 / 2 = 추가될 양분, 소수점 아래 버려)
    // 가을: 번식. 나이가 5의 배수. 8칸에 나이가 1인 나무 생성.
    // 겨울: S2D2가 이동하면서 양분(A[r][c]) 추가.
    // K년이 지난 후 상도의 땅에 살아있는 나무의 개수
    static int N, M, K;
    static int[][] arr;
    static int[][] nutrients;
    static List<Tree>[][] trees;
    static int[] dy = { 1, 1, 1, 0, 0, -1, -1, -1 };
    static int[] dx = { 0, -1, 1, 1, -1, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        nutrients = new int[N][N];
        trees = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                nutrients[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees[x][y].add(new Tree(x, y, z));
        }

        while (K-- > 0) {
            springAndSummer();
            autumn();
            winter();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += trees[i][j].size();
            }
        }

        System.out.println(result);
    }

    // 봄: 나이 += 1. if 여러 개 -> 나이가 어린 나무부터, 양분은 자신의 나이만큼 못먹으면 죽는다.
    // 여름: 죽은 나무 -> 양분. (죽은 나무 / 2 = 추가될 양분, 소수점 아래 버려)
    private static void springAndSummer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (trees[i][j].isEmpty())
                    continue;

                ArrayList<Tree> survived = new ArrayList<>();
                Collections.sort(trees[i][j]);

                int dead = 0;
                for (Tree tree : trees[i][j]) {
                    if (nutrients[i][j] >= tree.age) {
                        nutrients[i][j] -= tree.age;
                        survived.add(new Tree(tree.x, tree.y, tree.age + 1));
                    } else {
                        dead += tree.age / 2;
                    }
                }

                nutrients[i][j] += dead;
                trees[i][j] = survived;
            }
        }
    }

    // 가을: 번식. 나이가 5의 배수. 8칸에 나이가 1인 나무 생성.
    private static void autumn() {
        ArrayList<Tree> news = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Tree tree : trees[i][j]) {
                    if (tree.age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = tree.x + dx[d];
                            int ny = tree.y + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                news.add(new Tree(nx, ny, 1));
                            }
                        }
                    }
                }
            }
        }

        for (Tree tree : news) {
            trees[tree.x][tree.y].add(tree);
        }
    }

    // 겨울: S2D2가 이동하면서 양분(A[r][c]) 추가.
    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrients[i][j] += arr[i][j];
            }
        }
    }

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        @Override
        public int compareTo(Tree other) {
            return Integer.compare(this.age, other.age);
        }
    }
}