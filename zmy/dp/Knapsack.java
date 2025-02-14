package zmy.dp;

/**
 * 문제 (12865. 평범한 배낭)
 * 한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
 * 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
 * 준서가 여행에 필요하다고 생각하는 N개의 물건이 있다.
 * 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
 * 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
 * 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
 *
 * 조건
 * 물품의 수 N(1 ≤ N ≤ 100)
 * 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)
 * 각 물건의 무게 W(1 ≤ W ≤ 100,000), 각 물건의 가치 V(0 ≤ V ≤ 1,000)
 */

public class Knapsack {

    public int solution(int[][] items, int K) {
        int N = items.length;
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            weights[i] = items[i - 1][0]; // items[i-1][0] = 무게
            values[i] = items[i - 1][1];  // items[i-1][1] = 가치
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                dp[i][w] = dp[i - 1][w];

                if (weights[i] <= w) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weights[i]] + values[i]);
                }
            }
        }

        return dp[N][K];
    }

    static int max = 0;

    // O(2^N)
    public int backtracking(int[][] items, int K) {
        dfs(0, 0, 0, items, K);

        return max;
    }

    private void dfs(int depth, int weight, int value, int[][] items, int K) {
        int N = items.length;
        // 모든 물건을 확인하였으면 최종 물건의 가치를 확인하고 재귀를 종료한다.
        if (depth == N) {
            // 현재까지의 최대 가치보다 크다면 값 갱신.
            max = Math.max(max, value);
            return;
        }
        // 물건을 포함할 수 있는 경우 포함하고 재귀를 진행한다.
        if (weight + items[depth][0] <= K) {
            dfs(depth + 1, weight + items[depth][0], value + items[depth][1], items, K);
        }
        // 물건을 포함하지 않고 재귀를 진행한다.
        if (weight <= K) {
            dfs(depth + 1, weight, value, items, K);
        }
    }

    public static void main(String[] args) {
        int k = 7;
        int[][] arr = {
                {6, 13},
                {4, 8},
                {3, 6},
                {5, 12}
        };

        Knapsack knapsack = new Knapsack();
        System.out.println("dp = " + knapsack.solution(arr, k));
        System.out.println("backtracking(arr, K) = " + knapsack.backtracking(arr, k));
    }

}
