package programmas.java.lv3;

// [lv3] 네트워크

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] computers, boolean[] visited, int i) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(computers, visited, j);
            }
        }
    }

}
