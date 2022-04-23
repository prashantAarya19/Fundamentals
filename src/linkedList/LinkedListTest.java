package linkedList;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        System.out.println(list);
        Integer temp = list.get(0);
        list.add(0, list.get(1));
        list.remove(1);
        list.add(1, temp);
        list.remove(2);
        System.out.println(list);

        //list.get(0,);
    }
}
