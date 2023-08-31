package leetcode;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String str = "";
        int min = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }

        for (int i = 0; i < min; i++) {
            char temp = strs[0].charAt(i);
            if (isSameWord(strs, temp, i))
                str += temp;
            else
                break;
        }

        return str;
    }

    public boolean isSameWord(String[] strs, char temp, int idx) {
        for (String s : strs) {
            if (temp != s.charAt(idx))
                return false;
        }
        return true;
    }

}
