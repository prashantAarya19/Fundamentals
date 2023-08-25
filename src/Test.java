import java.util.*;

public class Test extends RuntimeException{


    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7};
        System.out.println(getUpperBound(arr, 8));
        System.out.println(getLowerBound(arr, 0));
        Map<StringBuilder, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("hi");
        map.put(sb, "hello");
        System.out.println(sb.hashCode());
        sb.append("hi");
        System.out.println(sb.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // equal to or just greater than the key
    private static int getLowerBound(int[] arr, int i) {
        int s = 0;
        int e = arr.length;

        while(s < e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] < i) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    // just greater than key or the last index of the array
    private static int getUpperBound(int[] arr, int i) {
        int s = 0;
        int e = arr.length;

        while(s < e) {
            int mid = s + (e - s) / 2;
            if(arr[mid] <= i) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    private static Integer getBitCount(Integer num) {
//        return Integer.bitCount(Integer.parseInt(Integer.toBinaryString(num)));
        return Integer.bitCount(num);
    }
    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
