package leetcode;

import java.util.Arrays;

public class CommitOffset {
        // offset이 순서 없이 들어온다.
        // 하지만 commit은 "0부터 연속된 구간"까지만 가능하다. -> offset k를 commit 하려면 0 ~ k 가 모두 존재해야 한다
        // 매 입력마다 현재 commit 가능한 가장 큰 offset을 구해야 한다.

        // 이 문제를 풀려면 내가 무엇을 기억해야 할까?
        // 1. 지금까지 받은 offset들 = boolean[]
        // 2. 현재 commit된 마지막 offset = pointer

        // 새로운 offset이 들어오면 내 상태는 어떻게 바뀌는가?
        // 1. offset을 저장한다
        // 2. commitPointer 다음 offset이 있는지 확인한다
        // 3. 있으면 commitPointer를 증가시킨다
        // 4. 더 이상 연속되지 않을 때까지 반복xz
    public int[] commitOffsets(int[] offsets) {
        int n = offsets.length;
        int[] result = new int[n];
        boolean[] visited = new boolean[n + 1];
        int commitPointer = -1;

        for (int i = 0; i < n; i++) {
            int offset = offsets[i];
            visited[offset] = true;

            int before = commitPointer;
            while (visited[commitPointer + 1]) {
                commitPointer++;
            }

            if (commitPointer == before) {
                result[i] = -1;
            } else {
                result[i] = commitPointer;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CommitOffset commitOffset = new CommitOffset();
        int[] input1 = {0, 1, 2}; // [0, 1, 2]
        System.out.println(Arrays.toString(commitOffset.commitOffsets(input1)));
        int[] input2 = {2, 1, 0, 5, 4}; // [-1, -1, 2, -1, -1]
        System.out.println(Arrays.toString(commitOffset.commitOffsets(input2)));
        int[] input3 = {2, 1, 0, 5, 4, 3}; // [-1, -1, 2, -1, -1, 5]
        System.out.println(Arrays.toString(commitOffset.commitOffsets(input3)));
        int[] input4 = {2, 1, 0, 5, 4, 3, 9, 7, 6, 8}; // [-1, -1, 2, -1, -1, 5, -1, -1, 7, 9]
        System.out.println(Arrays.toString(commitOffset.commitOffsets(input4)));
        int[] input5 = {3, 0, 2, 4, 1, 7, 6, 5, 9}; // [-1, 0, -1, -1, 4, -1, -1, 7, -1]
        System.out.println(Arrays.toString(commitOffset.commitOffsets(input5)));
    }

}
