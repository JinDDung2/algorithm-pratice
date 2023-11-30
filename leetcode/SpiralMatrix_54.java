package leetcode;

import java.util.ArrayList;
import java.util.List;

// 54. Spiral Matrix
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix == null) {
            return result;
        }

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            // 우측이동
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            // 하방이동
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // 좌측이동
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // 상방이동
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

        }

        return result;
    }
}
