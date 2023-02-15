package love50.arrays;

public class MedianOfSortedArray {
    static double medianOfArrays(int n, int m, int a[], int b[])
    {
        if(m < n)
            return medianOfArrays(m, n, b, a);

        int n1 = n, n2 = m;
        int s = 0, e = n1;

        while(s <= e) {
            int cut1 = (e + s)/2;
            int cut2 = ((n1 + n2 + 1)/2) - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];

            int r1 = cut1 == n1 ? Integer.MAX_VALUE : a[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : b[cut2];

            if(l1 <= r2 && l2 <= r1) {
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if(l1 > r2) {
                e = cut1 - 1;
            } else {
                s = cut1 + 1;
            }

        }
        return 0.0;
    }
}
