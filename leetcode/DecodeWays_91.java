package leetcode;

// 91. Decode Ways
public class DecodeWays_91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int prev = 1, pprev = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int cnt = c == '0' ? 0 : prev;

            char pc = s.charAt(i - 1);
            if (pc == '1' || (pc == '2' && c <= '6')) {
                cnt += pprev;
            }

            pprev = prev;
            prev = cnt;
        }

        return prev;
    }
}
