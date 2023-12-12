package leetcode;

// 151. Reverse Words in a String
public class ReverseWordsInString_151 {
    public String reverseWordsV2(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i > 0; i--) {
            if (strs[i].equals(""))
                continue;
            sb.append(strs[i]).append(" ");
        }
        return sb.append(strs[0]).toString();
    }

    public String reverseWordsV1(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals(""))
                continue;
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
