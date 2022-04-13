package misc;


import java.util.HashMap;
import java.util.Map;

/*
Print one to 1000 in english

solution: 1
1. store 1 to 100 in a map
2. store 100's in a separate map
3. compare after 100 with 199
 */
public class Print1To1000 {

    public static void main(String[] args) {
        print1To1000InEnglish();
    }

    public static void print1To1000InEnglish() {
        int series = 100;
        int counter = 120;

        Map<Integer, String> firstNumberSeries = getFirstNumberSeries();
        Map<Integer, String> secondNumberSeries = getSecondNumberSeries();
        Map<Integer, String> endOfNumberSeries = getEndOfNumberSeries();

        while(counter <= 200) {
            int temp = counter;
            // for printing first series
            if(firstNumberSeries.containsKey(counter)) {
                System.out.println(firstNumberSeries.get(counter));
            } else if (secondNumberSeries.containsKey(counter)) {
                System.out.println(secondNumberSeries.get(counter));
            } else if (endOfNumberSeries.containsKey(counter)) {
                series = counter;
                System.out.println(endOfNumberSeries.get(counter));
            } else {
                // int seriesKey = 0;
                temp = temp - series;
                if(firstNumberSeries.containsKey(temp)) {
                    System.out.println(endOfNumberSeries.get(series)+" "+firstNumberSeries.get(temp));
                } else if (secondNumberSeries.containsKey(temp)) {
                    System.out.println(endOfNumberSeries.get(series)+" "+secondNumberSeries.get(temp));
                } else if (endOfNumberSeries.containsKey(temp)) {
                    //series = counter;
                    System.out.println(endOfNumberSeries.get(series)+" "+endOfNumberSeries.get(temp)+" "+endOfNumberSeries.get(temp));
                }
            }
            ++counter;
        }

    }

    public static Map<Integer, String> getFirstNumberSeries() {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(0, "Zero");
        numbers.put(1, "One");
        numbers.put(2, "Two");
        numbers.put(3, "Three");
        numbers.put(4, "Four");
        numbers.put(5, "Five");
        numbers.put(6, "Six");
        numbers.put(7, "Seven");
        numbers.put(8, "Eight");
        numbers.put(9, "Nine");
        return numbers;
    }

    public static Map<Integer, String> getSecondNumberSeries() {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(11, "Eleven");
        numbers.put(12, "Twelve");
        numbers.put(13, "Thirteen");
        numbers.put(14, "Fourteen");
        numbers.put(15, "Fifteen");
        numbers.put(16, "Sixteen");
        numbers.put(17, "Seventeen");
        numbers.put(18, "Eighteen");
        numbers.put(19, "Nineteen");
        return numbers;
    }

    public static Map<Integer, String> getEndOfNumberSeries() {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(10, "Ten");
        numbers.put(20, "Twenty");
        numbers.put(30, "Thirty");
        numbers.put(40, "Forty");
        numbers.put(50, "Fifty");
        numbers.put(60, "Sixty");
        numbers.put(70, "Seventy");
        numbers.put(80, "Eighty");
        numbers.put(90, "Ninety");
        numbers.put(100, "Hundred");
        numbers.put(200, "Two Hundred");
        numbers.put(300, "Three Hundred");
        numbers.put(400, "Four Hundred");
        numbers.put(500, "Five Hundred");
        numbers.put(600, "Six Hundred");
        numbers.put(700, "Seven Hundred");
        numbers.put(800, "Eight Hundred");
        numbers.put(900, "Nine Hundred");
        numbers.put(1000, "Thousand");
        return numbers;
    }
}
