package graph.problems;

public class Pair {
    public int node;
    public int wattage;

    public Pair(int node, int wattage) {
        this.node = node;
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                ", wattage=" + wattage +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        return this.wattage - ((Pair)o).wattage;
//    }
}
