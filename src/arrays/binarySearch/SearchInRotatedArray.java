package arrays.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
You have been given a sorted array/list ARR consisting of ‘N’ elements. You are also given an integer ‘K’.
Now the array is rotated at some pivot point unknown to you. For example, if ARR = [ 1, 3, 5, 7, 8]. Then after rotating ARR at index 3, the array will be ARR = [7, 8, 1, 3, 5].
Now, your task is to find the index at which ‘K’ is present in ARR.
Note :
1. If ‘K’ is not present in ARR then print -1.
2. There are no duplicate elements present in ARR.
3. ARR can be rotated only in the right direction.
For example, if ARR = [12, 15, 18, 2, 4] and K = 2, then the position at which K is present in the array is 3 (0-indexed).
Follow Up
Can you do this in Logarithmic time and constant additional space?
Input Format
The first line of input contains an integer 'T' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case contains two single-space separated integers ‘N’ and ‘K’, respectively.

The second line of each test case contains ‘N’ single space-separated integers, denoting the elements of the array/list ARR.
Output Format :
For each test case return the index at which K is present in ARR.
Note:
You do not need to print anything; it has already been taken care of. Just implement the given function.
Constraints:
1 <= T <= 100
1 <= N <= 5000
0 <= K <= 10^5
0 <= ARR[i] <= 10^5

Time Limit : 1 second
Sample Input 1:
2
4 3
8 9 4 5
7 2
2 4 5 6 8 9 1
Sample Output 1:
-1
0
Explanation Of Sample Output 1:
For the first test case, 3 is not present in the array. Hence the output will be -1.

For the second test case, the occurrence of 2 is at index 0. Hence the output is 0.
Sample Input 2:
2
4 3
2 3 5 8
1 2
2
Sample Output 2:
1
0
 */
public class SearchInRotatedArray {

    public static int findPivot(List<Integer> arr, int size) {
        int start = 0;
        int end = size - 1;
        int mid = start + (end - start)/2;

        while(start < end) {
            if(arr.get(mid) >= arr.get(start)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return mid;
    }

    public static int binarySearch(List<Integer> arr, int start, int end, int key) {
        int mid = start + (end - start)/2;

        while(start <= end) {
            if(arr.get(mid) == key) {
                return mid;
            }
            if(arr.get(mid) >  key) {
                start = mid + 1;
            }

            if(arr.get(mid) < key) {
                end = mid - 1;
            }

            mid = start + (end - start)/2;
        }
        return -1;
    }

    public static int findNumber(List<Integer> arr, int size, int key) {
        int pivot = findPivot(arr, size);
        int start, end;
        if(arr.get(pivot) == key) {
            return pivot;
        } else if(arr.get(pivot) < key) {
            start = pivot + 1;
            end = size - 1;
        } else {
            end = pivot - 1;
            start = 0;
        }
        return binarySearch(arr, start, end, key);
    }



    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(9);
        arr.add(4);
        arr.add(5);
       // arr.add(4);
        // 12, 15, 18, 2, 4
        // 8 9 4 5
                //(ArrayList<Integer>) Arrays.asList(2, 3, 5, 8);

    }
}
