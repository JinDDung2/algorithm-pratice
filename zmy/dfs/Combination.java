package zmy.dfs;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    List<List<Integer>> generateCombinations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackV1(nums, 0, new ArrayList<>(), result);

        return result;
    }

    void backtrackV1(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() > nums.length) {
            return;
        }

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // 선택
            backtrackV1(nums, i + 1, current, result); // 다음 단계 탐색
            current.remove(current.size() - 1); // 백트래킹 (원상 복구)
        }
    }

    List<List<Integer>> findCombinationsWithTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackV2(nums, 0, new ArrayList<>(), result, target, 0);
        return result;
    }

    void backtrackV2(int[] nums, int start, List<Integer> current, List<List<Integer>> result, int target, int sum) {
        if (current.size() > nums.length) {
            return;
        }

        if (sum == target) { // target과 같은 경우만 저장
            result.add(new ArrayList<>(current));
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // 선택
            backtrackV2(nums, i + 1, current, result, target, sum + nums[i]); // 합 업데이트
            current.remove(current.size() - 1); // 백트래킹 (원상 복구)
        }
    }

    public static void main(String[] args) {
        Combination p = new Combination();
        int[] nums1 = {1, 2, 3, 4}; // 입력 배열
        List<List<Integer>> combinations = p.generateCombinations(nums1);
        System.out.println(combinations);

        int[] nums2 = {1, 2, 3, 4, 5}; // 입력 배열
        int target = 7; // 목표 합
        List<List<Integer>> combinationsWithTarget = p.findCombinationsWithTarget(nums2, target);
        System.out.println(combinationsWithTarget); // [[1, 2, 4], [2, 5], [3, 4]]
    }
}
