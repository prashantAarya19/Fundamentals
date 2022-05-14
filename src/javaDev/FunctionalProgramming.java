package javaDev;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,6);
        Comparator<Integer> comp = (a, b) -> b - a;
        Integer integer = list.stream().sorted(comp).limit(2).skip(1).findFirst().get();
        List<String> listS = Arrays.asList("AB", "BC", "DE");
        Comparator<String> compS = (a, b) -> b.compareTo(a);
        List<String> collect = listS.stream().sorted(compS)
                .collect(Collectors.toList());
        System.out.println(integer);
        System.out.println(collect);
        ExecutorService e = null;
       // Comparator
        
    }

}
