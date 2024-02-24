package bitMasking;

public class SubsetBitMasking {
    static int subset = 0;
    static int n = 4;
    public static void main(String[] args) {
        int set = 5; //{0, 1, 2, 3, 4}
        System.out.println((1 << set) - 1);
        System.out.println(1 << (set - 1));
//        addElementToSubset(2);
//        addElementToSubset(3);
//        showSubset();
//        System.out.println(subset);
    }

    private static void addElementToSubset(int elm) {
        subset = subset | (1 << (elm - 1));
    }
    private static void showSubset() {
        for(int bitPos = 0; bitPos <= n; bitPos++) {
            if((subset & (1<<bitPos)) > 0) {
                System.out.print(bitPos + 1+" ");
            }
        }
        System.out.println();
    }
}
