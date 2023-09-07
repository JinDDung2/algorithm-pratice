package leetcode;

public class TimeNeededtoBuyTickets_2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            time += Math.min(tickets[i], i <= k ? tickets[k] : tickets[k] - 1);
        }

        return time;
    }

}
