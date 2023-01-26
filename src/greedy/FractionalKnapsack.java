package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionalKnapsack  {
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    class Pair implements Comparable<Pair>{
        double perUnitValue;
        Item item;

        public Pair(double perUnitValue, Item item) {
            this.perUnitValue = perUnitValue;
            this.item = item;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.perUnitValue > p.perUnitValue)
                return -1;
            else if(this.perUnitValue < p.perUnitValue)
                return 1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "{"+this.perUnitValue+" "+this.item.weight+" "+this.item.value+"}";
        }
    }

    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            double perUnitValue = (1.0 * arr[i].value) / arr[i].weight;
            list.add(new Pair(perUnitValue, arr[i]));
        }

        Collections.sort(list);
        double maxVal = 0;

        for(int i = 0; i < n; i++) {
            if(list.get(i).item.weight > W) {
                maxVal += list.get(i).perUnitValue * W;
                W = 0;
                break;
            } else {
                maxVal += list.get(i).item.value;
                W = W - list.get(i).item.weight;
            }
        }

        return maxVal;
    }
}
