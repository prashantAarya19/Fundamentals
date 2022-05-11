package recursion;

public class PeekIndexInArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 111, 0};
        System.out.println(findPeekElement(arr, 0, arr.length - 1));
    }

    private static int findPeekElement(int[] arr, int s, int e) {
        if(s > e) {
            System.out.println("s:"+s+" e:"+e);
            return arr[e];
        }
        int mid = s + (e - s)/2;
        if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            System.out.println("s:" + s + " e:" + e + " m:" + mid);
            return arr[mid];
        }

        if(arr[mid] < arr[mid+1])
            return findPeekElement(arr, mid + 1, e);
        else
            return findPeekElement(arr, s, mid);
    }
}
