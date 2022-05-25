package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int i = 5;
        List<List<Integer>> lists = printTriangle(i);
        System.out.println(lists);
    }

    public static List<List<Integer>> printTriangle(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<>(row));
        }
        return allrows;
    }
}
