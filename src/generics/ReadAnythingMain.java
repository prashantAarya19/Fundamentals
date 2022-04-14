package generics;

public class ReadAnythingMain {
    public static void main(String[] args) {
        ReadAnything<Integer> read = new ReadAnything<>(5);
        read.printAnything();
        ReadAnything<?> readString = new ReadAnything<>("hello");
        readString.printAnything();

        m("Generic method");

        System.out.println(sumAnything(3, 4));
        System.out.println(sumAnything("hi", " hello"));
        String o = (String) sumAnything(2.344, 3222.98);
        System.out.println(o);

    }

    public static <T> void m(T m) {
        System.out.println(m);
    }

    public static <T1, T2> Object sumAnything(T1 m1, T2 m2) {
        if(m1 instanceof Integer) {
            return (Integer)m1+(Integer)m2;
        } else if(m1 instanceof  String) {
            return m1 + (String) m2;
        }
        return (m1+" "+m2);
    }
}
