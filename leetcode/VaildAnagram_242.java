package leetcode;

public class VaildAnagram_242 {
    public boolean isAnagram(String s, String t) {
        int[] num = new int[26];
        // lowercase
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            num[t.charAt(i) - 'a']--;
        }

        for (int n : num) {
            if (n != 0)
                return false;
        }

        return true;
    }
}
