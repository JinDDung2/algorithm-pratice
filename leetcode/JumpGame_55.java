package leetcode;

// 55. Jump Game
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        // 첫 시작은 0
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            // 도달 범위가 인덱스 값보다 작으면 이 특정 인덱스에 도달할 수 없다 -> Kadane 알고리즘과 유사
            if (i > reach)
                return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
}
