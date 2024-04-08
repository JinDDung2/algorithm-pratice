package BOJ.implementation;

import java.io.*;

public class 누울자리를찾아라_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] data = new char[N][N];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().trim().toCharArray();
        }

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < N; i++) {
            int space = 0;
            for (int j = 0; j < N; j++) {
                if (data[i][j] == '.') {
                    space++;
                } else {
                    if (space >= 2) {
                        horizontal++;
                    }
                    space = 0;
                }
            }

            if (space >= 2)
                horizontal++;
        }

        for (int j = 0; j < N; j++) {
            int space = 0;
            for (int i = 0; i < N; i++) {
                if (data[i][j] == '.') {
                    space++;
                } else {
                    if (space >= 2) {
                        vertical++;
                    }
                    space = 0;
                }
            }

            if (space >= 2)
                vertical++;
        }

        System.out.printf("%d %d\n", horizontal, vertical);
        br.close();
    }
}
