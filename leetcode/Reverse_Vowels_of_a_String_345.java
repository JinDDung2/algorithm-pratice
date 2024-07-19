package leetcode;

import java.util.Stack;

public class Reverse_Vowels_of_a_String_345 {

    public String reverseVowelsWithTwopointer(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;

        while (l < r) {
            while (l < r && !isVowel(chars[l])) {
                l++;
            }

            while (l < r && !isVowel(chars[r])) {
                r--;
            }

            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            l++;
            r--;
        }

        return new String(chars);
    }
  
  public String reverseVowelsWithStack(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (isVowel(c)) {
                stack.push(c);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = stack.pop();
            }
        }

        return new String(chars);

    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
