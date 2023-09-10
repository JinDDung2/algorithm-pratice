package leetcode;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, result = 0;

        while (l < r) {
            result = Math.max(result, (r - l) * Math.min(height[l], height[r]));

            if (height[l] > height[r])
                r--;
            else
                l++;
        }

        return result;
    }
}
