package leetcode;

public class ValidPalindrome_II_680 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isVaild(s, l + 1, r) || isVaild(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isVaild(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
