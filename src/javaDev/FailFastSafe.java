package javaDev;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastSafe {
    public static void main(String[] args) {
        //CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(Integer i : list) {
            System.out.print(i +" ");
            list.add(5);
        }
    }
}
