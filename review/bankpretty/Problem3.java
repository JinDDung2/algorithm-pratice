package review.bankpretty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    int result = 0;

    public int solution(int n, int t, int money, int k) {

        if (n == t && money != k) {
            return 0;
        }

        for (int i = 1; i <= k; i++) {
            int[] arr1 = new int[i + 1];
            int[] arr2 = new int[money - i + 1];
            for (int j = 1; j < i + 1; j++) {
                arr1[j] = j;
            }

            for (int j = 1; j < money - i + 1; j++) {
                arr2[j] = j;
            }
            System.out.println("-----" + i + "-----");
            System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));
            System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
            // arr, target, currSum, depth, startIdx
            int c1 = combinationSum(arr1, k, t).size();
            int c2 = combinationSum(arr2, money - k, n - t).size();
            result += c1 * c2;
            System.out.printf("i=%d, | c1=%d, target=%d | c2=%d, target=%d | result=%d\n", i, c1, i, c2, money - i, result);
        }

        return result;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int limit) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, limit, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int limit, int target, int sum, int idx, List<Integer> temp, List<List<Integer>> result) {
        if (idx == candidates.length || sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int num = candidates[i];
            temp.add(num);
            backtrack(candidates, limit, target, sum + num, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
//        System.out.println("result1 = " + problem3.solution(2, 1, 4, 3));
        System.out.println("result2 = " + problem3.solution(3, 2, 7, 4));
//        System.out.println("1| result3 = " + problem3.solution(3, 3, 7, 4));
    }
}
