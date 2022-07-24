package math;

import binarySearchTree.BinarySearchTree;
import recursion.SortedArray;

import java.util.*;

public class Sum {
    static Sum s = null;
    public static int sum(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            System.out.println("carry : "+ carry);
            a = a ^ b;
            System.out.println("a : "+ a);
            b = carry << 1;
            System.out.println("b : "+ b);
        }
        return a;
    }

    public void p(Sum s) {
        s = new Sum();
    }

    public static void main(String[] args) {
//        int a = 5, b = 6;
//        System.out.println("sum : "+sum(a, b));
//        System.out.println((a = a + 2)+(b = b+6));
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(3);
        l.remove(l.size() - 1);
        System.out.println(l);
        Map<String, Boolean> mp = new HashMap<>();
        System.out.println(Integer.MAX_VALUE);
    }
}
