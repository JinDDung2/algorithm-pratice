package leetcode;

// 1861. Rotating the Box
public class Rotate_The_Box_1861 {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] result = new char[m][n];

        // 뒤에서 부터 탐색하며 빈칸과 돌 스위칭
        // 장애물을 만나면 장애물 이전위치가 다시 새로운 빈칸
        for (int i = 0; i < n; i++) {
            int empty = m - 1;
            for (int j = m - 1; j >= 0; --j) {
                char c = box[i][j];
                if (c == '*') {
                    empty = j - 1;
                }
                if (c == '#') {
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    --empty;
                }
            }
        }

        // 뒤집기
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; --j) {
                result[j][n - i - 1] = box[i][j];
            }
        }

        return result;
    }
}
