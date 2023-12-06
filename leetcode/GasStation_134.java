package leetcode;

// 134. Gas Station
public class GasStation_134 {
    // 완탐 O(N^2) -> X
    // 누적합 + 그리디
    // 누적 잉여량 >= 0 ? start : -1
    // 진행중인 잉여량 < 0 -> start = idx + 1
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, start = 0, surplus = 0, totalSurplus = 0;

        for (int i = 0; i < n; i++) {
            surplus += (gas[i] - cost[i]);
            totalSurplus += (gas[i] - cost[i]);
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }

        return totalSurplus >= 0 ? start : -1;
    }
}
