package love50.arrays;

public class MinJumps {
    public static void main(String[] args) {
        int s = 0, b = 3, c = args.length - 1;
    }

    // Brute force with TC - O(n^2)
    static int minJumps(int[] arr){
        // algo
        int s = 0, e = arr.length - 1, step = 0;

        while(s <= e) {
            int max = arr[s];
            if(arr[s] >= e) {
                break;
            }
            for(int i = s + 1; i <= arr[s]; i++) {
                if(e - arr[i] < max) {
                    max = i;
                }
            }

            if(max < 0)
                return -1;
            else {
                step++;
                s += max;
            }

        }
        return step;
    }

    static int minJumpsOptimized(int[] arr){
        if(arr.length == 1)
            return 0;

        if(arr[0] == 0)
            return -1;

        int minJumps = 1;
        int maxReach = arr[0];
        int stepsLeft = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(i == arr.length - 1)
                return minJumps;

            maxReach = Math.max(maxReach, arr[i] + i);
            --stepsLeft;

            if(stepsLeft == 0) {
                if(maxReach <= i)
                    return -1;

                ++minJumps;
                stepsLeft = maxReach - i;
            }
        }

        return -1;
    }
}
