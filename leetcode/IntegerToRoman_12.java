package leetcode;

import java.util.*;

// 12. Integer to Roman
public class IntegerToRoman_12 {
    // 3ms
    public String intToRomanV2(int num) {
        String[] ones = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        String[] tens = { "", "X", "XX", "XXXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] hrns = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] ths = { "", "M", "MM", "MMM" };

        StringBuilder sb = new StringBuilder();
        return sb.append(ths[num / 1000]).append(hrns[(num % 1000) / 100]).append(tens[(num % 100) / 10])
                .append(ones[num % 10]).toString();
    }

    // 9ms
    public String intToRomanV1(int num) {
        // map {int:String}
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        for (int divide : map.keySet()) {
            // int mul = (num / key) / mul * String
            if (num >= divide) {
                int k = num / divide;
                for (int i = 0; i < k; i++) {
                    sb.append(map.get(divide));
                }
                // num %= key
                num %= divide;
            }
        }
        return sb.toString();
    }
}
