package love50.matrix;

import java.util.*;

public class CommonElement {
    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                };
        System.out.println(findCommonElement(mat));
    }

    private static List<Integer> findCommonElement(int[][] mat) {
        Map<Integer,Integer> map = new HashMap<>();
        // store the first row
        for(int col = 0; col < mat[0].length; col++) {
            map.put(mat[0][col], 1);
        }

        List<Integer> result = new ArrayList<>();
        for(int row = 1; row < mat.length; row++) {
            for(int col = 0; col < mat[row].length; col++) {
                if(map.containsKey(mat[row][col]) && map.get(mat[row][col]) == row) {
                    map.put(mat[row][col], row+1);

                    if(row == mat.length - 1)
                        result.add(mat[row][col]);
                }
            }
        }
        return result;
    }
}
