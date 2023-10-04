package programmas.java.lv2;

import java.util.HashSet;
import java.util.Set;

public class FindPrime {
    // 1. 순열 생성 -> 소수확인
    // 2. 소수 확인 방법 -> 제곱근까지 곱했을 때 나눠지는 수가 없음
    // 3. 같은 값일 수 있으니 Set에 넣기
    public int solution(String numbers) {
        int result = 0;
        char[] nums = numbers.toCharArray();
        HashSet<Integer> numSet = new HashSet<>();
        boolean[] visited = new boolean[nums.length];

        generatePermutations(nums, new StringBuilder(), visited, numSet);

        for (int num : numSet) {
            if (isPrime(num))
                result++;
        }
        return result;
    }

    private void generatePermutations(char[] nums, StringBuilder curr, boolean[] visited, Set<Integer> numSet) {
        if (curr.length() > 0) {
            numSet.add(Integer.valueOf(curr.toString()));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.append(nums[i]);
                generatePermutations(nums, curr, visited, numSet);
                curr.deleteCharAt(curr.length() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i < (int) (Math.sqrt(num)) + 1; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
