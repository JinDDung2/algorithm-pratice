package leetcode;

import java.util.*;

public class Equal_Row_and_Column_Pairs_2352 {
    // {col, count}
    // row 반복하면서 result += map.getOrDefault(row, 0);
    public int equalPairsV2(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int result = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                col.add(grid[j][i]);
            }
            result += map.getOrDefault(col, 0);
        }

        return result;
    }

    public int equalPairsV1(int[][] grid) {
        int result = 0;
        List<String> rowList = new ArrayList<>();
        List<String> colList = new ArrayList<>();

        for (int[] g : grid) {
            String str = Arrays.toString(g);
            rowList.add(str);
        }

        System.out.println(rowList);

        for (int i = 0; i < grid.length; i++) {
            int[] temp = new int[grid.length];
            for (int j = 0; j < grid[0].length; j++) {
                temp[j] = grid[j][i];
            }

            String str = Arrays.toString(temp);
            colList.add(str);
        }

        for (String row : rowList) {
            for (String col : colList) {
                if (row.equals(col)) {
                    result++;
                }
            }
        }

        return result;
    }
}
