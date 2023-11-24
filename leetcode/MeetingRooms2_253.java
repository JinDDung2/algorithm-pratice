package leetcode;

import java.util.*;

// 253. Meeting Rooms II
public class MeetingRooms2_253 {
    public static void main(String[] args) {
        MeetingRooms2_253 o = new MeetingRooms2_253();
        int[][] arr1 = {
                { 0, 30 },
                { 5, 10 },
                { 15, 20 }
        };

        int[][] arr2 = {
                { 7, 10 },
                { 2, 4 }
        };

        int[][] arr3 = {
                { 3, 6 },
                { 6, 10 },
                { 10, 12 },
                { 12, 15 },
                { 15, 30 },
        };
        System.out.println(o.minMeetingRooms(arr1));
        System.out.println(o.minMeetingRooms(arr2));
        System.out.println(o.minMeetingRooms(arr3));
    }

    // arr[1] 정렬 -> arr[0] 정렬
    // for i in range (1, n)
    // if (arr[i][0] < end): room++
    // end = arr[i][1]
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (arr1, arr2) -> {
            if (arr1[1] == arr2[1]) {
                return Integer.compare(arr1[0], arr2[0]);
            } else {
                return Integer.compare(arr1[1], arr2[1]);
            }
        });

        // for (int[] arr : intervals) {
        // System.out.println(Arrays.toString(arr));
        // }

        int end = intervals[0][1];
        int room = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                room++;
            }
            end = intervals[i][1];
        }
        return room;

    }
}
