package arrays.binarySearch;

public class SquareRootOfNumber {
    public static long findSquareRoot(long n) {
        if(n == 1) {
            return 1;
        }
        long s = 0;
        long e = n/2;
        long mid = s+(e-s)/2;

        while(s<=e) {
            long sqrt = mid*mid;
            if(sqrt == n) {
                return mid;
            } else if(sqrt < n) {
                s = mid+1;
            } else {
                e = mid-1;
            }
            mid = s+(e-s)/2;
        }
        System.out.println("start:"+s+" end:"+e+" mid:"+mid);
        return e;
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(1));
    }
}
