package arrays;

public class FindIntersection {

    public static void findIntersection(int[] arr1, int[] arr2) {
        int i = 0;
        String resultantString = "";

        while(i < arr1.length) {
            int j = 0;
            while(j < arr2.length) {
                if(arr1[i] == arr2[j]) {
                    resultantString = resultantString+" "+arr1[i];
                }
                ++j;
            }
            ++i;
        }

        System.out.println(resultantString);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 6};
        int[] arr2 = {3, 0, 1};

        findIntersection(arr1, arr2);

    }
}
