package leetcode;

// 151. Reverse Words in a String

import java.util.Arrays;

public class Reverse_Words_in_a_String_151 {

    public String reverseWordsV2(String s) {
        // no split, trim, sb
        return "";
    }

    public String reverseWordsV1(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        System.out.println(Arrays.toString(strs));
        for (int i = strs.length - 1; i > 0; i--) {
            sb.append(strs[i]).append(" ");
        }
        sb.append(strs[0]);

        return sb.toString();
    }
}
