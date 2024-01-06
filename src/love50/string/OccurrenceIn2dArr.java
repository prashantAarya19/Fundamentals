package love50.string;

public class OccurrenceIn2dArr {
    public static void main(String[] args) {
//        char[][] arr = {
//                {'D','D','D','G','D','D'},
//                {'B','B','D','E','B','S'},
//                {'B','S','K','E','B','K'},
//                {'D','D','D','D','D','E'},
//                {'D','D','D','D','D','E'},
//                {'D','D','D','D','D','G'}
//        };
//
//        String needle = "GEEKS";
        char[][] arr = {
                {'B','B','M','B','B','B'},
                {'C','B','A','B','B','B'},
                {'I','B','G','B','B','B'},
                {'G','B','I','B','B','B'},
                {'A','B','C','B','B','B'},
                {'M','C','I','G','A','M'}
        };
        String needle = "MAGIC";
        int needleLength = needle.length();
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                count += solve(arr, needle, needleLength, i, j, 0);
            }
        }
        System.out.println(count);
    }

    private static int solve(char[][] arr, String needle, int needleLength, int row, int col, int index) {
        int count = 0;
        if(row >= 0 && col >= 0
                && row < arr.length && col < arr[row].length
                && index < needleLength && needle.charAt(index) == arr[row][col]) {
            char temp = arr[row][col];
            arr[row][col] = 0;
            index += 1;

            if(index == needleLength)
                count = 1;
            else {
                count += solve(arr, needle, needleLength, row + 1, col, index);
                count += solve(arr, needle, needleLength, row - 1, col, index);
                count += solve(arr, needle, needleLength, row, col + 1, index);
                count += solve(arr, needle, needleLength, row, col - 1, index);
            }
            arr[row][col] = temp;
        }
        return count;
    }
}
