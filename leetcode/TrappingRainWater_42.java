package leetcode;

// 42. Trapping Rain Water
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        int result = 0;

        while (l < r) {
            if (lMax < rMax) {
                l++;
                if (height[l] < lMax) {
                    result += (lMax - height[l]);
                } else {
                    lMax = height[l];
                }
            } else {
                r--;
                if (height[r] < rMax) {
                    result += (rMax - height[r]);
                } else {
                    rMax = height[r];
                }
            }
        }

        return result;
    }
}
