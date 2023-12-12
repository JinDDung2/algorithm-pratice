package leetcode;

// 6. Zigzag Conversion
public class ZigzagConversion_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }

        int idx = 0;
        while (idx < n) {
            // 수직
            for (int i = 0; i < numRows && idx < n; i++) {
                arr[i].append(s.charAt(idx++));
            }
            // 우상향 대각선
            for (int i = numRows - 2; i > 0 && idx < n; i--) {
                arr[i].append(s.charAt(idx++));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : arr) {
            ans.append(sb);
        }

        return ans.toString();
    }
}