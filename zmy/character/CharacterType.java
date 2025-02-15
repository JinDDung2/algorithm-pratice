package zmy.character;

import java.util.HashMap;
import java.util.Map;

public class CharacterType {
    public static void main(String[] args) {
        /**
         * 1->9
         * 2->8
         * 3->7
         * ...
         * 0->0
         */
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            char key = (char) ('0' + i);
            char value = (char) ('0' + (10 - i) % 10);
            map.put(key, value);
        }

        /**
         * a -> z
         * b -> y
         * c -> x
         * ...
         * z -> a
         */
        for (char c = 'a'; c <= 'z'; c++) {
            char value = (char) ('a' + ('z' - c));
            map.put(c, value);
        }

        /**
         * A -> B
         * B -> C
         * C -> D
         * ...
         * Y -> Z
         * Z -> A
         */

        for (char c = 'A'; c < 'Z'; c++) {
            map.put(c, (char) (c + 1));
        }
        map.put('Z', 'A');
        System.out.println("map = " + map);
    }
}
