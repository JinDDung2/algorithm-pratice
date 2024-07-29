package leetcode;

public class Dota2_Senate_649 {

  public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            int a = r.poll();
            int b = d.poll();
            if (a > b) {
                d.add(n++);
            } else {
                r.add(n++);
            }
        }

        return !r.isEmpty() ? "Radiant" : "Dire";
    }
  
}
