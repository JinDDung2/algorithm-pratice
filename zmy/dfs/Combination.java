package zmy.dfs;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public List<List<Integer>> generateCombinations(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, k, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // 선택
            backtrack(nums, k, i + 1, current, result); // 다음 단계 탐색
            current.remove(current.size() - 1); // 백트래킹 (원상 복구)
        }
    }

    public static void main(String[] args) {
        Combination p = new Combination();
        int[] nums = {1, 2, 3, 4}; // 입력 배열
        int k = 2; // 조합 크기
        List<List<Integer>> combinations = p.generateCombinations(nums, k);
        System.out.println(combinations); // [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }
}
