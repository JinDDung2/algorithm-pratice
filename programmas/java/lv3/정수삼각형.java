package programmas.java.lv3;

// [lv3] 정수 삼각형

public class 정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) triangle[i][j] += triangle[i - 1][j];
                else if (j == triangle[i].length - 1) triangle[i][j] += triangle[i - 1][j - 1];
                else triangle[i][j] = triangle[i][j] + Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            }
        }

        for (int i = 0; i < triangle[n - 1].length; i++) {
            answer = Math.max(answer, triangle[n - 1][i]);
        }

        return answer;
    }

}
