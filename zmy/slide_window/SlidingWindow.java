package zmy.slide_window;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {

    public List<Integer> slidingWindowSum(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int windowSum = 0;
        int left = 0;

        // 초기 윈도우 설정 (첫 k개의 합 구하기)
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        result.add(windowSum);

        // 슬라이딩 윈도우 실행
        for (int right = k; right < nums.length; right++) {
            windowSum += nums[right];  // 새 요소 추가
            windowSum -= nums[left];   // 오래된 요소 제거
            left++;                    // 왼쪽 포인터 이동
            result.add(windowSum);      // 결과 저장
        }

        return result;
    }

    public static int[] minSubarrayLen(int target, int[] nums) {
        int left = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        int startIdx = -1, endIdx = -1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) { // 조건 충족 시 윈도우 줄이기
                int length = right - left + 1;

                // 최소 길이 갱신, 같은 길이일 경우 더 작은 인덱스 선택
                if (length < minLength || (length == minLength && left < startIdx)) {
                    minLength = length;
                    startIdx = left;
                    endIdx = right;
                }

                sum -= nums[left];
                left++;
            }
        }

        // 결과 반환 (부분 배열의 길이, 시작 인덱스, 끝 인덱스)
        return (minLength == Integer.MAX_VALUE) ? new int[]{0, -1, -1} : new int[]{minLength, startIdx, endIdx};
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15}; // 예제 배열
        int k = 3; // 윈도우 크기

        SlidingWindow p = new SlidingWindow();
        List<Integer> sums = p.slidingWindowSum(nums, k);
        System.out.println(sums); // [9, 15, 21, 27, 33, 39]

        int[][] testCases = {
                {2, 3, 1, 2, 4, 3}, // 예제 1
                {1, 4, 4},          // 예제 2
                {1, 1, 1, 1, 1, 1, 1, 1} // 예제 3
        };
        int[] targets = {7, 4, 11};
        for (int i = 0; i < testCases.length; i++) {
            int[] result = minSubarrayLen(targets[i], testCases[i]);
            System.out.printf("예제 %d -> 최소 길이: %d, 시작 인덱스: %d, 끝 인덱스: %d\n", i + 1, result[0], result[1], result[2]);
        }
    }
}
