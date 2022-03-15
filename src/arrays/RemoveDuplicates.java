package arrays;

import java.util.Arrays;

/*
* Remove Duplicates from Sorted Array
* */
public class RemoveDuplicates {

    public static void main(String[] args) {
//        int arr[] = {1, 1, 2, 3, 3, 3, 4};
       int[] arr = {0,0,1,1,1,2,2,3,3,4};

       /// Arrays.stream(arr).forEach(System.out::println);

        System.out.println(removeDuplicate(arr));
    }

    public static int removeDuplicates(int[] arr) {
        int index = 1;
        int lastValidIndex = 0;
        boolean checkLastValidIndex = false;
        while(index < arr.length) {
            int temp = index;

            if(arr[temp - 1] != 0 && arr[temp - 1] == arr[index]) {
                arr[index] = 0;
                lastValidIndex = temp - 1;
                checkLastValidIndex = true;
            } else if(arr[temp - 1] == 0
                    && checkLastValidIndex
                    && arr[lastValidIndex] == arr[index]) {
                arr[index] = 0;
            } else if(arr[temp - 1] == 0) {
                continue;
            }else {
                lastValidIndex = index;
                checkLastValidIndex = false;
            }

            ++index;
        }

        resizeTheArray(arr);
        return returnCountOfNonRepeatingNumber(arr);
    }

    public static void resizeTheArray(int[] arr) {
        int i = 1;
        while(i < arr.length) {
            int next = i + 1;
            int current = i;
            if(arr[i] == 0) {
                while(next < arr.length) {
                    while(arr[next] == 0) {
                        ++next;
                    }
                    arr[current] = arr[next];
                    ++next;
                    ++current;
                }
            }
            ++i;
        }
    }

    public static int returnCountOfNonRepeatingNumber(int[] arr) {
        int current = 0;
        int count = 1;

        if(arr.length == 1) {
            return 1;
        }

        while(current < arr.length) {
            int next = current + 1;

            if(arr[current] != arr[next]) {
                ++count;
            } else {
                return count;
            }
            ++current;
        }
        return count;
    }


    public static int removeDuplicate(int[] arr) {
        int i = 1;

        if(arr.length == 1) {
            return 1;
        }

        while(i < arr.length) {
            //int j = 1;
            int previousElement = i - 1;
            int currentElement = i;

            while(arr[currentElement] == arr[previousElement]) {
                arr[currentElement] = 0;
                ++currentElement;
            }
            ++i;
        }

        resizeTheArray(arr);
        Arrays.stream(arr).forEach(System.out::print);
        return countNum(arr);
    }

    public void resizeArr(int[] arr) {
        int i = 1;


        while(i < arr.length) {
            if(arr[i] == 0) {
                int shiftTo = i;

                while(arr[i] == 0) {
                    ++i;
                }


            }
            ++i;
        }
    }

    public static int countNum(int[] arr) {
        int i = 1;
        int count = 1;

        while(i < arr.length) {
            if(arr[i] != 0) {
                ++count;
            }
            ++i;
        }
        return count;
    }




}
