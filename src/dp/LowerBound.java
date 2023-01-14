package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerBound {
    public static void main(String[] args) {
        int[] a = {1, 3, 6, 8, 10};
        int index = getLowerBound(a, 7);
        System.out.println(a[index]);
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            l.add(0);
        }
        l.add(4, 10);
        System.out.println(l);

    }

    private static int getLowerBound(int[] a, int k) {
        int s = 0;
        int e = a.length;
        int mid;
        while(s < e) {
            mid = s + (e - s)/2;
            if(a[mid] >= k)
                e = mid;
            else
                s = mid + 1;
        }

        if(s < a.length && a[s] < k)
            return s + 1;
        else
            return s;

    }
}
