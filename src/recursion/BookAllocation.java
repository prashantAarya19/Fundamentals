package recursion;

public class BookAllocation {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 60 ,80};

        /* k = 3
        case 1 = (10) (20) (30 40 60 80) 210
        case 2 = (10 20) (30 40) (60 80) 140
        case 3 = (10 20 30) (40 60) (80) 100
        case 4 = (10 20 30 40) (60) (80) 100
        case 5 = (10 20 30 40 60) (80) -- failed
        result = 100
         */
        /* k = 3
        case 1: (10) (20) (30 40) -> max = 70
        case 2: (10 20) (30) (40) -> max = 40;
        case 3: (10 20 30) -> break condition
        result = 40;
         */

        /* k = 2
        case 1: (10) (20 30 40) -> max = 90
        case 2: (10 20) (30 40) -> max = 70
        case 3: (10 20 30) (40) -> max = 60
        result = 60

        s = 0 e = 100 mid = 50
        s = 0 e = 49 mid = 24
        s = 25 e = 49 mid = 37

         */

        int maxPages = 0;

        for(int i : arr) {
            maxPages += i;
        }

        System.out.println(minPagesAllocated(arr, 3, maxPages, 0));

    }

    private static int minPagesAllocated(int[] arr, int k, int maxPages, int minPages) {
        if(arr.length == 1) {
            return -1;
        }

        int midPages = minPages + (maxPages - minPages)/2;

        if(minPages > maxPages) {
            return midPages;
        }

        if(isPossibleAllocation(arr, midPages, k, 1, 0, 0)) {
            return minPagesAllocated(arr, k, midPages - 1, minPages);
        } else {
            return minPagesAllocated(arr, k, maxPages, midPages + 1);
        }
    }

    private static boolean isPossibleAllocation(int[] arr, int midPages, int k, int studentCount,
                                                int allocatedPages, int i) {
        if(studentCount > k) {
            return false;
        }
        if(i > arr.length - 1) {
            return true;
        }

        if(arr[i] > midPages) {
            return false;
        }



        if(allocatedPages + arr[i] <= midPages) {
           return isPossibleAllocation(arr, midPages, k, studentCount, (allocatedPages + arr[i]), ++i);
        } else {
            return isPossibleAllocation(arr, midPages, k, ++studentCount, arr[i], ++i);
        }
    }

    public static void printArray(int[] arr, int i) {
        int s = 0;

        while(s <= i) {
            System.out.print(arr[s]+" ");
            ++s;
        }
        System.out.println("\n <== end ===>");
    }

}
