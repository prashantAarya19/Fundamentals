package dp;

import java.util.Arrays;
import java.util.List;

public class MaxHeighCuboids {
    public static void main(String[] args) {
        int[][] cuboids = new int[][] {{62,22,30},{50,22,30},{30,87,21}};
        maxHeight(cuboids);
    }

    public static int maxHeight(int[][] cuboids) {
        for(int[] cube : cuboids) {
            Arrays.sort(cube);
        }
        List<int[]> sortedCuboids = Arrays.stream(cuboids).sorted((a1, a2) -> {
            if(a1[0] == a2[0] && a1[1] == a2[1])
                return Integer.compare(a1[2], a2[2]);
            else if(a1[0] == a2[0])
                return Integer.compare(a1[1], a2[1]);
            else
                return Integer.compare(a1[0], a2[0]);
        }).toList();
        for(int[] i : sortedCuboids) {
            System.out.print("{");
            Arrays.stream(i).forEach(e -> System.out.print(e + " "));
            System.out.print("}\n");
        }
        return solve(sortedCuboids.size(), sortedCuboids);
    }

    private static int solve(int n, List<int[]> sortedCuboids) {
        int[] nextRow = new int[n + 1];

        for(int current = n - 1; current >= 0; current--) {
            int[] currentRow = new int[n + 1];
            for(int previous = current - 1; previous >= -1; previous--) {
                int include = 0;
                if(previous == -1 || check(sortedCuboids.get(current), sortedCuboids.get(previous)))
                    include = sortedCuboids.get(current)[2] + nextRow[current + 1];

                int exclude = nextRow[previous + 1];
                currentRow[previous + 1] = Integer.max(include, exclude);
            }
            nextRow = currentRow;
        }
        return nextRow[0];
    }

    private static boolean check(int[] current, int[] previous) {
        return (current[0] >= previous[0]) && (current[1] >= previous[1]) && (current[2] >= previous[2]);
    }
}
