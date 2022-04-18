package arrays.binarySearch;

public class PeekIndexInMountain {
    public static int getPeekIndexInMountain(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        int mid = s+(e-s)/2;

        if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
            return mid;
        }
        while(s < e) {
            if(arr[mid] < arr[mid+1]) {
                s = mid+1;
            } else {
                e = mid;
            }
            mid = s+(e-s)/2;
        }
        return s;
    }

    public static void main(String[] args) {
        int[] arr ={3,4,5,1};

        System.out.println(getPeekIndexInMountain(arr));
    }
}
